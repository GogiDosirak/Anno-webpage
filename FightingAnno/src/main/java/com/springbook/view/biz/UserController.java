package com.springbook.view.biz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.userDetail.UserDetailVO;
import com.springbook.biz.userDetailImpl.UserDetailDAO;
import com.springbook.biz.userImpl.UserDAO;

@Controller
public class UserController {
	
	@RequestMapping("/memberJoin.do")
	public String memberJoin(UserVO vo, UserDAO userDAO, UserDetailVO detailVO, UserDetailDAO userDetailDAO)  {
	
		userDAO.insertUser(vo);
		userDetailDAO.insertUserDetail(detailVO);
		
		return "login.jsp";
			
	}
	
	@RequestMapping("/findId.do")
	public ModelAndView findId(UserDetailVO detailVO, UserDetailDAO userDetailDAO, ModelAndView mav) throws Exception {

		UserDetailVO userDetail = userDetailDAO.findUserId(detailVO);
		
		if(userDetail != null) {
			mav.addObject("userDetail", userDetail);
			mav.setViewName("findIdComplete.jsp");
			return mav;
		} else { 
			mav.setViewName("findId.jsp");
			return mav;
		}
			
			
		}
	
	@RequestMapping("/findPassword.do")
	public ModelAndView findPassword(UserVO vo, UserDAO userDAO, ModelAndView mav) throws Exception {
		
		UserVO user = userDAO.findUser(vo);
		
		if(user!=null) {
			mav = new ModelAndView();
			mav.addObject("user", user);
			mav.setViewName("findPasswordComplete.jsp");
			return mav;
		} else {
			mav = new ModelAndView();
			mav.setViewName("findPassword.jsp");
			return mav;
		}
		
		
	}
	
	@RequestMapping("/myInfo.do")
	public String myInfo(UserVO vo, UserDAO userDAO, UserDetailVO detailVO, UserDetailDAO detailDAO, HttpSession session) throws Exception {
		vo = (UserVO)session.getAttribute("user"); // �α����� �� session�� ������ �������ϱ� �װ� ��������
		
		detailVO.setId(vo.getId()); //�װ� �����ͼ� detail�̶� �����ϱ� ���� detailVO�� id �־��ֱ�
		
		UserDetailVO userDetail = detailDAO.getUserDetail(detailVO);
		session.setAttribute("userDetail", userDetail); //session�� �־��ְ� �ҷ�����
		
		return "myInfo.jsp";
		
	}
}
