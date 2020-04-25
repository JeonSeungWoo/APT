package org.woo.apt.file.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.woo.apt.file.dao.PayFileFilesDAO;
import org.woo.apt.file.domain.PayFileFilesVO;

@Service
public class PayFileFilesServiceImpl implements PayFileFilesService{

	@Inject
	private PayFileFilesDAO dao;
	
	@Override
	public void fileInsert(PayFileFilesVO vo) throws Exception {
		dao.fileInsert(vo);
		
	}

	@Override
	public List<PayFileFilesVO> fileList(int pfno) throws Exception {
		return dao.fileList(pfno);
	}

	@Override
	public void fileDelete(int pfno) throws Exception {
		dao.fileDelete(pfno);
	}

	@Override
	public void fileInsertOne(PayFileFilesVO vo) throws Exception {
		dao.fileInsertOne(vo);
	}

	@Override
	public void fileDeleteOne(PayFileFilesVO vo) throws Exception {
		dao.fileDeleteOne(vo);
	}

	@Override
	public PayFileFilesVO fileShow(PayFileFilesVO vo) throws Exception {
		return dao.fileShow(vo);
	}

}
