package com.exercise.crm_ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyTag {
	@RequestMapping("myTag")
	public String myTag() {
		return "myTag";
	}
}
