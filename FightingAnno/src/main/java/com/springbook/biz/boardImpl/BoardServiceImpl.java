package com.springbook.biz.boardImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boardDAO = new BoardDAO();

	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);

	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);

	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);

	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> searchList(String searchCondition, String searchKeyword) {
		return boardDAO.searchList(searchCondition, searchKeyword);
	}

	@Override
	public void cntBoard(BoardVO vo) {
		boardDAO.cntBoard(vo);
		
	}

	@Override
	public List<BoardVO> getMyList(BoardVO vo) {
		return boardDAO.getMyList(vo);
	}

	@Override
	public void likeBoard(BoardVO vo) {
		boardDAO.likeBoard(vo);
		
	}
	
	
	
	
	
	
	
	

}
