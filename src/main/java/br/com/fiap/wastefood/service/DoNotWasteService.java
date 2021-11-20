package br.com.fiap.wastefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.wastefood.model.CollectPoint;
import br.com.fiap.wastefood.repository.CollectPointRepository;

@Service
public class DoNotWasteService {

	@Autowired
	private CollectPointRepository repository;

	
	public void save(CollectPoint collect, RedirectAttributes redirect) {
		repository.save(collect);

	}



	
}
