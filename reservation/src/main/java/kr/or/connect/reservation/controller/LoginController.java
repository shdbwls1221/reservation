package kr.or.connect.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/login")
public class LoginController {

	@RequestMapping(value="/page")
	public String loginPage() {
		
		return "loginMain";
	}
	
}
