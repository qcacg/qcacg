package com.qcacg.service.system;

import com.github.pagehelper.PageInfo;
import com.qcacg.entity.UserEntity;
import com.qcacg.entity.user.UserCustom;
import com.qcacg.service.BaseService;

public interface UserService extends BaseService<UserEntity>
{

	public UserEntity findByLoginName(String telephone);

	public PageInfo<UserEntity> queryUserForList(UserEntity entity);

	public String saveOrUpdate(UserEntity entity);

	public void register(UserCustom userCustom);

	public void updatePassWord(String telephone, String newPassWord);

}
