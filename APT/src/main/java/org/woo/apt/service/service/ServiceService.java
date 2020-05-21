package org.woo.apt.service.service;

import java.util.List;

import org.woo.apt.service.domain.ServiceVO;
import org.woo.apt.util.Paging;

public interface ServiceService {
	public void insert(ServiceVO vo) throws Exception;
	public ServiceVO read(int sno) throws Exception;
	public void update(ServiceVO vo) throws Exception;
	public void delete(int sno) throws Exception;
	public List<ServiceVO>list(Paging paging)throws Exception;
	public int listCount()throws Exception;
	public void answerUpdate(ServiceVO vo) throws Exception;
}
