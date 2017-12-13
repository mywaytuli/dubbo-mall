package com.tuli.dmall.web.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class AdminAuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		String from = request.getServletPath();
		String uri = request.getRequestURI();
		if (isIgnoredUri(uri) || "/admin/login".equals(from)) {
			return true;
		}

		Object obj = request.getSession().getAttribute("admin_user");
		if (obj == null) {
			String path = request.getContextPath() + "/admin/login";
			String queryStr = request.getQueryString();
			if (!StringUtils.isEmpty(queryStr)) {
				from = from + "?" + queryStr;
			}
			if( from.endsWith("/admin/login"))
				from="";
			response.sendRedirect(path + "?from=" + from);	
			return false;
		}
		return super.preHandle(request, response, handler);
	}

	protected boolean isIgnoredUri(String uri) {
		return uri.matches(".+(?i)(login|getToken|login.do|logout|400|403|404|500)+");
	}
	
	protected boolean isIndexUri(String uri) {
		return uri.matches(".+(?i)(index)+");
	}
}
