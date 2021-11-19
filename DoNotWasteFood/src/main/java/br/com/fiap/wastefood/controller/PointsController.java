package br.com.fiap.wastefood.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.wastefood.model.CollectPoint;
import br.com.fiap.wastefood.service.DoNotWasteService;

@Controller
@RequestMapping("/wastefood")
public class PointsController {
	
	
	@Autowired
	public DoNotWasteService service;
	
	
	@PostMapping
	public String save(@Valid CollectPoint point , BindingResult result, RedirectAttributes redirect) {
			service.save(point, redirect);
		return "redirect:/home";
	}
	

	@RequestMapping("new")
	public String create(CollectPoint point) { 
		return "wastefood";
	}

}
