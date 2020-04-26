package org.woo.apt.file.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.woo.apt.file.dao.FreeFileFilesDAO;
import org.woo.apt.file.domain.FreeFileFilesVO;

@Service
public class FreeFileFilesServiceImpl implements FreeFileFilesService{

	@Inject
	private FreeFileFilesDAO dao;

	@Override
	public void fileInsert(FreeFileFilesVO vo) throws Exception {
		dao.fileInsert(vo);
		
	}

	@Override
	public List<FreeFileFilesVO> fileList(int ffno) throws Exception {
		return dao.fileList(ffno);
	}

	@Override
	public void fileDelete(int ffno) throws Exception {
		dao.fileDelete(ffno);
	}

	@Override
	public void fileInsertOne(FreeFileFilesVO vo) throws Exception {
		dao.fileInsertOne(vo);
	}

	@Override
	public void fileDeleteOne(FreeFileFilesVO vo) throws Exception {
		dao.fileDeleteOne(vo);
	}

	@Override
	public FreeFileFilesVO fileShow(FreeFileFilesVO vo) throws Exception {
		return dao.fileShow(vo);
	}
	

}
