package com.javainterviewpoint.security;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
///import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.LockedException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.javainterviewpoint.UserDAO;



//@Component
//public class AdminAuthenticationProvider implements AuthenticationProvider {

	
	//@Autowired
	//UserDAO adminUserDAO;
	
	/*
	 * @Override public Authentication authenticate(Authentication authentication)
	 * throws AuthenticationException {
	 * 
	 * try { return
	 * authenticateUserAndRetrieveAuthorizations(authentication.getName(),
	 * authentication.getCredentials()); } catch (BadCredentialsException e) { throw
	 * e; } catch (LockedException e) { throw new LockedException("Account Locked");
	 * } catch (Exception e){ throw new BadCredentialsException("Bad Credentials");
	 * } }
	 */

	/*
	 * private Authentication authenticateUserAndRetrieveAuthorizations(String
	 * userName, Object password) throws Exception {
	 * 
	 * Authentication authentication = null; UserDetails userDetails = null;
	 * AdminUserData adminUser=validateUser(userName, String.valueOf(password));
	 * if(adminUser!=null && adminUser.getUserId()!=null) { List<GrantedAuthority>
	 * grantedAuths = addUserRoles(adminUser.getRoleName());
	 * grantedAuths.addAll(addAdminMenu(adminUser.getRoleName())); userDetails = new
	 * User(userName, String.valueOf(password), true, true, true, true,
	 * grantedAuths); authentication = new
	 * UsernamePasswordAuthenticationToken(userDetails, String.valueOf(password),
	 * grantedAuths); generateAdminUserToken(userName); }else { throw new
	 * Exception("Invalid User"); } return authentication; }
	 */
	/*
	 * @Override public boolean supports(Class<?> authentication){ return
	 * authentication.equals(UsernamePasswordAuthenticationToken.class); }
	 */
	
	/*
	 * private AdminUserData validateUser(String username,String password){
	 * AdminUserData userData=adminUserDAO.validateUser(username, password);
	 * 
	 * 
	 * 
	 * return userData; }
	 */
	
	/*
	 * private String generateAdminUserToken(String username){ String
	 * token=UUID.randomUUID().toString();
	 * adminUserDAO.createAdminUserToken(username, token); return token; }
	 */
	
	
	
	/*
	 * private List<GrantedAuthority> addUserRoles(String roleName){
	 * 
	 * String[] userRoles = new String[1]; userRoles[0]=roleName; return
	 * AuthorityUtils.createAuthorityList(userRoles); }
	 */
	
	/*
	 * private List<GrantedAuthority> addAdminMenu(String roleName) { List<String>
	 * features = adminUserDAO.getFeatures(roleName); String[] featureString =
	 * features.stream().toArray(String[]::new); return
	 * AuthorityUtils.createAuthorityList(featureString); }
	 */
	
//}