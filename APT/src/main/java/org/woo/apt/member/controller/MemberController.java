package org.woo.apt.member.controller;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.woo.apt.member.domain.MemberVO;
import org.woo.apt.member.service.MemberService;
import org.woo.apt.util.KaKaoUtil;

import com.fasterxml.jackson.databind.JsonNode;

@RequestMapping("/member/*")
@Controller
public class MemberController {

	@Inject // byType�쑝濡� �옄�룞 二쇱엯
	private MemberService service;

	@Inject
	private BCryptPasswordEncoder passwordEncoder;

	// 濡쒓렇�씤 �뤌�쓣 �쓣�슦�뒗 遺�遺�
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm() {
		return "/member/loginForm"; // /login/loginForm.jsp瑜� �쓣��.
	}// end of loginForm

	// 濡쒓렇�씤 泥섎━�븯�뒗 遺�遺�
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String loginProcess(HttpSession session, MemberVO dto) throws Exception {

		String returnURL = "";
		if (session.getAttribute("login") != null) {
			// 湲곗〈�뿉 login�씠�� �꽭�뀡 媛믪씠 議댁옱�븳�떎硫�
			session.removeAttribute("login"); // 湲곗〈媛믪쓣 �젣嫄고빐 以��떎.
		}

		// �엯�젰�븳 �럹�뒪�썙�뱶
		String inpw = dto.getPw();
		// �엯�젰�븳 �럹�뒪�썙�뱶 �븫�샇�솕
		String encryptPassword = passwordEncoder.encode(inpw);
		// �븫�샇�솕�맂 寃껋쓣 ���옣.
		dto.setPw(encryptPassword);

		// 濡쒓렇�씤 �젙蹂대�� 媛��졇�샂.
		MemberVO vo = service.login(dto);
		// nullCheck
		if (vo != null) {
			// �벑�뼱�삩 pw �� DB�쓽 媛� 媛숈쑝硫�
			if (passwordEncoder.matches(inpw, vo.getPw())) {
				session.setAttribute("login", vo);
				returnURL = "redirect:/";
			} else {
				// 濡쒓렇�씤�뿉 �떎�뙣�븳 寃쎌슦
				returnURL = "redirect:/member/loginForm";
			}

		} else {
			returnURL = "redirect:/member/loginForm";
		}

		return returnURL; // �쐞�뿉�꽌 �꽕�젙�븳 returnURL �쓣 諛섑솚�빐�꽌 �씠�룞�떆�궡
	}

	@RequestMapping(value = "/checkId", method = RequestMethod.POST)
	public void checkId(HttpServletRequest req, HttpServletResponse res, Model model) throws Exception {
		PrintWriter out = res.getWriter();

		try {
			String parmid = (req.getParameter("userid") == null) ? "" : String.valueOf(req.getParameter("userid"));

			MemberVO vo = new MemberVO();
			vo.setUserid(parmid.trim());
			Integer checkPoint = service.checkId(vo);
			// �엯�젰媛� 泥댄겕 //out.print == 1�씠硫� false ,0 �씠硫� true
			if (parmid == "") {
				out.print("1");
			} else {
				out.print(checkPoint);
			}

			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
			out.print("1");

		}

	}

	// �쉶�썝媛��엯FORM
	@RequestMapping(value = "/signUpForm", method = RequestMethod.GET)
	public String signUpForm() {
		return "/member/signUpForm"; // /login/loginForm.jsp瑜� �쓣��.
	}// end of loginForm

	// �쉶�썝媛��엯
	@RequestMapping(value = "/loginCreate", method = RequestMethod.POST)
	public String loginCreate(Model model, MemberVO vo) throws Exception {
		
		service.signUp(vo);
		return "redirect:/member/loginForm";
	}

	// 濡쒓렇�븘�썐 �븯�뒗 遺�遺�
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // �꽭�뀡 �쟾泥대�� �궇�젮踰꾨┝
		// session.removeAttribute("login"); // �븯�굹�뵫 �븯�젮硫� �씠�젃寃� �빐�룄 �맖.
		return "redirect:/member/loginForm"; // 濡쒓렇�븘�썐 �썑 寃뚯떆湲� 紐⑸줉�쑝濡� �씠�룞�븯�룄濡�...�븿
	}

	
	
	// kakao
	@RequestMapping(value = "/kakaoLogin", produces = "application/json", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String kakaoLogin(HttpSession session, @RequestParam("code") String code, HttpServletRequest request,
			HttpServletResponse reponse) {
		
		JsonNode jsonToken = KaKaoUtil.getAccessToken(code);

		

		JsonNode userInfo = KaKaoUtil.getKakaoUserInfo(jsonToken.get("access_token"));

		return "redirect:/member/loginForm";
	}




}