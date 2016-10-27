package com.qcacg.util;

import com.qcacg.entity.UserEntity;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper
{
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private String algorithmName = "md5";
	private int hashIterations = 2;

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

	public static void main(String[] args) {
		PasswordHelper passwordHelper = new PasswordHelper();
		UserEntity userFormMap = new UserEntity();
		userFormMap.setPassWord("123456");
		userFormMap.setTelephone("15067171806");
		passwordHelper.encryptPassword(userFormMap);
		System.out.println(userFormMap.getPassWord());

	}

}
