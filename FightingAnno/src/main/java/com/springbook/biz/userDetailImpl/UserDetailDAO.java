package com.springbook.biz.userDetailImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.userDetail.UserDetailService;
import com.springbook.biz.userDetail.UserDetailVO;

@Repository("userDetailDAO")
public class UserDetailDAO  {
	public Connection conn = null;
	public PreparedStatement stmt = null;
	public ResultSet rs = null;
	
	private static final String USERDETAIL_GET = "select * from userDetail where id=?";
	private static final String USERDETAIL_INSERT = "insert into userDetail values(?,?,?,?,?)";
	private static final String USERID_FIND = "select * from userDetail where phoneNumber1=? and phoneNumber2=? and email=?";
	

	public UserDetailVO getUserDetail(UserDetailVO vo) {
		UserDetailVO userDetail = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USERDETAIL_GET);
			stmt.setString(1, vo.getId());
			rs = stmt.executeQuery();
			if(rs.next()) {
				userDetail = new UserDetailVO();
				userDetail.setId(rs.getString("id"));
				userDetail.setPhoneNumber1(rs.getString("phoneNumber1"));
				userDetail.setPhoneNumber2(rs.getString("phoneNumber2"));
				userDetail.setAddress(rs.getString("address"));
				userDetail.setEmail(rs.getString("email"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return userDetail;
		
	}
	

	public void insertUserDetail(UserDetailVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USERDETAIL_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPhoneNumber1());
			stmt.setString(3, vo.getPhoneNumber2());
			stmt.setString(4, vo.getAddress());
			stmt.setString(5, vo.getEmail());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}
	
	public UserDetailVO findUserId(UserDetailVO vo) {
		UserDetailVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USERID_FIND);
			stmt.setString(1, vo.getPhoneNumber1());
			stmt.setString(2, vo.getPhoneNumber2());
			stmt.setString(3, vo.getEmail());
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserDetailVO();
				user.setId(rs.getString("id"));
				user.setPhoneNumber1(rs.getString("phoneNumber1"));
				user.setPhoneNumber2(rs.getString("phoneNumber2"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
			}	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return user;
	}

}
