package org.woo.apt.service.controller;

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
import org.woo.apt.service.domain.ServiceVO;
import org.woo.apt.service.service.ServiceService;
import org.woo.apt.util.Paging;

@Controller     
@RequestMapping("/service/*")  
public class ServiceController {
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
	
	@Inject
	private ServiceService service;
	
	@RequestMapping(value = "/insertPage", method = RequestMethod.GET)
	public void insertPage() throws Exception {
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,Model model, ServiceVO vo) throws Exception {
		HttpSession session= request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		vo.setWriter(memberVO.getUserid());
		service.insert(vo);
		return "redirect:/service/listPage?page=1";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void readPage(Model model, @RequestParam("sno") int sno) throws Exception {
		
		model.addAttribute("vo", service.read(sno));
	}
	
	@RequestMapping(value = "/updatePage", method = RequestMethod.GET)
	public void updatePage(Model model, @RequestParam("sno") int sno) throws Exception {
		model.addAttribute("vo", service.read(sno));
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(int page,int sno,Model model, ServiceVO vo) throws Exception {
		service.update(vo);
		return "redirect:/service/read?page="+page+"&sno=" + sno;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(Model model, int sno) throws Exception {
		service.delete(sno);
		return "redirect:/service/listPage?page=1";

	}

	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(Model model,int page,Paging paging) throws Exception {                                                                                                     
		model.addAttribute("list",service.list(paging));
		model.addAttribute("Paging", new Paging(page, service.listCount()));
	}

	
	@RequestMapping(value = "/answerUpdate", method = RequestMethod.POST)
	public String answerUpdate(HttpServletRequest request,int page,int sno,Model model, ServiceVO vo) throws Exception {
		HttpSession session= request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		vo.setRespondent(memberVO.getUserid());
		service.answerUpdate(vo);
		return "redirect:/service/read?page="+page+"&sno=" + sno;
	}
	
	
	
}
