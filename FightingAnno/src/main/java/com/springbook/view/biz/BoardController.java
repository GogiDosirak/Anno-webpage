package com.springbook.view.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.boardImpl.BoardDAO;
import com.springbook.biz.comment.CommentVO;
import com.springbook.biz.commentImpl.CommentDAO;
import com.springbook.biz.user.UserVO;

@Controller
public class BoardController {

	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO, CommentVO co, CommentDAO commentDAO) {
		commentDAO.deleteComment(co);
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";

	}

	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, HttpSession session) {
		
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		session.setAttribute("boardList", boardList);
		return "getBoardList.jsp";

	}

	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, CommentVO co, CommentDAO commentDAO, ModelAndView mav) {

		BoardVO board = boardDAO.getBoard(vo);
		boardDAO.cntBoard(vo);

		List<CommentVO> commentList = commentDAO.getCommentList(co);

		mav.addObject("board", board);
		mav.addObject("commentList", commentList);
		mav.setViewName("getBoard.jsp");
		return mav;
	}
	
	@RequestMapping("/getMyList.do")
	public String getMyList(UserVO user, BoardVO vo, BoardDAO boardDAO, HttpSession session) {
		user = (UserVO)session.getAttribute("user");
		
		vo.setWriter(user.getName());
		
		List<BoardVO> boardList = boardDAO.getMyList(vo);
		session.setAttribute("boardList", boardList);
		return "getBoardList.jsp";
	}
	
	@RequestMapping("/likeBoard.do")
	public String likeBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.likeBoard(vo);
		return "getBoardList.do";
		
		
	}
	
	@RequestMapping("/insertComment.do")
	public String insertComment(BoardVO vo, CommentVO co, CommentDAO commentDAO)  {
		commentDAO.insertComment(co);
		return "getBoard.do";
		
	}
	
	@RequestMapping("/searchList.do")
	public ModelAndView searchList(String searchCondition, String searchKeyword, BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		List<BoardVO> boardList = boardDAO.searchList(searchCondition, searchKeyword);

		if (searchKeyword == null || searchKeyword == "") {
			mav = new ModelAndView();
			mav.setViewName("getBoardList.do");
			return mav;
		} else {
			mav = new ModelAndView();
			mav.addObject("boardList", boardList);
			mav.setViewName("getBoardList.jsp");
			return mav;
		}

	}

}
