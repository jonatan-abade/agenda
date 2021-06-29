package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ContactBean;
import dao.ContactDao;

@WebServlet(urlPatterns = {"/contacts", "/store", "/edit", "/update", "/delete" })
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ContactDao dao = new ContactDao();
	ContactBean contact = new ContactBean();

	public ContactServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/contacts")) {
			contacts(request, response);
			return;
		} else if (action.equals("/store")) {
			store(request, response);
			return;
		} else if (action.equals("/edit")) {
			edit(request, response);
			return;
		} else if (action.equals("/update")) {
			update(request, response);
			return;
		} else if (action.equals("/delete")) {
			destroy(request, response);
			return;
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void contacts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Cirando um obejto que ira receber os dados javabeans
		ArrayList<ContactBean> list = dao.getAll();
		request.setAttribute("contacts", list);
		RequestDispatcher rd = request.getRequestDispatcher("/contact/index.jsp");
		rd.forward(request, response);
	}

	protected void store(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contact.setName(request.getParameter("name"));
		contact.setPhone(request.getParameter("phone"));
		contact.setEmail(request.getParameter("email"));
		// Inserindo contato
		dao.create(contact);
		response.sendRedirect("agenda");
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		contact.setId(Integer.parseInt(id));
		dao.getContact(contact);
		request.setAttribute("id", contact.getId());
		request.setAttribute("name", contact.getName());
		request.setAttribute("phone", contact.getPhone());
		request.setAttribute("email", contact.getEmail());
		RequestDispatcher rd = request.getRequestDispatcher("contact/edit.jsp");
		rd.forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contact.setId(Integer.parseInt(request.getParameter("id")));
		contact.setName(request.getParameter("name"));
		contact.setPhone(request.getParameter("phone"));
		contact.setEmail(request.getParameter("email"));
		dao.update(contact);
		response.sendRedirect("agenda");
	}

	protected void destroy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		contact.setId(Integer.parseInt(id));
		dao.delete(contact);
		response.sendRedirect("agenda");
	}
}
