package com.mytest.board.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mytest.board.project.service.ProjectService;
import com.mytest.board.project.vo.ProjectVO;

@Controller("projectController")
public class ProjectControllerImpl implements ProjectController{
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ProjectVO projectVO;
	
	@RequestMapping(value="project/projectList.do", method=RequestMethod.GET)
	public ModelAndView projectList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="project/getList.do", method= {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody ArrayList<HashMap> getList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpHeaders responseHeaders = new HttpHeaders();
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		try {
			List<ProjectVO> projectList = projectService.getList();
			if(projectList.size() > 0) {
				for(int i=0; i<projectList.size(); i++) {
					HashMap pl = new HashMap();
					pl.put("level", projectList.get(i).getLevel());
					pl.put("articleNO", projectList.get(i).getArticleNO());
					pl.put("writer", projectList.get(i).getWriter());
					pl.put("content", projectList.get(i).getContent());
					pl.put("writeDate", projectList.get(i).getWriteDate());
					list.add(pl);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="project/addQue.do", method=RequestMethod.POST)
	@ResponseBody
	public String addQue(@ModelAttribute("projectVO") ProjectVO projectVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		try {
			int result = projectService.addQue(projectVO);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	@RequestMapping(value="project/addAnswer.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addAnswer(@ModelAttribute("projectVO") ProjectVO projectVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html; charset=utf-8");
		int articleNO = projectVO.getArticleNO();
		projectVO.setParentNO(articleNO);
		projectVO.setArticleNO(0);
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int result = projectService.addAnswer(projectVO);
			message = "<script>";
			message += " alert('답변이 등록되었습니다.');";
			message += " location.href='"+request.getContextPath()+"/project/projectList.do';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			message = "<script>";
			message += " alert('오류가 발생했습니다.');";
			message += " location.href='"+request.getContextPath()+"/project/projectList.do';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	
	@RequestMapping(value="project/modPro.do", method=RequestMethod.POST)
	@ResponseBody
	public String modPro(@RequestParam("content") String content, @RequestParam("articleNO") int articleNO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		Map<String, Object> proMap = new HashMap<String, Object>();
		proMap.put("content", content);
		proMap.put("articleNO", articleNO);
		try {
			int result = projectService.modPro(proMap);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	@RequestMapping(value="project/delPro.do", method=RequestMethod.POST)
	@ResponseBody
	public String delPro(@RequestParam("articleNO") int articleNO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			int result = projectService.delPro(articleNO);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
