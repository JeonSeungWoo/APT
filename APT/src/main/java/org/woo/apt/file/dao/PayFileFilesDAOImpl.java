package org.woo.apt.file.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.woo.apt.file.domain.PayFileFilesVO;

@Repository
public class PayFileFilesDAOImpl implements PayFileFilesDAO{

	@Inject
	private SqlSession session;
	
	
	@Override
	public void fileInsert(PayFileFilesVO vo) throws Exception {
		session.insert("payFile.fileInsert",vo);
	}

	@Override
	public List<PayFileFilesVO> fileList(int pfno) throws Exception {
		
		return session.selectList("payFile.fileList",pfno);
	}

	@Override
	public void fileDelete(int pfno) throws Exception {
		session.delete("payFile.fileDelete",pfno);
		
	}

	@Override
	public void fileInsertOne(PayFileFilesVO vo) throws Exception {
		session.insert("payFile.fileInsertOne",vo);
	}

	@Override
	public void fileDeleteOne(PayFileFilesVO vo) throws Exception {
		session.delete("payFile.fileDeleteOne",vo);
		
	}

	@Override
	public PayFileFilesVO fileShow(PayFileFilesVO vo) throws Exception {
		// TODO Auto-generated method stub
		return  session.selectOne("payFile.fileShow",vo);
	}

}
