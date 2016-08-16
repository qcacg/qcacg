package com.qcacg.service.system.impl;

import com.github.pagehelper.PageInfo;
import com.qcacg.constant.LoginConstant;
import com.qcacg.entity.UserEntity;
import com.qcacg.entity.UserRoleEntity;
import com.qcacg.entity.user.UserCustom;
import com.qcacg.mapper.ResourcesMapper;
import com.qcacg.mapper.UserMapper;
import com.qcacg.mapper.UserRoleMapper;
import com.qcacg.service.BaseServiceImpl;
import com.qcacg.service.exception.BusinessException;
import com.qcacg.service.system.UserService;
import com.qcacg.util.Md5Util;
import com.qcacg.util.PasswordHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity>implements UserService
{

	@Autowired
	private ResourcesMapper resourcesMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
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

	public String saveOrUpdate(UserEntity entity,Long txtGroupsSelect[])
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
				this.resourcesMapper.deleteRoleByUserId(String.valueOf(entity.getUserId()));
			}
			if (txtGroupsSelect != null && txtGroupsSelect.length > 0)
			{
				for (Long roleId : txtGroupsSelect)
				{
					UserRoleEntity record = new UserRoleEntity();
					record.setUserId(entity.getUserId());
					record.setRoleId(roleId);
					userRoleMapper.insertSelective(record);
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return result;
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

	@Override
	public boolean createUserEntity(UserEntity userEntity) {
		if(this.checkTelephone(userEntity.getTelephone())){
			this.save(userEntity);
			return true;
		}else{
			return false;
		}

	}

	@Override
	public Map<String, Object> checkUserEntity(String telephone, String passWord) {
		Map<String, Object> map = new HashMap<>();
		if(telephone == null){
			throw new BusinessException("手机为空");
		}
		if(passWord == null){
			throw new BusinessException("密码为空");
		}
		UserEntity userEntity = userMapper.findByTelephone(telephone);
		if(userEntity == null){
			map.put("flag", LoginConstant.LOGIN_TELEPHONE_ERROR);
			map.put("msg","用户名错误");
		}else if(userEntity.getPassWord().equals(Md5Util.md5(passWord))){
			map.put("flag", LoginConstant.LOGIN_PASSWORD_ERROR);
			map.put("msg","密码错误");
		}else{
			map.put("flag",LoginConstant.LOGIN_SUCCESS);
			map.put("msg","登录成功");
		}
		return map;
	}

	public boolean checkTelephone(String telephone) {
		if(telephone == null){
			throw new BusinessException("手机不能为空");
		}
		UserEntity userentity = userMapper.findByTelephone(telephone);
		if(userentity == null)
			return true;
		else
			return false;
	}


}
