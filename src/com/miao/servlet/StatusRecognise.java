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
		ServletContext servletContext = getServletContext();	//获取ServletContext对象
		RequestDispatcher dispatcher = null;	
		String employeeId = request.getParameter("employeeId");	//接收员工编号参数
		String password = request.getParameter("password");		//接收员工密码参数
		if (employeeId == null || "".equals(employeeId)) {		//判断是否输入员工编号
			request.setAttribute("error", "请输入员工编号！");
			dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");	//设置跳转页面
		}else {
			if (password == null || "".equals(password)) {		//判断是否输入密码
				request.setAttribute("error", "请输入系统口令");
				dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
			}else {
				EmployeeDAO employeeDAO = EmployeDAOFactory.getEmployeeDAOInstance();	//获取DAO实现类的对象
				Employee employee = employeeDAO.findEmployeeById(Integer.parseInt(employeeId));	//查询员工
				if (employee == null) {
					request.setAttribute("error", "该员工编号不存在！");
					dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
				}else {
					if (password.equals(employee.getPassword())) {
						request.getSession().setAttribute("employee", employee);	//将员工信息保存
						response.sendRedirect("index.jsp");
						return;
					}else {
						request.setAttribute("error", "系统口令不正确！");
						dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
					}
				}
			}
		}
		dispatcher.forward(request, response);	//进行跳转
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
