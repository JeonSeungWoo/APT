package org.woo.apt.advice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.woo.apt.advice.dao.AdviceDAO;
import org.woo.apt.advice.domain.AdviceVO;
import org.woo.apt.util.Paging;

@Service
public class AdviceServiceImpl implements AdviceService{

	@Inject
	private AdviceDAO dao;

	@Override
	public void insert(AdviceVO vo) throws Exception {
		dao.insert(vo);
		
	}

	@Override
	public AdviceVO read(int lno) throws Exception {
		
		return dao.read(lno);
	}

	@Override
	public void update(AdviceVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void delete(int lno) throws Exception {
		dao.delete(lno);
		
	}

	@Override
	public List<AdviceVO> list(Paging paging) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(paging);
	}

	@Override
	public int listCount() throws Exception {
		// TODO Auto-generated method stub
		return dao.listCount();
	}

	@Override
	public void answerUpdate(AdviceVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.answerUpdate(vo);
	}

	@Override
	public List<AdviceVO> homeList() throws Exception {
		// TODO Auto-generated method stub
		return dao.homeList();
	}
	
	
}
