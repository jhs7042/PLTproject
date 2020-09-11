package com.mytest.board.project.dao;

import java.util.List;
import java.util.Map;

import com.mytest.board.project.vo.ProjectVO;

public interface ProjectDAO {
	public List<ProjectVO> getList() throws Exception;
	public int addQue(ProjectVO projectVO) throws Exception;
	public int addAnswer(ProjectVO projectVO) throws Exception;
	public int modPro(Map<String, Object> proMap) throws Exception;
	public int delPro(int articleNO) throws Exception;
}
