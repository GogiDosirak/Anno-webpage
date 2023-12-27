package com.springbook.biz.commentImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.comment.CommentService;
import com.springbook.biz.comment.CommentVO;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDAO commentDAO = new CommentDAO();

	@Override
	public void insertComment(CommentVO vo) {
		commentDAO.insertComment(vo);

	}

	@Override
	public void deleteComment(CommentVO vo) {
		commentDAO.deleteComment(vo);

	}

	@Override
	public void updateComment(CommentVO vo) {
		commentDAO.updateComment(vo);

	}

	@Override
	public List<CommentVO> getCommentList(CommentVO vo) {
		return commentDAO.getCommentList(vo);
	}

}
