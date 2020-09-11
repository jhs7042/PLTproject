package com.mytest.board.board.controller;

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

import com.mytest.board.board.service.BoardService;
import com.mytest.board.board.vo.BoardVO;
import com.mytest.board.board.vo.CommentVO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller("boardController")
public class BoardControllerImpl implements BoardController{
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardVO boardVO;
	
	@RequestMapping(value="board/boardList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView boardList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		List<BoardVO> boardList = boardService.boardList();
		System.out.println(boardList);
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="board/*Form.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Form(@ModelAttribute("board") BoardVO board, HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println(board);
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="board/write.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity write(@ModelAttribute("board") BoardVO board, HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println(board);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int result = boardService.insertText(board);
			message = "<script>";
			message += " alert('글이 작성되었습니다.');";
			message += " location.href='"+request.getContextPath()+"/board/boardList.do';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			message = "<script>";
			message += " alert('오류가 발생했습니다!!!');";
			message += " location.href='"+request.getContextPath()+"/board/boardList.do';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	
	@RequestMapping(value="board/viewArticle.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView viewArticle(@RequestParam("articleNO") int articleNO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String) request.getAttribute("viewName");
		boardVO = boardService.viewArticle(articleNO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("article", boardVO);
		return mav;
	}
	
	@RequestMapping(value="board/updateArticle.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity updateArticle(@ModelAttribute("board") BoardVO board, @RequestParam("articleNO") int articleNO, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println(board);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int result = boardService.updateArticle(board);	
			message = "<script>";
			message += " alert('글이 수정되었습니다.');";
			message += " location.href='"+request.getContextPath()+"/board/viewArticle.do?articleNO="+articleNO+"';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			message = "<script>";
			message += " alert('오류가 발생했습니다!!!');";
			message += " location.href='"+request.getContextPath()+"/board/viewArticle.do?articleNO="+articleNO+"';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	
	@RequestMapping(value="board/deleteArticle.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity deleteArticle(@RequestParam("articleNO") int articleNO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int result = boardService.deleteArticle(articleNO);	
			message = "<script>";
			message += " alert('글이 삭제되었습니다.');";
			message += " location.href='"+request.getContextPath()+"/board/boardList.do';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			message = "<script>";
			message += " alert('오류가 발생했습니다!!!');";
			message += " location.href='"+request.getContextPath()+"/board/boardList.do';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	
	@RequestMapping(value="board/addComment.do", method=RequestMethod.POST)
	@ResponseBody
	public String ajax_addComment(@ModelAttribute("commentVO") CommentVO commentVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
//		System.out.println(commentVO);
		request.setCharacterEncoding("utf-8");
		try {
			int result = boardService.addComment(commentVO);			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
//	@RequestMapping(value="board/commentList.do", method= {RequestMethod.GET, RequestMethod.POST})
//	@ResponseBody
//	public ResponseEntity ajax_commentList(@RequestParam("boId") int boId, HttpServletRequest request, HttpServletResponse response) throws Exception{
//		HttpHeaders responseHeaders = new HttpHeaders();
//		ArrayList<HashMap> hmlist = new ArrayList<HashMap>();
//		List<CommentVO> commentVO = boardService.commentList(boId);
//		if(commentVO.size()>0) {
//			for(int i=0; i<commentVO.size(); i++) {
//				HashMap hm = new HashMap();
//				hm.put("content", commentVO.get(i).getContent());
//				hm.put("writer", commentVO.get(i).getWriter());
//				
//				hmlist.add(hm);
//			}
//		}
//		System.out.println("hmlist: "+hmlist);
//		JSONArray json = new JSONArray();
//		json.add(hmlist);
//		System.out.println("json: "+json.toString());
//		return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);
//	}
	
	@RequestMapping(value="board/commentList.do", method= {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody ArrayList<HashMap> ajax_commentList(@RequestParam("boId") int boId, HttpServletRequest request, HttpServletResponse response) throws Exception{
		 HttpHeaders responseHeaders = new HttpHeaders();
	        ArrayList<HashMap> hmlist = new ArrayList<HashMap>();
	        try {
	        	List<CommentVO> commentVO = boardService.commentList(boId);
	        	
	        	if(commentVO.size() > 0){
	        		for(int i=0; i<commentVO.size(); i++){
	        			HashMap hm = new HashMap();
	        			hm.put("coId", commentVO.get(i).getCoId());
	        			hm.put("content", commentVO.get(i).getContent());
	        			hm.put("writer", commentVO.get(i).getWriter());
	        			
	        			hmlist.add(hm);
	        		}
	        		
	        	}
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }
	        System.out.println(hmlist);
	        return hmlist;
	}
	
}
