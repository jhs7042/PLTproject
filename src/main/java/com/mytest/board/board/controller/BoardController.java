package com.mytest.board.board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mytest.board.board.vo.BoardVO;
import com.mytest.board.board.vo.CommentVO;

public interface BoardController {
	
	public ModelAndView boardList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity write(@ModelAttribute("board") BoardVO board, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity updateArticle(@ModelAttribute("board") BoardVO board, @RequestParam("articleNO") int articleNO, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity deleteArticle(@RequestParam("articleNO") int articleNO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String ajax_addComment(@ModelAttribute("commentVO") CommentVO commentVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ResponseEntity ajax_commentList(@RequestParam("boId") int boId, HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public List<CommentVO> ajax_commentList(@RequestParam("boId") int boId, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ArrayList<HashMap> ajax_commentList(@RequestParam("boId") int boId, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
