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

import com.miao.bean.Employee;
import com.miao.bean.Message;
import com.miao.dao.MessageDAO;
import com.miao.factory.MessageDAOFactory;

/**
 * Servlet implementation class MsgPublish
 */
@WebServlet("/MsgPublish")
public class MsgPublish extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsgPublish() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if (employee == null) {
			request.setAttribute("error", "Ҫ������Ϣ�������Ƚ������ʶ��");
			dispatcher = servletContext.getRequestDispatcher("/publishNewMsg.jsp");
		}else {
			if (title == null || "".equals(title)) {
				request.setAttribute("error", "����������Ϣ����");
				dispatcher = servletContext.getRequestDispatcher("/publishNewMsg.jsp");
			}else {
				Message message = new Message();
				message.setEmployeeId(employee.getEmployeeId());
				message.setMessageTitle(title);
				message.setMessageContent(content);
				//java.util.Data�޷�����ʱ���룬�����ת��ΪtimeStamp����
//				message.setPublishTime(new Date(new java.util.Date().getTime()));
				message.setPublishTime(new Date());
				MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
				messageDAO.addMessage(message);
				dispatcher = servletContext.getRequestDispatcher("/GetMessageList");
			}
		}
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
