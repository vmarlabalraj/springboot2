package com.javainterviewpoint.security;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpSession;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class SecurityHelper {

	/**
	 * Method to check if the user has the given role
	 * 
	 * @param role
	 * @return
	 */
	public static boolean hasRole(String role) {
		
		boolean hasRole = false;
		/*
		 * UserDetails userDetails = getUserDetails(); if (userDetails != null) {
		 * Collection<? extends GrantedAuthority> authorities =
		 * userDetails.getAuthorities(); if (isRolePresent(authorities, role)) hasRole =
		 * true; }
		 */
		return hasRole;
	}

	/**
	 * Get info about currently logged in user
	 * 
	 * @return UserDetails if found in the context, null otherwise
	 */
	/*
	 * public static UserDetails getUserDetails() {
	 * 
	 * Object principal =
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 * UserDetails userDetails = null; if (principal instanceof UserDetails) {
	 * userDetails = (UserDetails) principal; } return userDetails; }
	 */

	/**
	 * Method to return user session id
	 * @return
	 */
	public static String getUserSessionId(){
		
		/*
		 * Object details =
		 * SecurityContextHolder.getContext().getAuthentication().getDetails();
		 * if(details != null){ if(details instanceof WebAuthenticationDetails){ return
		 * ((WebAuthenticationDetails)details).getSessionId(); } }
		 */
		return null;
	}
	
	/**
	 * Check if a role is present in the authorities of current user
	 * 
	 * @param authorities all authorities assigned to current user
	 * @param role required authority
	 * @return true if role is present in list of authorities assigned to current user, false otherwise
	 */
	/*
	 * private static boolean isRolePresent(Collection<? extends GrantedAuthority>
	 * authorities, String role) { boolean isRolePresent = false; for
	 * (GrantedAuthority grantedAuthority : authorities) { isRolePresent =
	 * grantedAuthority.getAuthority().equals(role); if (isRolePresent) break; }
	 * return isRolePresent; }
	 */
	
	/**
	 * Method to check if the user has the given feature
	 * 
	 * @param featureId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean hasAccess(String featureId) {
		
		boolean hasAccess = false;
		//UserDetails userDetails = SecurityHelper.getUserDetails();
		/*
		 * if (userDetails != null) {
		 * 
		 * ServletRequestAttributes attr = (ServletRequestAttributes)
		 * RequestContextHolder.currentRequestAttributes(); HttpSession
		 * session=attr.getRequest().getSession(); Map<String, String> featuresMap =
		 * (Map<String, String>)
		 * RequestContextHolder.getRequestAttributes().getAttribute("features", 0);
		 * 
		 * if(featuresMap==null) featuresMap = (Map<String, String>)
		 * session.getAttribute("userRoleFeatures");
		 * 
		 * if (isFeaturePresent(featuresMap, featureId)) hasAccess = true; }
		 */
		return hasAccess;
	}
	
	/**
	 * Check if a feature is present in the authorities of current user
	 * 
	 * @param authorities all authorities assigned to current user
	 * @param feature required authority
	 * @return true if feature is present in list of authorities assigned to current user, false otherwise
	 */
	private static boolean isFeaturePresent(Map<String, String> featuresMap, String featureId) {
		boolean isFeaturePresent = false;
	/*	if (featuresMap!=null && featuresMap.containsKey(featureId)) {
			isFeaturePresent = true;
		}
		return isFeaturePresent;
		
		*/
		
//		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//		for (GrantedAuthority grantedAuthority : authorities) {
//			isFeaturePresent = grantedAuthority.getAuthority().equals(featureId);
//			if (isFeaturePresent)
//				break;
//		}
		return isFeaturePresent;
	}
	
	
	
}