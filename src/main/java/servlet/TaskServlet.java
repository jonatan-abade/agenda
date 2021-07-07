package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.TaskBean;
import dao.TaskDao;

@WebServlet(urlPatterns = { "/tasks", "/addTask", "/editTask", "/updateTask", "/deleteTask" })
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TaskDao task = new TaskDao();
	TaskBean taskBean = new TaskBean(null, null, null, null);

	public TaskServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/tasks")) {
			tasks(request, response);
			return;
		} else if (action.equals("/addTask")) {
			store(request, response);
			return;
		} else if (action.equals("/editTask")) {
			edit(request, response);
			return;
		} else if (action.equals("/updateTask")) {
			update(request, response);
			return;
		} else if (action.equals("/deleteTask")) {
			destroy(request, response);
			return;
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void tasks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<TaskBean> list = task.getAll();
		request.setAttribute("tasks", list);
		RequestDispatcher rd = request.getRequestDispatcher("tasks/index.jsp");
		rd.forward(request, response);
	}

	protected void store(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		TaskBean userBean = new TaskBean(null, title, description, status);
		task.create(userBean);
		response.sendRedirect("tasks");
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		taskBean.setId(Integer.parseInt(id));
		task.getTask(taskBean);
		request.setAttribute("id", taskBean.getId());
		request.setAttribute("title", taskBean.getTitle());
		request.setAttribute("description", taskBean.getDescription());
		request.setAttribute("status", taskBean.getStatus());
		RequestDispatcher rd = request.getRequestDispatcher("tasks/edit.jsp");
		rd.forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		taskBean.setId(Integer.parseInt(request.getParameter("id")));
		taskBean.setTitle(request.getParameter("title"));
		taskBean.setDescription(request.getParameter("description"));
		taskBean.setStatus(request.getParameter("status"));
		task.update(taskBean);
		response.sendRedirect("tasks");
	}

	protected void destroy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		taskBean.setId(Integer.parseInt(id));
		task.delete(taskBean);
		response.sendRedirect("tasks");
	}

}
