package org.woo.apt.file.controller;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.woo.apt.file.domain.PayFileFilesVO;
import org.woo.apt.file.domain.PayFileVO;
import org.woo.apt.file.service.PayFileFilesService;
import org.woo.apt.file.service.PayFileService;
import org.woo.apt.util.Paging;

@Controller     
@RequestMapping("/payFile/*")   
public class PayFileController {
	//logger.info사용 (sysout같은거다.{기본 컨트롤러에 이미 되어 있다.})
		private static final Logger logger = LoggerFactory.getLogger(PayFileController.class);
		//service 가져오기
		@Inject
		private PayFileService service;
		
		@Inject
		private PayFileFilesService fservice;
		
		
		//insertPage설정.(view.board.insertPage로 경로가 설정 되어 있다.)
		//web.xmp에서 확인 가능.
		@RequestMapping(value = "/insertPage", method = RequestMethod.GET)
		public void insertPage() throws Exception {
		}
		
		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public String insert(Model model, PayFileVO vo, @RequestParam("file")List<MultipartFile> file) throws Exception {
			service.insert(vo, file);
			return "redirect:/payFile/listPage?page=1";
		}
		
		//read기능 bno를 파라미터로 가져와야 한다.
		@RequestMapping(value = "/read", method = RequestMethod.GET)
		public void readPage(Model model, @RequestParam("pfno") int pfno) throws Exception {
			List<PayFileFilesVO> list = fservice.fileList(pfno);
			model.addAttribute("list", list);
			model.addAttribute("listSize", list.size());
			model.addAttribute("vo", service.read(pfno));
		}

		@RequestMapping(value = "/update", method = RequestMethod.POST)
		public String update(Model model, PayFileVO vo) throws Exception {
			logger.info("update Test ::   ");
			service.update(vo);
			return "redirect:/payFile/listPage?page=1";
		}
		
		@RequestMapping(value = "/delete", method = RequestMethod.POST)
		public String delete(Model model, int pfno) throws Exception {
			service.delete(pfno);
			return "redirect:/payFile/listPage?page=1";

		}

		@RequestMapping(value = "/listPage", method = RequestMethod.GET)
		public void listPage(Model model,int page,Paging paging) throws Exception {
			                                                                                                                                                        
			model.addAttribute("list",service.list(paging));
			model.addAttribute("Paging", new Paging(page, service.listCount()));
		}

		
}
