package com.mytest.board.qnaBoard.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mytest.board.qnaBoard.vo.QnABoardVO;

public interface QnABoardDAO {
	public List<QnABoardVO> selectAllArticlesList() throws Exception;
//	public int insertNewArticle(Map articleMap) throws DataAccessException;
//	public void insertNewImage(Map articleMap) throws DataAccessException;
	public int insertNewArticle(QnABoardVO qnaBoard) throws Exception;
	public QnABoardVO viewArticle(int articleNO) throws Exception;
}
