package com.mytest.board.qnaBoard.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mytest.board.qnaBoard.dao.QnABoardDAO;
import com.mytest.board.qnaBoard.vo.QnABoardVO;

@Service("qnaBoardService")
@Transactional(propagation = Propagation.REQUIRED)
public class QnABoardServiceImpl implements QnABoardService{
	@Autowired
	private QnABoardDAO qnaBoardDAO;
	
	public List<QnABoardVO> listArticles() throws Exception{
		List<QnABoardVO> articlesList = qnaBoardDAO.selectAllArticlesList();
		return articlesList;
	}
	
//	public int addNewArticle(Map articleMap) throws Exception{
//		System.out.println("Service1 : "+articleMap);
//		int articleNO = qnaBoardDAO.insertNewArticle(articleMap);
//		articleMap.put("articleNO", articleNO);
//		System.out.println("Service2 : "+articleNO);
//		qnaBoardDAO.insertNewImage(articleMap);
//		return articleNO;
//	}
	
	public int addNewArticle(QnABoardVO qnaBoard) throws Exception{
		return qnaBoardDAO.insertNewArticle(qnaBoard);
	}
	
	public QnABoardVO viewArticle(int articleNO) throws Exception{
		return qnaBoardDAO.viewArticle(articleNO);
	}
	
}
