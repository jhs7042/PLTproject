package com.mytest.board.board.service;

import java.util.List;

import com.mytest.board.board.vo.BoardVO;
import com.mytest.board.board.vo.CommentVO;

public interface BoardService {
	
	public List<BoardVO> boardList() throws Exception;
	public int insertText(BoardVO board) throws Exception;
	public BoardVO viewArticle(int articleNO) throws Exception;
	public int updateArticle(BoardVO board) throws Exception;
	public int deleteArticle(int articleNO) throws Exception;
	public int addComment(CommentVO commentVO) throws Exception;
	public List<CommentVO> commentList(int boId) throws Exception;

}
