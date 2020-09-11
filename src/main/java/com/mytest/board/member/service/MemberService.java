package com.mytest.board.member.service;

import org.springframework.dao.DataAccessException;

import com.mytest.board.member.vo.MemberVO;

public interface MemberService {
	
	public int addMember(MemberVO memberVO) throws DataAccessException;
	public MemberVO login(MemberVO memberVO) throws Exception;
	public int modMember(MemberVO memberVO) throws DataAccessException;
	public int deleteMember(String id) throws DataAccessException;
	public MemberVO selectOneMember(String id) throws DataAccessException;
	
}
