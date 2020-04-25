package org.woo.apt.member.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.woo.apt.member.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject
	SqlSession session;
	
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return session.selectOne("member.login",vo);
	}

	@Override
	public Integer checkId(MemberVO vo) throws Exception {
		return session.selectOne("member.checkId",vo);
	}

	@Override
	public void signUp(MemberVO vo) throws Exception {
		session.insert("member.signUp",vo);
		
	}

}
