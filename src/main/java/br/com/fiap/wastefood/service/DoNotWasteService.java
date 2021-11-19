package br.com.fiap.wastefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.wastefood.model.CollectPoint;
import br.com.fiap.wastefood.repository.CollectPointRepository;

@Service
public class DoNotWasteService {

	@Autowired
	private CollectPointRepository repository;

	@Autowired
	private MessageSource message;
	
	public void save(CollectPoint collect, RedirectAttributes redirect) {
		repository.save(collect);
		redirect.addFlashAttribute("message",
				message.getMessage("task.new.success", null, LocaleContextHolder.getLocale()));
	}



	
}
