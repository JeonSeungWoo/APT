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
import org.woo.apt.file.domain.FreeFileFilesVO;
import org.woo.apt.file.domain.FreeFileVO;
import org.woo.apt.file.service.FreeFileFilesService;
import org.woo.apt.file.service.FreeFileService;
import org.woo.apt.util.Paging;

@Controller     
@RequestMapping("/freeFile/*")   
public class FreeFileController {

		private static final Logger logger = LoggerFactory.getLogger(FreeFileController.class);
		
		@Inject
		private FreeFileService service;
		
		@Inject
		private FreeFileFilesService fservice;
		
		
		@RequestMapping(value = "/insertPage", method = RequestMethod.GET)
		public void insertPage() throws Exception {
		}
		
		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public String insert(Model model, FreeFileVO vo, @RequestParam("file")List<MultipartFile> file) throws Exception {
			service.insert(vo, file);
			return "redirect:/freeFile/listPage?page=1";
		}
		
		@RequestMapping(value = "/read", method = RequestMethod.GET)
		public void readPage(Model model, @RequestParam("ffno") int ffno) throws Exception {
			List<FreeFileFilesVO> list = fservice.fileList(ffno);
			model.addAttribute("read", service.read(ffno));
			model.addAttribute("list", list);
			model.addAttribute("listSize", list.size());
			model.addAttribute("vo", service.read(ffno));
		}
		
		@RequestMapping(value = "/updatePage", method = RequestMethod.GET)
		public void updatePage(Model model, @RequestParam("ffno") int ffno) throws Exception {
			model.addAttribute("read", service.read(ffno));
			List<FreeFileFilesVO> list = fservice.fileList(ffno);
			model.addAttribute("list", list);
			model.addAttribute("listSize", list.size());
			model.addAttribute("vo", service.read(ffno));
		}

		@RequestMapping(value = "/update", method = RequestMethod.POST)
		public String update(Model model, FreeFileVO vo) throws Exception {
			service.update(vo);
			return "redirect:/freeFile/listPage?page=1";
		}
		
		@RequestMapping(value = "/delete", method = RequestMethod.POST)
		public String delete(Model model, int ffno) throws Exception {
			service.delete(ffno);
			return "redirect:/freeFile/listPage?page=1";

		}

		@RequestMapping(value = "/listPage", method = RequestMethod.GET)
		public void listPage(Model model,int page,Paging paging) throws Exception {
			                                                                                                                                                        
			model.addAttribute("list",service.list(paging));
			model.addAttribute("Paging", new Paging(page, service.listCount()));
		}

		
}
