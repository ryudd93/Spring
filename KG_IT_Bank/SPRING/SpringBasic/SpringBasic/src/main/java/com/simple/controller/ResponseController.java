package com.simple.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/response")
public class ResponseController {

	// 화면처리
	@RequestMapping("/res_ex01")
	public String res_ex01() {
		
		return "response/res_ex01";
	}
	
	
	//model전달자 - 메서드 매개변수로 Model or ModelMap 선언
	@RequestMapping("/res_ex02")
	public String res_ex02(Model model) {
		model.addAttribute("serverTime", new Date());	//serverTime이름으로 날짜를 저장
		model.addAttribute("name", "홍길동");	
		model.addAttribute("addr", "서울시");	
		
		return "response/res_ex02";
	}
	
	
	//ModelAndView객체 - Model에 대한 정보와, 화면에 대한 정보를 한번에 저장
	@RequestMapping("/res_ex03")
	public ModelAndView res_ex03() {
		ModelAndView mv = new ModelAndView();
		
		// 데이터 저장
		mv.addObject("serverTime", new Date());
		mv.addObject("name", "이순신");
		
		//화면정보 저장
		mv.setViewName("response/res_ex03");
		
		return mv;
	}
	
	
	//@ModelAttribute() - request와 Model이 합쳐진 형태
	@RequestMapping("/res_ex04")
	public String res_ex04(@ModelAttribute("num") String num,
							@ModelAttribute("name") String name) {
		
		System.out.println("넘어온 값 : " + num);
		System.out.println("넘어온 이름 : " + name);
		
		return "response/res_ex04";
	}
	
	
	@RequestMapping("/res_ex05")
	public String res_ex05(@ModelAttribute("info") ReqVO vo) {
		
		System.out.println(vo.getId());
		System.out.println(vo.getName());
		
		return "response/res_ex05";
	}
	
	
	//=================리다이렉트와 리다이렉트 어트리뷰트===============
	
	//화면처리
	@RequestMapping("/res_redirect")
	public String res_redirect() {
		
		
		return "response/res_redirect";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("id") String id,
						@RequestParam("pw") String pw,
						RedirectAttributes RA) {
		
		if (id.contentEquals(pw)) {	//로그인 성공(성공페이지)
			return "response/res_redirect_ok";
		} else {
			
			// "redirect:/절대경로" - 다시 컨트롤러를 타게함
			//	이때 화면에 1회성 데이터로 값을 전달하고 싶으면
			//	RedirectAttributes 객체를 사용하면 됨 (리다이렉트 시에 모델을 전달할 수 있음)
			RA.addFlashAttribute("msg", "아이디, 비밀번호를 확인하세요");
			return "redirect:/response/res_redirect";
		}
		
	}
	
	
	//	=============quiz============
	@RequestMapping("/res_quiz01")
	public void res_quiz01() {
		
	}
	
//	@RequestMapping(value="/res_login", method=RequestMethod.POST)
//	public String res_login(@RequestParam ("id") String id,
//							@RequestParam("pw") String pw,
//							RedirectAttributes RA) {
//		
//		if (id.equals("kim12") && pw.equals("1234")) {
//			return "response/res_quiz02";
//		} else {
//			return "response/res_quiz03";
//		}
//	}
	
	@RequestMapping(value="/res_login", method=RequestMethod.POST)
	public String res_login(@ModelAttribute("id") String id,
							@ModelAttribute("pw") String pw) {
		
		if (id.equals("kim12") && pw.equals("1234")) {
			return "response/res_quiz02";
		} else {
			return "response/res_quiz03";
		}
	}
	
	
	
	
	
}
