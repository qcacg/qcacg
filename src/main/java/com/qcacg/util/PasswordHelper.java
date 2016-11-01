package com.qcacg.util;

import com.qcacg.entity.UserEntity;
<<<<<<< HEAD
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
=======
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

<<<<<<< HEAD
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

=======
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
public class PasswordHelper
{
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private String algorithmName = "md5";
	private int hashIterations = 2;
<<<<<<< HEAD
	private static String mySalt = "cn.qcacg";
=======
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553

	public void encryptPassword(UserEntity userEntity)
	{
		String salt = randomNumberGenerator.nextBytes().toHex();
		userEntity.setCredentialsSalt(salt);
		String newPassWord = new SimpleHash(algorithmName, userEntity.getPassWord(), ByteSource.Util.bytes(userEntity.getTelephone()+salt), hashIterations).toHex();
		userEntity.setPassWord(newPassWord);
		userEntity.setCredentialsSalt(salt);
		System.out.println(newPassWord);
		System.out.println(salt);
	}

	public String encryptToken(String now, String agent) {
		String salt = randomNumberGenerator.nextBytes().toHex();
		String token = new SimpleHash(algorithmName, now, ByteSource.Util.bytes(agent + salt), hashIterations).toHex();
		return token;
	}

<<<<<<< HEAD
	public static String encryptByMd5(String in) {
		if(StringUtils.isBlank(in)) {
			throw new RuntimeException("无法对空字符串加密");
		}
		try {
			byte[] input = in.getBytes("utf-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(input);
			md.update(mySalt.getBytes("utf-8"));
			byte[] out = md.digest();
			String encrypt = Base64.encodeBase64String(out);
			return encrypt;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	public static void main(String[] args) {
=======
	public static void main(String[] args) {
		PasswordHelper passwordHelper = new PasswordHelper();
		UserEntity userFormMap = new UserEntity();
		userFormMap.setPassWord("123456");
		userFormMap.setTelephone("15067171806");
		passwordHelper.encryptPassword(userFormMap);
		System.out.println(userFormMap.getPassWord());
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553

	}

}
