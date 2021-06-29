package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@WebServlet(urlPatterns = { "/login", "/users", "/addUser" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/login")) {
			login(request, response);
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
			UserDao user = new UserDao();

			String email = request.getParameter("email");
			String password = request.getParameter("password");

			if (user.login(email, password)) {
				response.sendRedirect("contacts");
				System.out.println("logado com sucesso");
			} else {
				System.out.println("erro ao logar");
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void users(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Cirando um obejto que ira receber os dados javabeans
		// ArrayList<ContactBean> list = dao.getAll();
		// request.setAttribute("contacts", list);
		RequestDispatcher rd = request.getRequestDispatcher("/users/index.jsp");
		rd.forward(request, response);
	}

	protected void store(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * contact.setName(request.getParameter("name"));
		 * contact.setPhone(request.getParameter("phone"));
		 * contact.setEmail(request.getParameter("email")); // Inserindo contato
		 * dao.create(contact);
		 */
		response.sendRedirect("users");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
