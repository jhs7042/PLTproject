package com.mytest.board.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytest.board.board.dao.BoardDAO;
import com.mytest.board.board.vo.BoardVO;
import com.mytest.board.board.vo.CommentVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;
	
	public List<BoardVO> boardList() throws Exception{
		List<BoardVO> list = boardDAO.selectAllList();
		return list;
	}
	
	public int insertText(BoardVO board) throws Exception{
		return boardDAO.insertText(board);
	}
	
	public BoardVO viewArticle(int articleNO) throws Exception{
		return boardDAO.viewArticle(articleNO);
	}
	
	public int updateArticle(BoardVO board) throws Exception{
		return boardDAO.updateArticle(board);
	}
	
	public int deleteArticle(int articleNO) throws Exception{
		return boardDAO.deleteArticle(articleNO);
	}
	
	public int addComment(CommentVO commentVO) throws Exception{
		return boardDAO.addComment(commentVO);
	}
	
	public List<CommentVO> commentList(int boId) throws Exception{
		List<CommentVO> coList = boardDAO.selectCommentList(boId);
		return coList;
	}
	
}
