package org.woo.apt.file.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.woo.apt.file.domain.PayFileVO;
import org.woo.apt.util.Paging;

public interface PayFileService {
	public void insert(PayFileVO vo,List<MultipartFile>file) throws Exception;
	public PayFileVO read(int pfno) throws Exception;
	public void update(PayFileVO vo) throws Exception;
	public void delete(int pfno) throws Exception;
	public List<PayFileVO>list(Paging paging)throws Exception;
	public int listCount()throws Exception;
}
