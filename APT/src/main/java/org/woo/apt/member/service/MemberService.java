package org.woo.apt.member.service;

import org.woo.apt.member.domain.MemberVO;

public interface MemberService {
	public MemberVO login(MemberVO vo)throws Exception;
	public Integer checkId(MemberVO vo) throws Exception;
	public void signUp(MemberVO vo) throws Exception;
}
