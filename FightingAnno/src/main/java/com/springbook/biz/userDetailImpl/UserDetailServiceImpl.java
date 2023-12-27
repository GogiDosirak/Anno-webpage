package com.springbook.biz.userDetailImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.userDetail.UserDetailService;
import com.springbook.biz.userDetail.UserDetailVO;

@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailService{
	@Autowired
	UserDetailDAO userDetailDAO = new UserDetailDAO();

	@Override
	public UserDetailVO getUserDetail(UserDetailVO vo) {
		return userDetailDAO.getUserDetail(vo);
	}

	@Override
	public void insertUserDetail(UserDetailVO vo) {
		userDetailDAO.insertUserDetail(vo);
		
	}

	@Override
	public UserDetailVO findUserId(UserDetailVO vo) {
		return userDetailDAO.findUserId(vo);
	}
	
	
	

}
