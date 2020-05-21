package org.woo.apt.notice.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.woo.apt.member.domain.MemberVO;
import org.woo.apt.notice.domain.NoticeVO;
import org.woo.apt.notice.service.NoticeService;
import org.woo.apt.util.Paging;

@Controller     
@RequestMapping("/notice/*")  
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Inject
	private NoticeService service;
	
	@RequestMapping(value = "/insertPage", method = RequestMethod.GET)
	public void insertPage() throws Exception {
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,Model model, NoticeVO vo) throws Exception {
		HttpSession session= request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		vo.setWriter(memberVO.getUserid());
		service.insert(vo);
		return "redirect:/notice/listPage?page=1";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void readPage(Model model, @RequestParam("nno") int nno) throws Exception {
		
		model.addAttribute("vo", service.read(nno));
	}
	
	@RequestMapping(value = "/updatePage", method = RequestMethod.GET)
	public void updatePage(Model model, @RequestParam("nno") int nno) throws Exception {
		model.addAttribute("vo", service.read(nno));
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(int page,int nno,Model model, NoticeVO vo) throws Exception {
		service.update(vo);
		return "redirect:/notice/read?page="+page+"&nno=" + nno;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(Model model, int nno) throws Exception {
		service.delete(nno);
		return "redirect:/notice/listPage?page=1";

	}

	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(Model model,int page,Paging paging) throws Exception {                                                                                                     
		model.addAttribute("list",service.list(paging));
		model.addAttribute("Paging", new Paging(page, service.listCount()));
	}

	
	
	
}
