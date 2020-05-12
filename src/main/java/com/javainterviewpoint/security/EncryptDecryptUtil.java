package com.javainterviewpoint.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncryptDecryptUtil {

	
	private static final Logger logger = LoggerFactory.getLogger(EncryptDecryptUtil.class);

	public static SecretKeySpec setKey(String myKey) {
		MessageDigest sha = null;
		try {
			byte[] key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-256");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			return new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			logger.error("Error while creating key: ");
		} catch (UnsupportedEncodingException e) {
			logger.error("Error while creating key: ");
		}
		
		return null;
	}

	public static String getKey() {
		return System.getProperty("portal.enc.key");
	}

	public static String encrypt(String strToEncrypt) {
		try {
			SecretKeySpec secretKey = setKey("dgdgegerwt24642terwdgerw");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		} catch (Exception e) {
			logger.error("Error while encrypting: ");
		}
		return null;
	}

	public static String decrypt(String strToDecrypt) {
		try {
			SecretKeySpec secretKey = setKey(getKey());
			Cipher cipher = Cipher.getInstance(System.getProperty("enc.algorithm"));
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			logger.error("Error while decrypting: ");
		}
		return null;
	}

}