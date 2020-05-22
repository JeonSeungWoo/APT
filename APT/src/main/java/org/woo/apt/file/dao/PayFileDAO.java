package org.woo.apt.file.dao;

import java.util.List;

import org.woo.apt.file.domain.PayFileVO;
import org.woo.apt.file.domain.PaymentVO;
import org.woo.apt.util.Paging;

public interface PayFileDAO {
		public void insert(PayFileVO vo) throws Exception;
		public PayFileVO read(int pfno) throws Exception;
		public void update(PayFileVO vo) throws Exception;
		public void delete(int pfno) throws Exception;
		public List<PayFileVO>list(Paging paging)throws Exception;
		public int listCount()throws Exception;
		public List<PayFileVO>homeList()throws Exception;
		public void paymentInsert(PaymentVO vo)throws Exception;
}
