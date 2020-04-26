package org.woo.apt.file.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.woo.apt.file.domain.FreeFileVO;
import org.woo.apt.util.Paging;

public interface FreeFileService {
	public void insert(FreeFileVO vo,List<MultipartFile>file) throws Exception;
	public FreeFileVO read(int ffno) throws Exception;
	public void update(FreeFileVO vo) throws Exception;
	public void delete(int ffno) throws Exception;
	public List<FreeFileVO>list(Paging paging)throws Exception;
	public int listCount()throws Exception;
}
