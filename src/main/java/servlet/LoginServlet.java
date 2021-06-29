package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserDao user = new UserDao();

			String email = request.getParameter("email");
			String password = request.getParameter("password");

			if (user.login(email, password)) {
				/*RequestDispatcher dispatcher = request.getRequestDispatcher("logado.jsp");
				dispatcher.forward(request, response);*/
				response.sendRedirect("agenda");
				System.out.println("logado com sucesso");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
				System.out.println("erro ao logar");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
