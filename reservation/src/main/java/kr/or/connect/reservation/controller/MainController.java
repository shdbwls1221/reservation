package kr.or.connect.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/main")
public class MainController {
	
	@RequestMapping(value="/index.do")
	public String mainpage() {
		// 로그인 세션 정보(id)에 맞는 식당 리스트, 음식 리스트 조회
		return "mainpage";
	}
}
