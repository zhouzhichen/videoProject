package myfilter;

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

/**
 * Servlet Filter implementation class MyLoginfilter
 */

public class MyLoginfilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		if (request.getServletPath().indexOf("login.html") != -1
				//在请求的路径上判断是否有这些页面，因为request.getServletPath()得到的是String所以这里用indexof（）判断
				|| request.getServletPath().indexOf("UserServlet") != -1 || request.getServletPath().endsWith(".css")
				|| request.getServletPath().endsWith(".js")) {

			chain.doFilter(req, res);
		} else {
			if (request.getSession().getAttribute("user") != null) {
				//因为在Dao层设置过，将得到的user存进了session，所以这里可以直接取user判断是否为空
				chain.doFilter(req, res);
			} else {
				response.sendRedirect("login.html");
			}
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
