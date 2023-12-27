package com.springbook.biz.userDetail;

public interface UserDetailService {

	UserDetailVO getUserDetail(UserDetailVO vo);

	void insertUserDetail(UserDetailVO vo);
	
	UserDetailVO findUserId(UserDetailVO vo);

}