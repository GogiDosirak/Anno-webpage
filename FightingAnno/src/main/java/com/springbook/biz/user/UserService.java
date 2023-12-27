package com.springbook.biz.user;

public interface UserService {

	UserVO getUser(UserVO vo);

	void insertUser(UserVO vo);
	
	UserVO findUser(UserVO vo);

}