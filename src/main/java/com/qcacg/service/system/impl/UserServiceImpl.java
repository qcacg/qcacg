package com.qcacg.service.system.impl;

import com.github.pagehelper.PageInfo;
import com.qcacg.entity.UserEntity;
import com.qcacg.entity.UserRoleEntity;
import com.qcacg.entity.user.UserCustom;
import com.qcacg.mapper.ResourcesMapper;
import com.qcacg.mapper.UserMapper;
import com.qcacg.mapper.UserRoleMapper;
import com.qcacg.service.BaseServiceImpl;
import com.qcacg.service.system.UserService;
import com.qcacg.util.PasswordHelper;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity>implements UserService
{
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private String algorithmName = "md5";
	private int hashIterations = 2;
	@Autowired
	private UserMapper userMapper;

	public UserEntity findByLoginName(String telephone)
	{
		UserEntity entity = new UserEntity();
		entity.setTelephone(telephone);
		return this.findByObject(entity);
	}

	public PageInfo<UserEntity> queryUserForList(UserEntity entity)
	{
		return this.queryPageForList(entity);
	}

	public String saveOrUpdate(UserEntity entity)
	{
		String result = "";
		try
		{
			if (entity.getUserId() == null)
			{
				PasswordHelper passwordHelper = new PasswordHelper();
				passwordHelper.encryptPassword(entity);
				return this.save(entity);
			} else
			{
				result = this.update(entity);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return result;
	}

	public void updatePassWord(UserEntity userEntity,String passWord){
		try {
			if(userEntity != null){
				String salt = randomNumberGenerator.nextBytes().toHex();
				userEntity.setCredentialsSalt(salt);
				String newPassWord = new SimpleHash(algorithmName, passWord, ByteSource.Util.bytes(userEntity.getTelephone()+salt), hashIterations).toHex();
				userEntity.setPassWord(newPassWord);
				userEntity.setCredentialsSalt(salt);
				userMapper.updateByPrimaryKey(userEntity);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}

}
	public void register(UserCustom userCustom){

		try{
			PasswordHelper passwordHelper = new PasswordHelper();
			passwordHelper.encryptPassword(userCustom);
			UserEntity userEntity = new UserEntity();
			BeanUtils.copyProperties(userCustom, userEntity);
			this.save(userEntity);
		}catch (Exception e){
			e.printStackTrace();
		}

	}


}
