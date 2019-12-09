package jjm.learn.listener;

import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import jjm.learn.entity.User;
import jjm.learn.util.MySessionUtil;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

	private static int numberOfUser = 0;

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		numberOfUser++;
		arg0.getSession().getServletContext().setAttribute("numberOfUsers", numberOfUser);
		
//		Map<String, User> userMap = (Map<String, User>)arg0.getSession().getServletContext().getAttribute("usersMap");
//		
//		System.out.println(userMap.size());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		numberOfUser--;
		arg0.getSession().getServletContext().setAttribute("numberOfUsers", numberOfUser);
	
		Map<String, User> userMap = null;
		
		userMap = (Map<String, User>)arg0.getSession().getServletContext().getAttribute("usersMap");
		
		if (MySessionUtil.getUserBySessionId(userMap, arg0.getSession().getId()) != null) {
			userMap.remove(MySessionUtil.getUserBySessionId(userMap, arg0.getSession().getId()));
		}
		
	
	}
	

}
