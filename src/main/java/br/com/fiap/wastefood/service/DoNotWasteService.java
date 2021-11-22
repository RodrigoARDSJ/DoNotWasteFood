package br.com.fiap.wastefood.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.wastefood.exception.CollectNotFoundException;
import br.com.fiap.wastefood.model.CollectPoint;
import br.com.fiap.wastefood.repository.CollectPointRepository;

@Service
public class DoNotWasteService {

	@Autowired
	private CollectPointRepository repository;
	
	public CollectPoint get(Long id) {
		Optional<CollectPoint> optional = repository.findById(id);
		if (optional.isEmpty())
			throw new CollectNotFoundException("Ponto não encontrada");

		return optional.get();
	}

	
	public void save(CollectPoint point) {
		repository.save(point);

	}



	
}
