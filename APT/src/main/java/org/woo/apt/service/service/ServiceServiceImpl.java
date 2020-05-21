package org.woo.apt.service.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.woo.apt.service.dao.ServiceDAO;
import org.woo.apt.service.domain.ServiceVO;
import org.woo.apt.util.Paging;

@Service
public class ServiceServiceImpl implements ServiceService{

	@Inject
	private ServiceDAO dao;

	@Override
	public void insert(ServiceVO vo) throws Exception {
		dao.insert(vo);
		
	}

	@Override
	public ServiceVO read(int sno) throws Exception {
		
		return dao.read(sno);
	}

	@Override
	public void update(ServiceVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void delete(int sno) throws Exception {
		dao.delete(sno);
		
	}

	@Override
	public List<ServiceVO> list(Paging paging) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(paging);
	}

	@Override
	public int listCount() throws Exception {
		// TODO Auto-generated method stub
		return dao.listCount();
	}

	@Override
	public void answerUpdate(ServiceVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.answerUpdate(vo);
	}
	
	
}
