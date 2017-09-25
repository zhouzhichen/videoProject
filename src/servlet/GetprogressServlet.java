package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetprogressServlet
 */
@WebServlet("/GetprogressServlet")
public class GetprogressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int i = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		if (request.getSession().getAttribute("progress") != null) {
			String str = (int) request.getSession().getAttribute("progress") + "";
			System.out.println(str);
			response.getWriter().write(str);
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
