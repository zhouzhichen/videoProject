package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vedioDao.VedioDao;

/**
 * Servlet implementation class VedioServlet
 */
@WebServlet("/VedioServlet")
public class VedioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("case");
		String method = request.getParameter("method");
		if ("flower".equals(method)) {
		
			List list=VedioDao.select(Integer.parseInt(id));
			request.setAttribute("list", list);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
