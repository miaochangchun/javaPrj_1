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

import com.miao.bean.Message;
import com.miao.dao.MessageDAO;
import com.miao.factory.MessageDAOFactory;
import com.miao.util.Page;
import com.miao.util.PageUtil;

/**
 * Servlet implementation class GetMessageList
 */
@WebServlet("/GetMessageList")
public class GetMessageList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMessageList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int currentPage = 0;	//当前页
		String currentPageStr = request.getParameter("currentPage");
		if (currentPageStr == null || "".equals(currentPageStr)) {
			currentPage = 1;
		}else{
			currentPage = Integer.parseInt(currentPageStr);
		}
		//分页查询
		MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
		Page page = PageUtil.createPage(5, messageDAO.findAllCount(), currentPage);
		List<Message> messages = messageDAO.findAllMessage(page);
		request.setAttribute("messageList", messages);
		request.setAttribute("page", page);
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/msgList.jsp");
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
