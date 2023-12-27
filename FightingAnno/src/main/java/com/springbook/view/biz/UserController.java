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
		vo = (UserVO)session.getAttribute("user"); // 로그인할 때 session에 저장을 해줬으니까 그거 가져오기
		
		detailVO.setId(vo.getId()); //그거 가져와서 detail이랑 연동하기 위해 detailVO에 id 넣어주기
		
		UserDetailVO userDetail = detailDAO.getUserDetail(detailVO);
		session.setAttribute("userDetail", userDetail); //session에 넣어주고 불러오기
		
		return "myInfo.jsp";
		
	}
}
