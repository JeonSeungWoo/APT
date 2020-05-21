package org.woo.apt.notice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.woo.apt.notice.dao.NoticeDAO;
import org.woo.apt.notice.domain.NoticeVO;
import org.woo.apt.util.Paging;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Inject
	private NoticeDAO dao;

	@Override
	public void insert(NoticeVO vo) throws Exception {
		dao.insert(vo);
		
	}

	@Override
	public NoticeVO read(int nno) throws Exception {
		
		return dao.read(nno);
	}

	@Override
	public void update(NoticeVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void delete(int nno) throws Exception {
		dao.delete(nno);
		
	}

	@Override
	public List<NoticeVO> list(Paging paging) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(paging);
	}

	@Override
	public int listCount() throws Exception {
		// TODO Auto-generated method stub
		return dao.listCount();
	}

	
}
