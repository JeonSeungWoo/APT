package org.woo.apt.advice.controller;

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
import org.woo.apt.advice.domain.AdviceVO;
import org.woo.apt.advice.service.AdviceService;
import org.woo.apt.member.domain.MemberVO;
import org.woo.apt.util.Paging;

@Controller     
@RequestMapping("/advice/*")  
public class AdviceController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdviceController.class);
	
	@Inject
	private AdviceService service;
	
	@RequestMapping(value = "/insertPage", method = RequestMethod.GET)
	public void insertPage() throws Exception {
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,Model model, AdviceVO vo) throws Exception {
		HttpSession session= request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		vo.setWriter(memberVO.getUserid());
		service.insert(vo);
		return "redirect:/advice/listPage?page=1";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void readPage(Model model, @RequestParam("lno") int lno) throws Exception {
		
		model.addAttribute("vo", service.read(lno));
	}
	
	@RequestMapping(value = "/updatePage", method = RequestMethod.GET)
	public void updatePage(Model model, @RequestParam("lno") int lno) throws Exception {
		model.addAttribute("vo", service.read(lno));
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(int page,int lno,Model model, AdviceVO vo) throws Exception {
		service.update(vo);
		return "redirect:/advice/read?page="+page+"&lno=" + lno;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(Model model, int lno) throws Exception {
		service.delete(lno);
		return "redirect:/advice/listPage?page=1";

	}

	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(Model model,int page,Paging paging) throws Exception {
		                                                                                                                                                        
		model.addAttribute("list",service.list(paging));
		model.addAttribute("Paging", new Paging(page, service.listCount()));
	}

	
	@RequestMapping(value = "/answerUpdate", method = RequestMethod.POST)
	public String answerUpdate(int page,int lno,Model model, AdviceVO vo) throws Exception {
		service.answerUpdate(vo);
		return "redirect:/advice/read?page="+page+"&lno=" + lno;
	}
	
	
	
}
