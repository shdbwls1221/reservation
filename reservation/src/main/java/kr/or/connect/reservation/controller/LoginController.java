package kr.or.connect.reservation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.connect.reservation.dto.User;

@Controller
@RequestMapping(value="/login")
public class LoginController {

	@RequestMapping(value="/index.do")
	public String loginPage() {
		
		return "loginpage";
	}
	@RequestMapping(value="/action.do")
	public ModelAndView actionLogin(User loginform ,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		// id와 password가 일치하는 member조회
		
		// 세션에 로그인 정보 등록
		loginform.setName("유진");
		request.getSession().setAttribute("user",loginform);
		
		mav.setViewName("forward:/main/index.do");
		return mav;
	}
}
