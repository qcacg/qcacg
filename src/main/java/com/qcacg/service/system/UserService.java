package com.qcacg.service.system;

import com.github.pagehelper.PageInfo;
import com.qcacg.entity.UserEntity;
import com.qcacg.entity.user.UserCustom;
import com.qcacg.service.BaseService;

import java.util.Map;

public interface UserService extends BaseService<UserEntity>
{

	public UserEntity findByLoginName(String telephone);

	public PageInfo<UserEntity> queryUserForList(UserEntity entity);

	public String saveOrUpdate(UserEntity entity,Long txtGroupsSelect[]);

	public void register(UserCustom userCustom);

	boolean createUserEntity(UserEntity userEntity);

	Map<String,Object> checkUserEntity(String telephone, String passWord);

	public boolean checkTelephone(String telephone);
}
