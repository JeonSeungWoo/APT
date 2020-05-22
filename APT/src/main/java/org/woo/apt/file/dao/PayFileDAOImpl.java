package org.woo.apt.file.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.woo.apt.file.domain.PayFileVO;
import org.woo.apt.file.domain.PaymentVO;
import org.woo.apt.util.Paging;

@Repository
public class PayFileDAOImpl implements PayFileDAO{

	@Inject
	private SqlSession session;
	
	private String name = "payFile.";	
	
	@Override
	public void insert(PayFileVO vo) throws Exception {
		session.insert(name+"insert",vo);

	}

	@Override
	public PayFileVO read(int pfno) throws Exception {
		return session.selectOne(name+"read",pfno);
	}

	@Override
	public void update(PayFileVO vo) throws Exception {
		session.update(name+"update",vo);
	}

	@Override
	public void delete(int pfno) throws Exception {
		session.delete(name+"delete",pfno);
	}

	@Override
	public List<PayFileVO> list(Paging paging) throws Exception {
		return session.selectList(name + "list",paging);
	}

	@Override
	public int listCount() throws Exception {
		return session.selectOne(name+"listCount");
	}

	@Override
	public List<PayFileVO> homeList() throws Exception {
		return session.selectList(name + "homeList");
	}

	@Override
	public void paymentInsert(PaymentVO vo) throws Exception {
		session.insert(name+"paymentInsert",vo);
	}

}
