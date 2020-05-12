package com.javainterviewpoint;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.javainterviewpoint.UserDAO;
import com.javainterviewpoint.security.*;
import com.javainterviewpoint.security.AdminUserData;
import com.javainterviewpoint.security.FeaturesData;
import com.javainterviewpoint.security.EncryptDecryptUtil;

@Component(value = "adminUserDao")
public class AdminUserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(AdminUserDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	protected Properties sqlProperties;

	@Override
	public com.javainterviewpoint.security.AdminUserData validateUser(String username,String password) {
		
		 password=EncryptDecryptUtil.encrypt(password);
		 
		 try {
			 String query = "SELECT A.*,B.ROLE_NAME FROM CSS_ADMIN_USERS A, CSS_ADMIN_ROLES B WHERE A.ROLE_ID=B.ROLE_ID AND A.USER_ID=? AND A.PASSWORD=?";
		AdminUserData adminUserData = jdbcTemplate.queryForObject
			(query,new RowMapper<AdminUserData>() {
			public AdminUserData mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminUserData userDate = new AdminUserData();
				userDate.setUserId(rs.getString("user_id"));
				userDate.setFirstName(rs.getString("first_name"));
				userDate.setLastName(rs.getString("last_name"));
				userDate.setEmailId(rs.getString("email_id"));
				userDate.setRoleId(rs.getString("role_id"));
				userDate.setDeleteInd(rs.getString("deleted_ind"));
				userDate.setRoleName(rs.getString("role_name"));
				return userDate;
			}
		},username,password);
		
		return adminUserData;
		
		 }catch(Exception e) {
			 logger.error("Error in Validate ",e);
		 }
		return null;
	}
	
	@Override
	public void createAdminUserToken(String userId,String token) {
		/*jdbcTemplate.update(sqlProperties.getProperty("SQL_INSERT_ADM_USER_LOGIN")
				,userId,token,userId);*/
	
	}
	
	@Override
	public AdminUserData getAdminToken(String username) {
		
		try {
			String query="SELECT * FROM CSS_ADMIN_LOGINS WHERE ADMIN_USER_ID=? AND EXP_DATE > SYSDATE()-8/24 AND LIMIT <=1";
			
	AdminUserData adminUserData = jdbcTemplate.queryForObject
			(query,new RowMapper<AdminUserData>() {
			public AdminUserData mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminUserData userData = new AdminUserData();
				userData.setUserToken(rs.getString("token"));
				return userData;
			}
		},username);
		return adminUserData;
		}catch(Exception e) {
			logger.error("Error Retrieving Token", e);
			return null;
		}
		
	}

	@Override
	public List<AdminUserData> getAllAdminUsers() {
		try {
			String SQL_GET_ALL_ADM_USERS="SELECT A.*,B.ROLE_NAME,B.ROLE_DESC FROM CSS_ADMIN_USERS A,"
					+ " CSS_ADMIN_ROLES B WHERE A.ROLE_ID=B.ROLE_ID AND (A.DELETED_IND IS NULL OR A.DELETED_IND <>1)";

			List<AdminUserData> adminUsers = jdbcTemplate.query(
					SQL_GET_ALL_ADM_USERS, new RowMapper<AdminUserData>() {
						public AdminUserData mapRow(ResultSet rs, int rowNum) throws SQLException {
							AdminUserData userData = new AdminUserData();
							userData.setUserId(rs.getString("user_id"));
							userData.setPassword(rs.getString("password"));
							userData.setFirstName(rs.getString("first_name"));
							userData.setLastName(rs.getString("last_name"));
							userData.setEmailId(rs.getString("email_id"));
							userData.setRoleId(rs.getString("role_id"));
							userData.setDeleteInd(rs.getString("deleted_ind"));
							userData.setRoleName(rs.getString("role_name"));
							userData.setRoleDesc(rs.getString("role_desc"));
							return userData;
						}
					});
			return adminUsers;
		} catch (Exception e) {
			logger.error("Error Retrieving Token", e);
			return null;
		}
	}

	@Override
	public AdminUserData getAdminUserDetails(String userId) {
		try {
			String SQL_GET_ADM_USER_BY_USER_ID="SELECT A.*,B.ROLE_NAME FROM CSS_ADMIN_USERS A, CSS_ADMIN_ROLES B WHERE A.ROLE_ID=B.ROLE_ID AND A.USER_ID=?";

			AdminUserData adminUserData = jdbcTemplate.queryForObject(
					SQL_GET_ADM_USER_BY_USER_ID, new RowMapper<AdminUserData>() {
						public AdminUserData mapRow(ResultSet rs, int rowNum) throws SQLException {
							AdminUserData userData = new AdminUserData();
							userData.setUserId(rs.getString("user_id"));
							userData.setPassword(rs.getString("password"));
							userData.setFirstName(rs.getString("first_name"));
							userData.setLastName(rs.getString("last_name"));
							userData.setEmailId(rs.getString("email_id"));
							userData.setRoleId(rs.getString("role_id"));
							userData.setDeleteInd(rs.getString("deleted_ind"));
							userData.setRoleName(rs.getString("role_name"));
							userData.setCobrowseCode(rs.getString("cobrowse_code"));
							return userData;
						}
					}, userId);
			return adminUserData;
		} catch (Exception e) {
			logger.error("Error Retrieving Token", e);
			return null;
		}
	}
	
	@Override
	public Map<String, String> getAllAdminUserRoles() {
		Map<String, String> rolesMap = new HashMap<String, String>();
		try {
			String SQL_GET_ALL_ADM_ROLES="SELECT * FROM CSS_ADMIN_ROLES";
			List<AdminUserData> adminUsers = jdbcTemplate.query(
					SQL_GET_ALL_ADM_ROLES, new RowMapper<AdminUserData>() {
						public AdminUserData mapRow(ResultSet rs, int rowNum) throws SQLException {
							AdminUserData userData = new AdminUserData();
							userData.setRoleId(rs.getString("role_id"));
							userData.setRoleName(rs.getString("role_name"));
							userData.setRoleDesc(rs.getString("role_desc"));
							return userData;
						}
					});
			
			if(!CollectionUtils.isEmpty(adminUsers)) {
				for (AdminUserData userData : adminUsers) {
					rolesMap.put(userData.getRoleId(), userData.getRoleDesc());
				}
			}
			return rolesMap;
		} catch (Exception e) {
			logger.error("Error Retrieving Token", e);
			return null;
		}
	}
	
	@Override
	public List<String> getFeatures(String userId) {
		try {
			String SQL_SELECT_FEATURES_BY_ROLE="SELECT CAF.*,CAR.* FROM CSS_ADMIN_FEATURES CAF, CSS_ADMIN_ROLE_FEATURE CARF, CSS_ADMIN_ROLES CAR WHERE CARF.FEATURE_ID = CAF.FEATURE_ID AND "
					+ "CAR.ROLE_ID = CARF.ROLE_ID AND CAR.ROLE_NAME=?";

			List<String> features = jdbcTemplate.query(
					SQL_SELECT_FEATURES_BY_ROLE, new RowMapper<String>() {
						public String mapRow(ResultSet rs, int rowNum) throws SQLException {
							return rs.getString("FEATURE_ID");
						}
					}, userId);
			
			return features;
		} catch (Exception e) {
			logger.error("Error Retrieving features", e);
			return null;
		}
	}
	
	@Override
	public void createAdminUser(AdminUserData adminUserData) {
		if (adminUserData != null) {
			jdbcTemplate.update(sqlProperties.getProperty("SQL_INSERT_ADM_USER"), adminUserData.getUserId(),EncryptDecryptUtil.encrypt(adminUserData.getPassword()),
					adminUserData.getFirstName(), adminUserData.getLastName(), adminUserData.getEmailId(), adminUserData.getRoleId(), 0,adminUserData.getCobrowseCode());
		}
	}
	
	@Override
	public void updateUser(AdminUserData adminUserData) {
		if (adminUserData != null) {
			jdbcTemplate.update(sqlProperties.getProperty("SQL_UPDATE_ADM_USER"), EncryptDecryptUtil.encrypt(adminUserData.getPassword()),
					adminUserData.getFirstName(), adminUserData.getLastName(), adminUserData.getEmailId(), 
					adminUserData.getRoleId(), adminUserData.getUserId(),adminUserData.getCobrowseCode(),adminUserData.getUserId());
		}
	}
	
	@Override
	public void updateUserPassword(AdminUserData adminUserData) {
		if (adminUserData != null && !StringUtils.isEmpty(adminUserData.getNewPassword()) && !StringUtils.isEmpty(adminUserData.getUserId())) {
			String newPassword=EncryptDecryptUtil.encrypt(adminUserData.getNewPassword());
			jdbcTemplate.update(sqlProperties.getProperty("SQL_UPDATE_ADM_USER_PASSWORD"), newPassword, adminUserData.getUserId());
		}
	}


	@Override
	public void deleteAdminUser(String userId) {
		if (!StringUtils.isEmpty(userId)) {
			jdbcTemplate.update(sqlProperties.getProperty("SQL_DELETE_ADM_USER"), userId);
		}
	}
	
	@Override
	public boolean validateUserIdOrEmailExists(String userId, String emailId) {
		try {
			String SQL_GET_ALL_ADM_ROLES="";
			List<AdminUserData> adminUsers = jdbcTemplate.query(
					sqlProperties.getProperty("SQL_GET_ADM_USERS_BY_USERID_AND_EMAILID"), new RowMapper<AdminUserData>() {
						public AdminUserData mapRow(ResultSet rs, int rowNum) throws SQLException {
							AdminUserData userData = new AdminUserData();
							userData.setUserId(rs.getString("user_id"));
							userData.setEmailId(rs.getString("email_id"));
							return userData;
						}
					}, userId, emailId);
			if (!CollectionUtils.isEmpty(adminUsers)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			logger.error("Error Retrieving Token", e);
			return false;
		}
	}
	
    public List<AdminUserData> getAllAdminRoles() {
    	String SQL_GET_ALL_ADM_ROLES="SELECT * FROM CSS_ADMIN_ROLES";
        try {
            List<AdminUserData> adminRoles = jdbcTemplate.query(
                    SQL_GET_ALL_ADM_ROLES, new RowMapper<AdminUserData>() {
                        public AdminUserData mapRow(ResultSet rs, int rowNum) throws SQLException {
                            AdminUserData userData = new AdminUserData();
                            userData.setRoleId(rs.getString("role_id"));
                            userData.setRoleName(rs.getString("role_name"));
                            userData.setRoleDesc(rs.getString("role_desc"));
                            return userData;
                        }
                    });
            
            return adminRoles;
        } catch (Exception e) {
            logger.error("Error Retrieving Token", e);
            return null;
        }
    }

	@Override
	public Map<String, String> getAllAdminUserFeatures() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createIfRoleExists(String roleName) {
		// TODO Auto-generated method stub
		return false;
	}
    
    /*  @Override
   public Map<String, String> getAllAdminUserFeatures() {
        Map<String, String> featuresMap = new HashMap<String, String>();
        try {
            List<FeaturesData> adminFeatures = jdbcTemplate.query(
                    sqlProperties.getProperty("SQL_GET_ALL_ADM_FEATURES"), new RowMapper<FeaturesData>() {
                        public FeaturesData mapRow(ResultSet rs, int rowNum) throws SQLException {
                            FeaturesData featureData = new FeaturesData();
                            featureData.setFeatureId(rs.getString("feature_id"));
                            featureData.setFeatureName(rs.getString("feature_name"));
                            return featureData;
                        }
                    });
            
            if(!CollectionUtils.isEmpty(adminFeatures)) {
                for (FeaturesData featureData : adminFeatures) {
                    featuresMap.put(featureData.getFeatureId(), featureData.getFeatureName());
                }
            }
            return featuresMap;
        } catch (Exception e) {
            logger.error("Error Retrieving Token", e);
            return null;
        }
    }
    

    @Override
    public AdminRoleFeatures getFeaturesForRole(String roleName) {
        try {
            AdminRoleFeatures roleFeatures = new AdminRoleFeatures();
            List<String> features = jdbcTemplate.query(
                    sqlProperties.getProperty("SQL_SELECT_FEATURES_BY_ROLE"), new ResultSetExtractor<List<String>>() {
                        public List<String> extractData(ResultSet rs) throws SQLException {
                            List<String> features = new ArrayList<>();
                            while(rs.next()) {
                                if (roleFeatures.getAdminRole() == null) {
                                    AdminRole adminRole = new AdminRole();
                                    adminRole.setRoleId(rs.getString("role_id"));
                                    adminRole.setRoleName(rs.getString("role_name"));
                                    adminRole.setRoleDesc(rs.getString("role_desc"));
                                    roleFeatures.setAdminRole(adminRole);
                                }
                                features.add(rs.getString("feature_id"));
                            }
                            return features;
                        }
                    }, roleName);
            
            roleFeatures.setFeatures(features);
            return roleFeatures;
        } catch (Exception e) {
            logger.error("Error Retrieving features", e);
            return null;
        }
    }
    
    @Override
    public void saveRole(AdminRoleFeatures roleFeatures) {
        jdbcTemplate.update(sqlProperties.getProperty("SQL_UPDATE_ADMIN_ROLE"), roleFeatures.getAdminRole().getRoleDesc(), roleFeatures.getAdminRole().getRoleId());
        jdbcTemplate.update(sqlProperties.getProperty("SQL_DELETE_ROLE_FEATURES"), roleFeatures.getAdminRole().getRoleId());
        jdbcTemplate.batchUpdate(sqlProperties.getProperty("SQL_INSERT_ROLE_FEATURES"), new BatchPreparedStatementSetter() {
            
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                String featureId = roleFeatures.getFeatures().get(i);
                ps.setString(1, roleFeatures.getAdminRole().getRoleId());
                ps.setString(2, featureId);
            }
            
            @Override
            public int getBatchSize() {
                return roleFeatures.getFeatures().size();
            }
        });
    }
    
    @Override
    public void createRole(AdminRoleFeatures roleFeatures) {
        jdbcTemplate.update(sqlProperties.getProperty("SQL_INSERT_ADMIN_ROLE"), roleFeatures.getAdminRole().getRoleId(), roleFeatures.getAdminRole().getRoleName(), 
                roleFeatures.getAdminRole().getRoleDesc(), new Date());
        jdbcTemplate.batchUpdate(sqlProperties.getProperty("SQL_INSERT_ROLE_FEATURES"), new BatchPreparedStatementSetter() {
            
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                String featureId = roleFeatures.getFeatures().get(i);
                ps.setString(1, roleFeatures.getAdminRole().getRoleId());
                ps.setString(2, featureId);
            }
            
            @Override
            public int getBatchSize() {
                return roleFeatures.getFeatures().size();
            }
        });
    }
    
    @Override
    public boolean createIfRoleExists(String roleName) {
        boolean roleExists = true;
        if (!StringUtils.isEmpty(roleName)) {
            try {
                roleExists = jdbcTemplate.query(
                        sqlProperties.getProperty("SQL_ADMIN_ROLE_EXISTS"), new ResultSetExtractor<Boolean>() {
                            public Boolean extractData(ResultSet rs) throws SQLException {
                                rs.next();
                                return (rs.getInt("ROLE_NAME_CNT") == 1 ? true : false);
                            }
                        }, roleName);
                
                return roleExists;
            } catch (Exception e) {
                logger.error("Error Retrieving features", e);
                return roleExists;
            }
        }
        
        return roleExists;
    }

	@Override
	public com.javainterviewpoint.AdminRoleFeatures getFeaturesForRole(String role) {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
