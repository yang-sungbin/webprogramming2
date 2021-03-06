package kr.ac.mjc.sungbin.myapp.student.model2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mjc.sungbin.myapp.student.dao.Student;
import kr.ac.mjc.sungbin.myapp.student.dao.StudentDao;

/**
 * Servlet implementation class StudentEditServlet
 */
@SuppressWarnings("serial")
@WebServlet("/student/model2/studentEdit")
public class StudentEditServlet extends HttpServlet {

	StudentDao studentDao = null;

	@Override
	public void init() throws ServletException {
		studentDao = (StudentDao) getServletContext()
				.getAttribute("studentDao");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		Student student = studentDao.getStudent(id);
		request.setAttribute("student", student);
		request.getServletContext()
				.getRequestDispatcher("/WEB-INF/jsp/student/el/studentEdit.jsp")
				.forward(request, response);
	}
}