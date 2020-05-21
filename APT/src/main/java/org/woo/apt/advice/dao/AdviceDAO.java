package org.woo.apt.advice.dao;

import java.util.List;

import org.woo.apt.advice.domain.AdviceVO;
import org.woo.apt.util.Paging;

public interface AdviceDAO {
	public void insert(AdviceVO vo) throws Exception;
	public AdviceVO read(int lno) throws Exception;
	public void update(AdviceVO vo) throws Exception;
	public void delete(int lno) throws Exception;
	public List<AdviceVO>list(Paging paging)throws Exception;
	public int listCount()throws Exception;
}
