package br.com.fiap.wastefood.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.wastefood.model.CollectPoint;
import br.com.fiap.wastefood.repository.CollectPointRepository;
import br.com.fiap.wastefood.service.DoNotWasteService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	public DoNotWasteService service;

	@Autowired
	private CollectPointRepository repository;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("home");
		List<CollectPoint> points = repository.findAll();
		modelAndView.addObject("home", points);
		System.out.println(points);
		return modelAndView;
	}

	@PostMapping
	public String save(@Valid CollectPoint point, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors())
			return "wastefood";
		service.save(point, redirect);
		return "redirect:/";
	}

	@RequestMapping("new")
	public String create(CollectPoint point) {
		return "wastefood";
	}

}
