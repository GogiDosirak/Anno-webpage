package com.springbook.biz.commentImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.comment.CommentService;
import com.springbook.biz.comment.CommentVO;
import com.springbook.biz.common.JDBCUtil;

@Repository("commentDAO")
public class CommentDAO  {
	public Connection conn = null;
	public PreparedStatement stmt = null;
	public ResultSet rs = null;
	
	private static final String COMMNET_INSERT = "insert into comment(seq,co_seq,co_nickname,co_content) values(?,(select nvl(max(co_seq),0)+1 from comment where seq=?),?,?)";
	private static final String COMMENT_LIST = "select * from comment where seq=? order by co_RegDate";
	private static final String COMMENT_DELETE = "delete from comment where seq=?";
	private static final String COMMENT_UPDATE = "update comment set co_content=? where co_seq=? and seq=?";
	

	public void insertComment(CommentVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(COMMNET_INSERT);
			stmt.setInt(1, vo.getSeq());
			stmt.setInt(2, vo.getSeq());
			stmt.setString(3, vo.getCo_NickName());
			stmt.setString(4, vo.getCo_Content());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
		
	}
	

	public void deleteComment(CommentVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(COMMENT_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}
	

	public void updateComment(CommentVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(COMMENT_UPDATE);
			stmt.setString(1, vo.getCo_Content());
			stmt.setInt(2, vo.getCo_Seq());
			stmt.setInt(3, vo.getSeq());
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}

	public List<CommentVO> getCommentList(CommentVO vo) {
		List<CommentVO> commentList = new ArrayList<CommentVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(COMMENT_LIST);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			while(rs.next()) {
				CommentVO comment = new CommentVO();
				comment.setSeq(rs.getInt("seq"));
				comment.setCo_Seq(rs.getInt("co_Seq"));
				comment.setCo_NickName(rs.getString("co_NickName"));
				comment.setCo_Content(rs.getString("co_Content"));
				comment.setCo_RegDate(rs.getDate("co_RegDate"));
				commentList.add(comment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return commentList;
	}

}
