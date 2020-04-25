package org.woo.apt.member.controller;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woo.apt.member.domain.MemberVO;
import org.woo.apt.member.service.MemberService;

@RequestMapping("/member/*")
@Controller
public class MemberController {

	@Inject // byType으로 자동 주입
	private MemberService service;
	
	@Inject
	private BCryptPasswordEncoder passwordEncoder;


	// 로그인 폼을 띄우는 부분
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm() {
		return "/member/loginForm"; // /login/loginForm.jsp를 띄움.
	}// end of loginForm

	// 로그인 처리하는 부분
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String loginProcess(HttpSession session, MemberVO dto) throws Exception {
	
		String returnURL = "";
		if (session.getAttribute("login") != null) {
			// 기존에 login이란 세션 값이 존재한다면
			session.removeAttribute("login"); // 기존값을 제거해 준다.
		}

		//입력한 페스워드
		String inpw = dto.getPw();
		//입력한 페스워드 암호화
		String encryptPassword = passwordEncoder.encode(inpw);
		//암호화된 것을 저장.
		dto.setPw(encryptPassword);
		
		//로그인 정보를 가져옴.
		MemberVO vo = service.login(dto);
		System.out.println(vo);
		
		//nullCheck
		if(vo !=null) {
			// 등어온 pw 와 DB의 가 같으면
			if (passwordEncoder.matches(inpw, vo.getPw())) {
					session.setAttribute("login", vo);
					returnURL = "redirect:/";
			} else { 
				// 로그인에 실패한 경우
				    returnURL = "redirect:/member/loginForm";
			}

		}else{
			returnURL = "redirect:/member/loginForm";
		}
	
		return returnURL; // 위에서 설정한 returnURL 을 반환해서 이동시킴
	}
	

		
	
	@RequestMapping(value = "/checkId", method = RequestMethod.POST)
	public void checkId(HttpServletRequest req, HttpServletResponse res, Model model) throws Exception {
		PrintWriter out = res.getWriter();
		
		try {
			String parmid = (req.getParameter("userid") == null)? "" : String.valueOf(req.getParameter("userid"));
			
			MemberVO vo = new MemberVO();
  			vo.setUserid(parmid.trim());
  			Integer checkPoint = service.checkId(vo);
  			//입력값 체크 //out.print == 1이면 false  ,0 이면 true 
  			if (parmid == "") {
  				out.print("1");
			}else {
				out.print(checkPoint);
			}
  			
  			out.flush();
  			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			out.print("1");
			
		}

	}
	//회원가입FORM
	@RequestMapping(value = "/signUpForm", method = RequestMethod.GET)
	public String signUpForm() {
		return "/member/signUpForm"; // /login/loginForm.jsp를 띄움.
	}// end of loginForm
	
	//회원가입
	@RequestMapping(value = "/loginCreate", method = RequestMethod.POST)
	public String loginCreate(Model model, MemberVO vo) throws Exception {
		service.signUp(vo);
		return "redirect:/member/loginForm";
	}



	// 로그아웃 하는 부분
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 전체를 날려버림
		// session.removeAttribute("login"); // 하나씩 하려면 이렇게 해도 됨.
		return "redirect:/member/loginForm"; // 로그아웃 후 게시글 목록으로 이동하도록...함
	}
}