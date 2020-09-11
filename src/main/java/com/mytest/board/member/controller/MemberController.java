package com.mytest.board.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mytest.board.member.vo.MemberVO;

public interface MemberController {
	
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member, @RequestParam("id") String id, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity login(@ModelAttribute("member") MemberVO member, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity modMember(@ModelAttribute("member") MemberVO member, @RequestParam("id") String id, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView deleteMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
