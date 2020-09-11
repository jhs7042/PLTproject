package com.mytest.board.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mytest.board.notice.vo.NoticePageVO;
import com.mytest.board.notice.vo.NoticeVO;

public interface NoticeController {
	public ModelAndView noticeList(NoticePageVO pageVO, @RequestParam(value="nowPage", required=false) String nowPage,
			@RequestParam(value="cntPerPage", required=false) String cntPerPage,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity writeNotice(@ModelAttribute("notice") NoticeVO notice, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewNotice(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity updateNotice(@ModelAttribute("notice") NoticeVO notice, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity deleteNotice(@RequestParam("no")int no, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
