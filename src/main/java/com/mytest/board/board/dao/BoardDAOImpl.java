package com.mytest.board.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mytest.board.board.vo.BoardVO;
import com.mytest.board.board.vo.CommentVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardVO> selectAllList() throws Exception{
		List<BoardVO> list = sqlSession.selectList("mapper.board.selectAllList");
		return list;
	}
	
	public int insertText(BoardVO board) throws Exception{
		int result = sqlSession.insert("mapper.board.insertText", board);
		return result;
	}
	
	public BoardVO viewArticle(int articleNO) throws Exception{
		BoardVO vo = new BoardVO();
		vo = sqlSession.selectOne("mapper.board.viewArticle", articleNO);
		return vo;
	}
	
	public int updateArticle(BoardVO board) throws Exception{
		int result = sqlSession.update("mapper.board.updateArticle", board);
		return result;
	}
	
	public int deleteArticle(int articleNO) throws Exception{
		int result = sqlSession.delete("mapper.board.deleteArticle", articleNO);
		return result;
	}
	
	public int addComment(CommentVO commentVO) throws Exception{
		int result = sqlSession.delete("mapper.board.addComment", commentVO);
		return result;
	}
	
	public List<CommentVO> selectCommentList(int boId) throws Exception{
		List<CommentVO> coList = sqlSession.selectList("mapper.board.commentList", boId);
		return coList;
	}
	
}
