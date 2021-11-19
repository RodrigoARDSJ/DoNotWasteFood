package br.com.fiap.donotestaefood.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.donotestaefood.model.PontoDeColeta;
import br.com.fiap.donotestaefood.repository.PontoDeColetaRepository;
import br.com.fiap.donotestaefood.service.PontoDeColetaService;

@Controller
@RequestMapping("/coleta")
public class PontoDeColetaController {
	
	@Autowired
	public PontoDeColetaService service;
	
	public PontoDeColetaRepository repository;
	
	@PostMapping
	public String save(@Valid PontoDeColeta ponto, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors())
			return "pontoColetaForm";
			service.save(ponto, redirect);
		return "redirect:/coleta";
	}
	

	@RequestMapping("new")
	public String create(PontoDeColeta ponto) { 
		return "pontoColetaForm";
	}

}
