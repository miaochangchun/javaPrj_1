package com.miao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miao.bean.Criticism;
import com.miao.bean.Message;
import com.miao.bean.Reply;
import com.miao.dao.CriticismDAO;
import com.miao.dao.MessageDAO;
import com.miao.dao.ReplyDAO;
import com.miao.factory.CriticismDAOFactory;
import com.miao.factory.MessageDAOFactory;
import com.miao.factory.ReplyDAOFactory;
import com.miao.util.Page;
import com.miao.util.PageUtil;

/**
 * Servlet implementation class GetMessage
 */
@WebServlet("/GetMessage")
public class GetMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��������ʱ���͹�����messageId
		int messageId = Integer.parseInt(request.getParameter("messageId"));
		MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
		Message message = messageDAO.findMessageById(messageId);
		request.setAttribute("message", message);
		
		//����Ϣ�����лظ���������List��
		int currentPage = 0;
		String currentPageStr = request.getParameter("currentPage");
		if (currentPageStr == null || "".equals(currentPageStr)) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		//��ҳ��ѯ�Ľ��
		ReplyDAO replyDAO = ReplyDAOFactory.getReplyDAOInstance();
		Page page = PageUtil.createPage(5, replyDAO.findCountByMsgId(messageId), currentPage);
		List<Reply> replys = replyDAO.findReplyByMsgId(messageId, page);
		request.setAttribute("replyList", replys);
		request.setAttribute("page", page);
		
		//��������Ķ���
		CriticismDAO criticismDAO = CriticismDAOFactory.getCriticismDAOInstance();
		Criticism criticism = criticismDAO.findCriticismByMsgId(messageId);
		request.setAttribute("criticism", criticism);
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/showMsg.jsp");
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
