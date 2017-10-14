package com.dream2sky.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.dream2sky.beans.UserInfo;

public class AuthInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		UserInfo userInfo = (UserInfo) session.get("currentUserInfo");
		if (userInfo != null) {
			System.out.println("get user name:" + userInfo.getUsername());
			return invocation.invoke();
		} else
			return "login";
	}

}
