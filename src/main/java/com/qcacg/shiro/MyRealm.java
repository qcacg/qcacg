package com.qcacg.shiro;

import com.qcacg.entity.ResourcesEntity;
import com.qcacg.entity.UserEntity;
import com.qcacg.service.system.ResourcesService;
import com.qcacg.service.system.UserService;
import com.qcacg.util.MyJedis;
import com.qcacg.util.UserEntityUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 自定义Realm,进行数据源配置
 */
public class MyRealm extends AuthorizingRealm
{

	@Autowired
	private ResourcesService resourcesService;
	@Autowired
	private UserService userService;

	/**
	 * 只有需要验证权限时才会调用, 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.在配有缓存的情况下，只加载一次.
	 * 如果需要动态权限,但是又不想每次去数据库校验,可以存在ehcache中.自行完善
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
	{
		final String loginName = SecurityUtils.getSubject().getPrincipal().toString();
		if (loginName != null)
		{
			//Long userId = UserEntityUtil.getUserFromSession().getUserId();
			MyJedis jedis = new MyJedis();
			Long userId = jedis.getUserId(loginName);
			// 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			List<ResourcesEntity> reList = resourcesService.findResourcessByUserId(userId);
			for (ResourcesEntity resource : reList)
			{
				String key = resource.getResourcesUrl();
				if (StringUtils.isNotBlank(key)) {
					key = key.substring(key.indexOf("/")+1,key.lastIndexOf(".")).replace("/",":");
					info.addStringPermission(key);
				}
			}
			return info;
		}
		return null;
		
/*		String username = (String)principalCollection.getPrimaryPrincipal();  
		UserEntity user = userService.findByLoginName(username);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();  
        Set<String> setList = new HashSet<String>();
        Set<String> setPermList = new HashSet<String>();
        List<RoleEntity> list = roleService.findRoleByUser(user.getId().toString());
        for (RoleEntity roleEntity : list)
		{
        	setList.add(roleEntity.getId().toString());
		}
        authorizationInfo.setRoles(setList);  
        Map<String,String> queryMap = new HashMap<String,String>();
		queryMap.put("userId", user.getId().toString());
		List<ResourcesEntity> reList = resourcesService.findRes(queryMap);
		for (ResourcesEntity resource : reList)
		{
			String key = resource.getResUrl();
			//key = key.substring(key.indexOf("/"),key.lastIndexOf("/"));
			setPermList.add(key);
		}
		        return null;  
		*/

	}

	/**
	 * 认证回调函数,登录时调用
	 * 首先根据传入的用户名获取User信息；然后如果user为空，那么抛出没找到帐号异常UnknownAccountException；
	 * 如果user找到但锁定了抛出锁定异常LockedAccountException；最后生成AuthenticationInfo信息，
	 * 交给间接父类AuthenticatingRealm使用CredentialsMatcher进行判断密码是否匹配，
	 * 如果不匹配将抛出密码错误异常IncorrectCredentialsException；
	 * 另外如果密码重试此处太多将抛出超出重试次数异常ExcessiveAttemptsException；
	 * 在组装SimpleAuthenticationInfo信息时， 需要传入：身份信息（用户名）、凭据（密文密码）、盐（username+salt），
	 * CredentialsMatcher使用盐加密传入的明文密码和此处的密文密码进行匹配。
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
	{

		String telephone = (String) token.getPrincipal();
		UserEntity user = userService.findByLoginName(telephone);
		if (user != null)
		{
			if ("0".equals(user.getUserStatus())) // 帐号锁定
			{
				throw new LockedAccountException();
			}
			// 从数据库查询出来的账号名和密码,与用户输入的账号和密码对比
			// 当用户执行登录时,在方法处理上要实现user.login(token);
			// 然后会自动进入这个类进行认证
			// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(telephone,
					user.getPassWord().toCharArray(),
					ByteSource.Util.bytes(telephone + "" + user.getCredentialsSalt()), getName());
			MyJedis jedis = new MyJedis();
			jedis.set(telephone, user.getUserId().toString());
			// bWVtbXNj
			// 当验证都通过后，把用户信息放在session里
			Session session = SecurityUtils.getSubject().getSession();
			session.setAttribute(UserEntityUtil.USER_SESSION_KEY, user);
			return authenticationInfo;
		} else
		{
			throw new UnknownAccountException();// 没找到帐号
		}
	}

	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(PrincipalCollection principals)
	{
		super.clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 更新用户信息缓存.
	 */
	public void clearCachedAuthenticationInfo(PrincipalCollection principals)
	{
		super.clearCachedAuthenticationInfo(principals);
	}

	/**
	 * 清除用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo()
	{
		getAuthorizationCache().clear();
	}

	/**
	 * 清除用户信息缓存.
	 */
	public void clearAllCachedAuthenticationInfo()
	{
		getAuthenticationCache().clear();
	}

	/**
	 * 清空所有缓存
	 */
	public void clearCache(PrincipalCollection principals)
	{
		super.clearCache(principals);
	}

	/**
	 * 清空所有认证缓存
	 */
	public void clearAllCache()
	{
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

}