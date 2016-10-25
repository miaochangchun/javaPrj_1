package com.miao.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miao.bean.Criticism;
import com.miao.bean.Employee;
import com.miao.dao.CriticismDAO;
import com.miao.factory.CriticismDAOFactory;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

/**
 * Servlet implementation class CommitCriticism
 */
@WebServlet("/CommitCriticism")
public class CommitCriticism extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommitCriticism() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");	//设置为UTF-8编码
		String criticismContent = request.getParameter("criticismContent");	//获取批复内容
		int messageId = Integer.parseInt(request.getParameter("messageId"));//获取消息的Id
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		// 从Session中获取登录信息
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if (employee == null) {	//登录信息已过期
			request.setAttribute("error", "要进行批复必须先登录！");
		}else {
			//批复的内容不能为空
			if (criticismContent == null || "".equals(criticismContent)) {
				request.setAttribute("error", "必须输入批复内容！");
			}else {
				//把批复的内容插入数据库
				Criticism criticism = new Criticism();
				criticism.setCriticismContent(criticismContent);
				criticism.setEmployeeId(employee.getEmployeeId());
				criticism.setCriticismTime(new Date());
				criticism.setMessageId(messageId);
				CriticismDAO criticismDAO = CriticismDAOFactory.getCriticismDAOInstance();
				criticismDAO.addCriticism(criticism);
			}
		}
		//跳转到Get Message页面
		dispatcher = servletContext.getRequestDispatcher("/GetMessage?messageId=" + messageId);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
