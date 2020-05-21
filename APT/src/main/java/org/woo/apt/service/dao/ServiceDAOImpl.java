package org.woo.apt.service.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.woo.apt.service.domain.ServiceVO;
import org.woo.apt.util.Paging;

@Repository
public class ServiceDAOImpl implements ServiceDAO{

	@Inject
	private SqlSession session;
	
	private String name = "service.";
	
	@Override
	public void insert(ServiceVO vo) throws Exception {
		session.insert(name+"insert",vo);
	}

	@Override
	public ServiceVO read(int sno) throws Exception {
		return session.selectOne(name+"read",sno);
	}

	@Override
	public void update(ServiceVO vo) throws Exception {
		session.update(name+"update",vo);
	}

	@Override
	public void delete(int sno) throws Exception {
		session.delete(name+"delete",sno);
	}

	@Override
	public List<ServiceVO> list(Paging paging) throws Exception {
		return session.selectList(name + "list",paging);
	}

	@Override
	public int listCount() throws Exception {
		return session.selectOne(name+"listCount");
	}

	@Override
	public void answerUpdate(ServiceVO vo) throws Exception {
		session.update(name+"answerUpdate",vo);
		
	}

}
