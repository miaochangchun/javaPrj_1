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
		request.setCharacterEncoding("UTF-8");	//����ΪUTF-8����
		String criticismContent = request.getParameter("criticismContent");	//��ȡ��������
		int messageId = Integer.parseInt(request.getParameter("messageId"));//��ȡ��Ϣ��Id
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		// ��Session�л�ȡ��¼��Ϣ
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if (employee == null) {	//��¼��Ϣ�ѹ���
			request.setAttribute("error", "Ҫ�������������ȵ�¼��");
		}else {
			//���������ݲ���Ϊ��
			if (criticismContent == null || "".equals(criticismContent)) {
				request.setAttribute("error", "���������������ݣ�");
			}else {
				//�����������ݲ������ݿ�
				Criticism criticism = new Criticism();
				criticism.setCriticismContent(criticismContent);
				criticism.setEmployeeId(employee.getEmployeeId());
				criticism.setCriticismTime(new Date());
				criticism.setMessageId(messageId);
				CriticismDAO criticismDAO = CriticismDAOFactory.getCriticismDAOInstance();
				criticismDAO.addCriticism(criticism);
			}
		}
		//��ת��Get Messageҳ��
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
