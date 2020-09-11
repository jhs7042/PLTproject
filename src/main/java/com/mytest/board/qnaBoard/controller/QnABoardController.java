package com.mytest.board.qnaBoard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mytest.board.qnaBoard.vo.QnABoardVO;

public interface QnABoardController {
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ResponseEntity addNewArticle(MultipartHttpServletRequest request, HttpServletResponse resopnse) throws Exception;
	public ResponseEntity addNewArticle(@ModelAttribute QnABoardVO qnaBoard, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewArticle(@RequestParam("articleNO") int articleNO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public void imageUpload(@RequestParam MultipartFile upload,	@RequestParam("id") String id,
			MultipartHttpServletRequest request, HttpServletResponse response, MultipartHttpServletRequest multiFile) throws Exception;
}
