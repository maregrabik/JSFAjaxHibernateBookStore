package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ajaxBeans.AjaxNavi;
import beans.LoginDataBean;

//@WebFilter("/WEB-INF/includes/*")
public class AuthorizationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		LoginDataBean auth = (LoginDataBean) req.getSession().getAttribute("loginDataBean");
System.out.println("Dupaa");
		if (auth != null && auth.isLoged()) {
			// User is logged in, so just continue request.
			chain.doFilter(request, response);
		} else {
			// User is not logged in, so redirect to index.
			HttpServletResponse res = (HttpServletResponse) response;
			AjaxNavi ajaxNavi = (AjaxNavi) req.getSession().getAttribute("ajaxNavi");
			ajaxNavi.setPage("loginForm");
			res.sendRedirect(req.getContextPath() + "/index.xhtml");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}