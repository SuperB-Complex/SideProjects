package jjm.learn.listener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import jjm.learn.entity.User;
import jjm.learn.util.MySessionUtil;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {

	private Map<String, User> userMap;
	
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
		userMap = (Map<String, User>)arg0.getServletContext().getAttribute("usersMap");
		
		if (userMap == null) {
			userMap = new HashMap<String, User> ();
			
			// for test
//			System.out.println("constructing new user!");
//			User user = new User();
//			user.setSessionId("1222");
//			user.setFirstTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//			user.setIp("1222");
//			userMap.put("jjm", user);
			
		} 
//		else {
//			
//			// for test
//			System.out.println("user map not null!");
//		}
		
		HttpServletRequest request = (HttpServletRequest) arg0.getServletRequest();
		String sessionId = request.getSession().getId();
		
		if (MySessionUtil.getUserBySessionId(userMap, sessionId) == null) {
			User user = new User();
			user.setSessionId(sessionId);
			user.setFirstTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			user.setIp(request.getRemoteAddr());
			userMap.put(sessionId, user);
		}
		
		arg0.getServletContext().setAttribute("usersMap", userMap);
	}

}
