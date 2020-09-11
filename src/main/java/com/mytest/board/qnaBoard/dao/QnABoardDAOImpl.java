package com.mytest.board.qnaBoard.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mytest.board.qnaBoard.vo.ImageVO;
import com.mytest.board.qnaBoard.vo.QnABoardVO;

@Repository("qnaBoardDAO")
public class QnABoardDAOImpl implements QnABoardDAO{
	@Autowired
	private SqlSession sqlSession;
	
	public List<QnABoardVO> selectAllArticlesList() throws Exception{
		List<QnABoardVO> articlesList = sqlSession.selectList("mapper.qnaBoard.selectAllList");
		return articlesList;
	}
	
	public int insertNewArticle(QnABoardVO qnaBoard) throws Exception{
		int articleNO = selectNewArticleNO();
		qnaBoard.setArticleNO(articleNO);
		int result = sqlSession.insert("mapper.qnaBoard.insertNewArticle", qnaBoard);
		return result;
	}
	
	public QnABoardVO viewArticle(int articleNO) throws Exception{
		return sqlSession.selectOne("mapper.qnaBoard.viewArticle", articleNO);
	}
	
//	public int insertNewArticle(Map articleMap) throws DataAccessException{
//		int articleNO = selectNewArticleNO();
//		articleMap.put("articleNO", articleNO);
//		sqlSession.insert("mapper.qnaBoard.insertNewArticle", articleMap);
//		return articleNO;
//	}
	
//	public void insertNewImage(Map articleMap) throws DataAccessException{
//		System.out.println("dao: "+articleMap);
//		List<ImageVO> imageFileList = (ArrayList)articleMap.get("imageFileList");
//		int articleNO = (Integer)articleMap.get("articleNO");
//		int imageFileNO = selectNewImageFileNO();
//		for(ImageVO imageVO : imageFileList) {
//			imageVO.setImageFileNO(++imageFileNO);
//			imageVO.setArticleNO(articleNO);
//		}
//		System.out.println("dao2: " + articleMap);
//		sqlSession.insert("mapper.qnaBoard.insertNewImage", imageFileList);
//	}
	
	private int selectNewArticleNO() throws DataAccessException{
		return sqlSession.selectOne("mapper.qnaBoard.selectNewArticleNO");
	}
	
//	private int selectNewImageFileNO() throws DataAccessException{
//		return sqlSession.selectOne("mapper.qnaBoard.selectNewImageFileNO");
//	}
	
}
