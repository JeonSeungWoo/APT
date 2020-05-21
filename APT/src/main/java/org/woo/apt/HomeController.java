package org.woo.apt;

import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woo.apt.advice.service.AdviceService;
import org.woo.apt.file.service.FreeFileService;
import org.woo.apt.file.service.PayFileService;
import org.woo.apt.notice.service.NoticeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private AdviceService adviceService;
	
	@Inject
	private FreeFileService freeService;
	
	@Inject
	private PayFileService payService;
	
	@Inject
	private NoticeService noticeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		model.addAttribute("adviceList",adviceService.homeList());
		model.addAttribute("freeList",freeService.homeList());
		model.addAttribute("payList",payService.homeList());
		model.addAttribute("noticeList",noticeService.homeList());
		return "home";
	}
	
	@RequestMapping(value = "/agreement", method = RequestMethod.GET)
	public String agreement(Locale locale, Model model) {
		return "agreement";
	}
	
}
