package com.mytest.board.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mytest.board.member.service.MemberService;
import com.mytest.board.member.dao.MemberDAO;
import com.mytest.board.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;
	
	public int addMember(MemberVO memberVO) throws DataAccessException{
		return memberDAO.addMember(memberVO);
	}
	
	public MemberVO login(MemberVO memberVO) throws Exception{
		return memberDAO.login(memberVO);
	}
	
	public int modMember(MemberVO memberVO) throws DataAccessException{
		return memberDAO.updateMember(memberVO);
	}
	
	public int deleteMember(String id) throws DataAccessException{
		return memberDAO.deleteMember(id);
	}
	
	public MemberVO selectOneMember(String id) throws DataAccessException{
		return memberDAO.selectOneMember(id);
	}

}
