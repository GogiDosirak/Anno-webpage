package com.springbook.biz.board;

import java.util.List;

public interface BoardService {

	void insertBoard(BoardVO vo);

	void deleteBoard(BoardVO vo);

	void updateBoard(BoardVO vo);

	List<BoardVO> getBoardList(BoardVO vo);

	BoardVO getBoard(BoardVO vo);
	
	List<BoardVO> searchList(String searchCondition, String searchKeyword);
	
	void cntBoard(BoardVO vo);
	
	List<BoardVO> getMyList(BoardVO vo);
	
	void likeBoard(BoardVO vo);

}