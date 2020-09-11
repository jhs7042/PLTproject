package com.mytest.board.qnaBoard.service;

import java.util.List;
import java.util.Map;

import com.mytest.board.qnaBoard.vo.QnABoardVO;

public interface QnABoardService {
	public List<QnABoardVO> listArticles() throws Exception;
//	public int addNewArticle(Map articleMap) throws Exception;
	public int addNewArticle(QnABoardVO qnaBoard) throws Exception;
	public QnABoardVO viewArticle(int articleNO) throws Exception;
}
