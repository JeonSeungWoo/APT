package org.woo.apt.file.dao;

import java.util.List;

import org.woo.apt.file.domain.FreeFileVO;
import org.woo.apt.util.Paging;

public interface FreeFileDAO {
		public void insert(FreeFileVO vo) throws Exception;
		public FreeFileVO read(int pfno) throws Exception;
		public void update(FreeFileVO vo) throws Exception;
		public void delete(int pfno) throws Exception;
		public List<FreeFileVO>list(Paging paging)throws Exception;
		public int listCount(Paging paging)throws Exception;
		public List<FreeFileVO>homeList()throws Exception;
}
