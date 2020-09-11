package com.mytest.board.project.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mytest.board.project.vo.ProjectVO;

public interface ProjectController {
	public ModelAndView projectList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public @ResponseBody ArrayList<HashMap> getList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String addQue(@ModelAttribute("projectVO") ProjectVO projectVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity addAnswer(@ModelAttribute("projectVO") ProjectVO projectVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String modPro(@RequestParam("content") String content, @RequestParam("articleNO") int articleNO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String delPro(@RequestParam("articleNO") int articleNO, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
