package com.dream2sky.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dream2sky.beans.UserInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AuthAction extends ActionSupport implements ModelDriven<UserInfo>, SessionAware {
	private UserInfo userInfo = new UserInfo();
	private Map<String, Object> session;

	public String login() {
		if ("admin".equals(userInfo.getUsername()) && "hehe123".equals(userInfo.getPassword())) {
			session.put("currentUserInfo", userInfo);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String logout()
	{		
		session.remove("currentUserInfo");
		return SUCCESS;
	}

	@Override
	public UserInfo getModel() {
		// TODO Auto-generated method stub
		return userInfo;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
