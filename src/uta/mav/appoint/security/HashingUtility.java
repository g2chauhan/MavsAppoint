package uta.mav.appoint.security;

import java.math.BigInteger;
import java.security.MessageDigest;

public class HashingUtility {

	public static String hashString(String content) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
		}
		byte[] thedigest = md.digest(content.getBytes());
		String userPw = new BigInteger(1, thedigest).toString(16);

		return userPw;
	}
public static void main(String[] args) {
	System.out.println(hashString("abcd1234@"));
}
}
