package com.sakha.kiran.hostel.manage.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hostel/login")
public class LoginController {

	@RequestMapping(value = "/warden", method = RequestMethod.GET)
	public String warden(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Wellcome to warden");
		return "Wellcome to warden";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Wellcome to admin");
		return "Wellcome to admin";
	}

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String student(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Wellcome to student");
		return "Wellcome to student";
	}
}
