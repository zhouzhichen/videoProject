package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userBean.UserBean;
import userDao.UserDao;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if ("login".equals(method)) {

			String password = request.getParameter("userPs");
			String qqname = request.getParameter("userLoginName");
			UserBean user=UserDao.login(Integer.parseInt(password), qqname);
			if ( user!= null) {
				List li1=UserDao.selectMajor();
				List li2=UserDao.selectTecher();
				request.setAttribute("majorInfo", li1);
				request.setAttribute("userInfo", li2);
				request.getSession().setAttribute("shit", user.getId());
				request.getSession().setAttribute("fuck", user.getTypeId());
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
		}
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
