package com.springbook.view.biz;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.userImpl.UserDAO;

@Controller
public class LoginController {

	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String loginView(UserVO vo) {
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		UserVO user = userDAO.getUser(vo);
		
		if(user != null) {
			session.setAttribute("user",user);
			return "getBoardList.do";
		} else {
			return "login.jsp";
			
		}
	}
	
	
	
}