package com.miao.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miao.bean.Employee;
import com.miao.dao.EmployeeDAO;
import com.miao.factory.EmployeDAOFactory;

/**
 * Servlet implementation class StatusRecognise
 */
@WebServlet("/StatusRecognise")
public class StatusRecognise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusRecognise() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletContext = getServletContext();	//��ȡServletContext����
		RequestDispatcher dispatcher = null;	
		String employeeId = request.getParameter("employeeId");	//����Ա����Ų���
		String password = request.getParameter("password");		//����Ա���������
		if (employeeId == null || "".equals(employeeId)) {		//�ж��Ƿ�����Ա�����
			request.setAttribute("error", "������Ա����ţ�");
			dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");	//������תҳ��
		}else {
			if (password == null || "".equals(password)) {		//�ж��Ƿ���������
				request.setAttribute("error", "������ϵͳ����");
				dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
			}else {
				EmployeeDAO employeeDAO = EmployeDAOFactory.getEmployeeDAOInstance();	//��ȡDAOʵ����Ķ���
				Employee employee = employeeDAO.findEmployeeById(Integer.parseInt(employeeId));	//��ѯԱ��
				if (employee == null) {
					request.setAttribute("error", "��Ա����Ų����ڣ�");
					dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
				}else {
					if (password.equals(employee.getPassword())) {
						request.getSession().setAttribute("employee", employee);	//��Ա����Ϣ����
						response.sendRedirect("index.jsp");
						return;
					}else {
						request.setAttribute("error", "ϵͳ�����ȷ��");
						dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
					}
				}
			}
		}
		dispatcher.forward(request, response);	//������ת
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
