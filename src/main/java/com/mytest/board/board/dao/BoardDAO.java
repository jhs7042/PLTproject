package com.mytest.board.board.dao;

import java.util.List;

import com.mytest.board.board.vo.BoardVO;
import com.mytest.board.board.vo.CommentVO;

public interface BoardDAO {
	
	public List<BoardVO> selectAllList() throws Exception;
	public int insertText(BoardVO board) throws Exception;
	public BoardVO viewArticle(int articleNO) throws Exception;
	public int updateArticle(BoardVO board) throws Exception;
	public int deleteArticle(int articleNO) throws Exception;
	public int addComment(CommentVO commentVO) throws Exception;
	public List<CommentVO> selectCommentList(int boId) throws Exception;

}
