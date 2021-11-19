package br.com.fiap.donotestaefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.donotestaefood.model.PontoDeColeta;
import br.com.fiap.donotestaefood.repository.PontoDeColetaRepository;

@Service
public class PontoDeColetaService {

	@Autowired
	private PontoDeColetaRepository repository;
	
	@Autowired
	private MessageSource message;

	public void save(PontoDeColeta ponto, RedirectAttributes redirect) {
		repository.save(ponto);
		redirect.addFlashAttribute("message",
				message.getMessage("Salvo", null, LocaleContextHolder.getLocale()));
	}

}
