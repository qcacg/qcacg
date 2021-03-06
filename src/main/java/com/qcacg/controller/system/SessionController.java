package com.qcacg.controller.system;

import com.qcacg.entity.UserEntity;
import com.qcacg.util.UserEntityUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/session/")
public class SessionController
{

	@Autowired
	private SessionDAO sessionDAO;

	@RequestMapping("list")
	public String list()
	{
		Collection<Session> sessions = sessionDAO.getActiveSessions();
		for (Session session : sessions)
		{
			session.setAttribute("entity", (UserEntity) session.getAttribute(UserEntityUtil.USER_SESSION_KEY));
		}
		return "system/session/list";
	}

	@RequestMapping("querySessionForList")
	@ResponseBody
	public List<JSONObject> querySessionForList()
	{
		List<JSONObject> list = new ArrayList<JSONObject>();
		Collection<Session> sessions = sessionDAO.getActiveSessions();
		if(sessions!=null && sessions.size() > 0 )
		{
			for (Session session : sessionDAO.getActiveSessions())
			{
				UserEntity userEntity = (UserEntity) session.getAttribute(UserEntityUtil.USER_SESSION_KEY);
				
				JSONObject result = new JSONObject();
				result.put("id", session.getId());
				result.put("host", session.getHost());
				result.put("lastAccessTime", DateFormatUtils.format(session.getLastAccessTime(), "yyyy-MM-dd HH:mm:ss"));
				result.put("startTimestamp", DateFormatUtils.format(session.getStartTimestamp(), "yyyy-MM-dd HH:mm:ss"));
				result.put("telephone", userEntity.getTelephone());
				result.put("userName", userEntity.getUserName());
				list.add(result);
			}
		}
		return list;
	}

	@ResponseBody
	@RequestMapping("/forceLogout")
	public void forceLogout(String sessionId, RedirectAttributes redirectAttributes)
	{
		try
		{
			Session session = sessionDAO.readSession(sessionId);
			if (session != null)
			{
				session.setAttribute(UserEntityUtil.USER_SESSION_LOGOUT_LOGOUT_KEY, Boolean.TRUE);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		redirectAttributes.addFlashAttribute("msg", "强制退出成功！");
	}

	
	
}
