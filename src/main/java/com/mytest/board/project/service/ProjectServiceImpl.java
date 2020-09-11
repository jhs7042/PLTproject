package com.mytest.board.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytest.board.project.dao.ProjectDAO;
import com.mytest.board.project.vo.ProjectVO;

@Service("prljectService")
public class ProjectServiceImpl implements ProjectService{
	@Autowired
	private ProjectDAO projectDAO;
	
	public List<ProjectVO> getList() throws Exception{
		List<ProjectVO> projectList = projectDAO.getList();
		return projectList;
	}
	
	public int addQue(ProjectVO projectVO) throws Exception{
		return projectDAO.addQue(projectVO);
	}
	
	public int addAnswer(ProjectVO projectVO) throws Exception{
		return projectDAO.addAnswer(projectVO);
	}
	
	public int modPro(Map<String, Object> proMap) throws Exception{
		return projectDAO.modPro(proMap);
	}
	
	public int delPro(int articleNO) throws Exception{
		return projectDAO.delPro(articleNO);
	}
	
}
