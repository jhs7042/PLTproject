package com.mytest.board.project.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mytest.board.project.vo.ProjectVO;

@Repository("projectDAO")
public class ProjectDAOImpl implements ProjectDAO{
	@Autowired
	private SqlSession sqlSession;
	
	public List<ProjectVO> getList() throws Exception{
		List<ProjectVO> projectList = sqlSession.selectList("mapper.project.getList");
		return projectList;
	}
	
	public int addQue(ProjectVO projectVO) throws Exception{
		return sqlSession.insert("mapper.project.addQue", projectVO);
	}
	
	public int addAnswer(ProjectVO projectVO) throws Exception{
		return sqlSession.insert("mapper.project.addQue", projectVO);
	}
	
	public int modPro(Map<String, Object> proMap) throws Exception{
		return sqlSession.update("mapper.project.modPro", proMap);
	}
	
	public int delPro(int articleNO) throws Exception{
		return sqlSession.delete("mapper.project.delPro", articleNO);
	}
	
}
