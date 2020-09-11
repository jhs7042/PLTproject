package com.mytest.board.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mytest.board.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSession sqlSession;
	
	public int addMember(MemberVO memberVO) throws DataAccessException{
		int result = sqlSession.insert("mapper.member.addMember", memberVO);
		return result;
	}
	
	public MemberVO login(MemberVO memberVO) throws DataAccessException{
		MemberVO vo = sqlSession.selectOne("mapper.member.login", memberVO);
		return vo;
	}
	
	public int updateMember(MemberVO memberVO) throws DataAccessException{
		int result = sqlSession.update("mapper.member.updateMember", memberVO);
		return result;
	}
	
	public int deleteMember(String id) throws DataAccessException{
		int result = sqlSession.delete("mapper.member.deleteMember", id);
		return result;
	}
	
	public MemberVO selectOneMember(String id) throws DataAccessException{
		MemberVO vo = sqlSession.selectOne("mapper.member.selectOneMember", id);
		return vo;
	}
	
}
