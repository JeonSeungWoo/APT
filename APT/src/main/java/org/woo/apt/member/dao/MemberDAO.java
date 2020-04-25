package org.woo.apt.member.dao;

import org.woo.apt.member.domain.MemberVO;

public interface MemberDAO {

	public MemberVO login(MemberVO vo)throws Exception;
	public Integer checkId(MemberVO vo) throws Exception;
	public void signUp(MemberVO vo) throws Exception;
}
