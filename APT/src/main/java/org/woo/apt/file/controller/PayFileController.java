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
	//logger.info�궗�슜 (sysout媛숈�嫄곕떎.{湲곕낯 而⑦듃濡ㅻ윭�뿉 �씠誘� �릺�뼱 �엳�떎.})
		private static final Logger logger = LoggerFactory.getLogger(PayFileController.class);
		//service 媛��졇�삤湲�
		@Inject
		private PayFileService service;
		
		@Inject
		private PayFileFilesService fservice;
		
		//insertPage�꽕�젙.(view.board.insertPage濡� 寃쎈줈媛� �꽕�젙 �릺�뼱 �엳�떎.)
		//web.xmp�뿉�꽌 �솗�씤 媛��뒫.
		@RequestMapping(value = "/insertPage", method = RequestMethod.GET)
		public void insertPage() throws Exception {
		}
		
		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public String insert(Model model, PayFileVO vo, @RequestParam("file")List<MultipartFile> file) throws Exception {
			service.insert(vo, file);
			return "redirect:/payFile/listPage?page=1";
		}
		
		//read湲곕뒫 bno瑜� �뙆�씪誘명꽣濡� 媛��졇���빞 �븳�떎.
		@RequestMapping(value = "/read", method = RequestMethod.GET)
		public void readPage(Model model, @RequestParam("pfno") int pfno) throws Exception {
			List<PayFileFilesVO> list = fservice.fileList(pfno);
			model.addAttribute("read", service.read(pfno));
			model.addAttribute("list", list);
			model.addAttribute("listSize", list.size());
			model.addAttribute("vo", service.read(pfno));
		}
		
		@RequestMapping(value = "/updatePage", method = RequestMethod.GET)
		public void updatePage(Model model, @RequestParam("pfno") int pfno) throws Exception {
			model.addAttribute("read", service.read(pfno));
			List<PayFileFilesVO> list = fservice.fileList(pfno);
			model.addAttribute("list", list);
			model.addAttribute("listSize", list.size());
			model.addAttribute("vo", service.read(pfno));
		}

		@RequestMapping(value = "/update", method = RequestMethod.POST)
		public String update(int page,int pfno,Model model, PayFileVO vo) throws Exception {
			service.update(vo);
			return "redirect:/payFile/read?page="+page+"&pfno=" + pfno;
		}
		
		@RequestMapping(value = "/delete", method = RequestMethod.POST)
		public String delete(Model model, int pfno) throws Exception {
			service.delete(pfno);
			return "redirect:/payFile/listPage?page=1";

		}

		@RequestMapping(value = "/listPage", method = RequestMethod.GET)
		public void listPage(Model model,int page,Paging paging) throws Exception {
			System.out.println(paging);                                                                                                                                                        
			model.addAttribute("list",service.list(paging));
			System.out.println(service.listCount(paging));         
			model.addAttribute("Paging", new Paging(page, service.listCount(paging)));
		}

		
}
