package com.javainterviewpoint.security;

import java.util.Arrays;
import java.util.Collection;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

public class AdminMenuHelper {

	/**
	 * Method to check if the user has the given feature
	 * 
	 * @param featureId
	 * @return
	 */
	/*
	 * public static boolean hasAccess(String featureId) {
	 * 
	 * boolean hasAccess = false; //UserDetails userDetails =
	 * SecurityHelper.getUserDetails(); if (userDetails != null) {
	 * 
	 * AdminMenuHelper adminHelper = new AdminMenuHelper(); if
	 * (adminHelper.isFeaturePresent(userDetails.getAuthorities(), featureId))
	 * hasAccess = true; } return hasAccess; }
	 */
	
	/**
	 * Check if a feature is present in the authorities of current user
	 * 
	 * @param authorities all authorities assigned to current user
	 * @param feature required authority
	 * @return true if feature is present in list of authorities assigned to current user, false otherwise
	 */
	/*
	 * private boolean isFeaturePresent(Collection<? extends GrantedAuthority>
	 * grantAuthorities, String featureId) { boolean isFeaturePresent = false;
	 * SimpleGrantedAuthority featureAuthority = new
	 * SimpleGrantedAuthority(featureId); if
	 * (CollectionUtils.containsAny(grantAuthorities,
	 * Arrays.asList(featureAuthority))) { isFeaturePresent = true; } return
	 * isFeaturePresent; }
	 */

}