package com.mytest.board.project.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mytest.board.project.vo.ProjectVO;

public interface ProjectService {
	
	public List<ProjectVO> getList() throws Exception;
	public int addQue(ProjectVO projectVO) throws Exception;
	public int addAnswer(ProjectVO projectVO) throws Exception;
	public int modPro(Map<String, Object> proMap) throws Exception;
	public int delPro(int articleNO) throws Exception;
}
