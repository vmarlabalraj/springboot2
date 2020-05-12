package com.javainterviewpoint;

import java.util.List;
import java.util.Map;

//import com.ms.admin.data.AdminRoleFeatures;
import com.javainterviewpoint.security.*;

public interface UserDAO {

	public com.javainterviewpoint.security.AdminUserData validateUser(String username,String password);
	
	public void createAdminUserToken(String userId,String token);
	
	public AdminUserData getAdminToken(String username);
	
	public List<AdminUserData> getAllAdminUsers();
	
	public AdminUserData getAdminUserDetails(String userId);
	
	public void deleteAdminUser(String userId);

	void updateUser(AdminUserData adminUserData);

	void createAdminUser(AdminUserData adminUserData);

	boolean validateUserIdOrEmailExists(String userId, String emailId);

	public Map<String, String> getAllAdminUserRoles();

	public void updateUserPassword(AdminUserData template);
	
	public List<String> getFeatures(String role);
	
   // public AdminRoleFeatures getFeaturesForRole(String role);
    
    public List<AdminUserData> getAllAdminRoles();
    
    public Map<String, String> getAllAdminUserFeatures();
    
   // public void saveRole(AdminRoleFeatures roleFeatures);
    
   // public void createRole(AdminRoleFeatures roleFeatures);
    
    public boolean createIfRoleExists(String roleName);
}
