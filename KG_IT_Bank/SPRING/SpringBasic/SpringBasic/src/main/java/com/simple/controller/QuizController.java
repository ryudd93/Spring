package com.simple.controller;

import java.io.Writer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;
import com.simple.command.Quiz02VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	@RequestMapping({"/quiz01", "/quiz02", "/quiz03"})
	public void views() {
		
	}
	

//	
//	@RequestMapping("/quiz01")
//	public void quiz01() {
//		
//	}
	
	@RequestMapping("/sendBirth")
	public String sendBirth(@ModelAttribute ("year") String year,
							@ModelAttribute ("month") String month,
							@ModelAttribute ("day") String day) {
		
		System.out.println(year + month + day);
		
		return "quiz/quiz01_ok";
	}
	
	
//	@RequestMapping("/quiz02")
//	public void quiz02() {
//		
//	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute ("form") Quiz02VO vo) {
		
		return "quiz/quiz02_ok";
	}
	
	
//	@RequestMapping("/quiz03")
//	public void quiz03() {
//		
//	}
	
//	@RequestMapping(value="/join2", method=RequestMethod.POST)
//	public String join2 (@ModelAttribute ("id") String id,
//						@ModelAttribute ("pw") String pw,
//						@ModelAttribute ("pw_check") String pwCheck,
//						RedirectAttributes RA) {
//		
//		if (id.equals("")) {
//			RA.addFlashAttribute("msg", "아이디를 입력하세요");
//			return "redirect:/quiz/quiz03";
//		} else if (!pw.equals(pwCheck)) {
//			RA.addFlashAttribute("msg", "비밀번호를 확인하세요");
//			return "redirect:/quiz/quiz03";
//		} else {
//			return "quiz/quiz03_ok";
//		}
//	}
		
		
	
	@RequestMapping(value="/join2", method=RequestMethod.POST)
	public String join2(@RequestParam (value="id", required=false, defaultValue="") String id,
						@RequestParam (value="pw") String pw,
						@RequestParam (value="pw_check") String pw_check,
						RedirectAttributes RA) {
		if (id.equals("")) {
			RA.addFlashAttribute("msg", "아이디를 입력하세요");
			return "redirect:/quiz/quiz03";
		} else if (!pw.equals(pw_check)) {
			RA.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
		} else {
			return "quiz/quiz03_ok";
		}
	}
		
	
}
