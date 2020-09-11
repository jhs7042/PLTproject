package com.mytest.board.member.dao;

import org.springframework.dao.DataAccessException;

import com.mytest.board.member.vo.MemberVO;

public interface MemberDAO {

	public int addMember(MemberVO memberVO) throws DataAccessException;
	public MemberVO login(MemberVO memberVO) throws DataAccessException;
	public int updateMember(MemberVO memberVO) throws DataAccessException;
	public int deleteMember(String id) throws DataAccessException;
	public MemberVO selectOneMember(String id) throws DataAccessException;
	
}
