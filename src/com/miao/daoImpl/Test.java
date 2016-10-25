package com.miao.daoImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.miao.bean.Criticism;
import com.miao.bean.Employee;
import com.miao.bean.Message;
import com.miao.bean.Reply;
import com.miao.dao.CriticismDAO;
import com.miao.dao.EmployeeDAO;
import com.miao.dao.MessageDAO;
import com.miao.dao.ReplyDAO;
import com.miao.factory.CriticismDAOFactory;
import com.miao.factory.EmployeDAOFactory;
import com.miao.factory.MessageDAOFactory;
import com.miao.factory.ReplyDAOFactory;
import com.miao.util.PageUtil;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		EmployeeDAO employeeDAO = EmployeDAOFactory.getEmployeeDAOInstance();
//		Employee employee = new Employee();
//		employee.setEmployeeId(3334);
//		employee.setEmployeeName("chun");
//		employee.setEmployeeSex(true);
//		String dateTime = "1989-01-01 22:22:22";
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:MM:ss");
//		Date date = null;
//		try {
//			date = sdf.parse(dateTime);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		employee.setEmployeeBirth(date);
//		employee.setEmployeePhone("18035158523");
//		employee.setEmployeePlace("北京市昌平区龙跃苑wu区");
//		employee.setJoinTime(new Date());
//		employee.setPassword("111111");
//		employee.setLead(false);
////		System.out.println(employee);
////		employeeDAO.addEmployee(employee);
////		employeeDAO.updateEmployee(employee);
////		employeeDAO.deleteEmployee(1);
////		
//		List<Employee> list = employeeDAO.findAllEmployee();
//		Iterator<Employee> iterator = list.iterator();
//		while(iterator.hasNext()){
//			Employee employee2 = iterator.next();
//			System.out.println(employee2);
//		}
		
//		MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
//		Message message2 = new Message();
//		message2.setMessageTitle("今晚上早点睡觉2");
//		message2.setMessageContent("123456799822227654321");
//		message2.setEmployeeId(3334);
//		message2.setPublishTime(new Date());
////		messageDAO.deleteMessage(16);
////		messageDAO.addMessage(message2);
//		
//		int count = messageDAO.findAllCount();
//		System.out.println(count);
//		
//		Message message3 = messageDAO.findMessageById(20);
//		System.out.println(message3);
//		
//		List<Message> list = messageDAO.findAllMessage(PageUtil.createPage(10, 0, 0));
//		Iterator<Message> iterator = list.iterator();
//		while(iterator.hasNext()){
//			Message message = iterator.next();
//			System.out.println(message);
//		}
		
//		Reply reply = new Reply();
//		reply.setReplyContent("这又是一个测试，呵呵~1231398752322");
//		reply.setReplyTime(new Date());
//		reply.setMessageId(28);
//		reply.setEmployeeId(3334);
////		
//		ReplyDAO replyDAO = ReplyDAOFactory.getReplyDAOInstance();
//		
//		replyDAO.addReply(reply);
//		
//		int count = replyDAO.findCountByMsgId(28);
//		System.out.println(count);
//		
//		
//		
//		List<Reply> list = replyDAO.findReplyByMsgId(28, PageUtil.createPage(4, count, 0));
//		Iterator<Reply> iterator = list.iterator();
//		while(iterator.hasNext()){
//			Reply reply2 = iterator.next();
//			System.out.println(reply2);
//		}
		
		Criticism criticism = new Criticism();
		criticism.setCriticismContent("这又是一个测试，大家好好工作.enenen");
		criticism.setCriticismTime(new Date());
		criticism.setEmployeeId(3333);
		criticism.setMessageId(28);
//		System.out.println(criticism);
		CriticismDAO criticismDAO = CriticismDAOFactory.getCriticismDAOInstance();
//		criticismDAO.addCriticism(criticism);
		
		Criticism criticism2 = criticismDAO.findCriticismByMsgId(28);
		System.out.println(criticism2);
	}

}
