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
import com.miao.bean.Reply;
import com.miao.dao.ReplyDAO;
import com.miao.factory.ReplyDAOFactory;

/**
 * Servlet implementation class CommitReply
 */
@WebServlet("/CommitReply")
public class CommitReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommitReply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String replyContent = request.getParameter("replyContent");
		int messageId = Integer.parseInt(request.getParameter("messageId"));
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if (employee == null) {
			request.setAttribute("error", "要进行回复必须先登录！");
		}else {
			if (replyContent == null || "".equals(replyContent)) {
				request.setAttribute("error", "必须输入回复内容");
			}else {
				//把回复的信息插入数据库
				Reply reply = new Reply();
				reply.setReplyContent(replyContent);
				reply.setMessageId(messageId);
				reply.setEmployeeId(employee.getEmployeeId());
				reply.setReplyTime(new Date());
				ReplyDAO replyDAO = ReplyDAOFactory.getReplyDAOInstance();
				replyDAO.addReply(reply);
			}
		}
		//跳转到Get Message页面，并根据message进行查询
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
