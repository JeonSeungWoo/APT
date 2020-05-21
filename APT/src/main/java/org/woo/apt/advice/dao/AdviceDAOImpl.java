package org.woo.apt.advice.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.woo.apt.advice.domain.AdviceVO;
import org.woo.apt.util.Paging;

@Repository
public class AdviceDAOImpl implements AdviceDAO{

	@Override
	public void insert(AdviceVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AdviceVO read(int lno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(AdviceVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int lno) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AdviceVO> list(Paging paging) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int listCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
