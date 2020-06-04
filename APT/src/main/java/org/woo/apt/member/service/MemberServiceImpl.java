package org.woo.apt.member.service;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.woo.apt.member.dao.MemberDAO;
import org.woo.apt.member.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	private MemberDAO dao;
	
	@Inject
    private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		
		return dao.login(vo);
	}

	@Override
	public Integer checkId(MemberVO vo) throws Exception {
		return dao.checkId(vo);
	}

	@Override
	public void signUp(MemberVO vo) throws Exception {
		
		String encryptPassword = passwordEncoder.encode(vo.getPw());
		vo.setPw(encryptPassword);
		
		dao.signUp(vo);
	}

}
