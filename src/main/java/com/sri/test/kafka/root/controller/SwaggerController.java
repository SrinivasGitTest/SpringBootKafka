package com.sri.test.kafka.root.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class SwaggerController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public RedirectView redirectSwagger() {
		return new RedirectView("/swagger-ui/");
	}
	
}
