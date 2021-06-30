package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;
import dao.UserDao;

@WebServlet(urlPatterns = { "/login", "/logout", "/users", "/addUser" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao user = new UserDao();

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/login")) {
			login(request, response);
			return;
		} else if (action.equals("/logout")) {
			logout(request, response);
			return;
		} else if (action.equals("/users")) {
			users(request, response);
			return;
		} else if (action.equals("/addUser")) {
			store(request, response);
			return;
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			if (user.login(email, password)) {
				HttpSession session = request.getSession();
				// System.out.println(user.getUserByEmail(email).getName());
				session.setAttribute("nameUser", user.getUserByEmail(email).getName());
				response.sendRedirect("contacts");
			} else {
				System.out.println("erro ao logar");
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	protected void users(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<UserBean> list = user.getAll();
		request.setAttribute("users", list);
		RequestDispatcher rd = request.getRequestDispatcher("/users/index.jsp");
		rd.forward(request, response);
	}

	protected void store(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserBean userBean = new UserBean(null, name, email, password);
		user.create(userBean);
		response.sendRedirect("users");
	}

}
