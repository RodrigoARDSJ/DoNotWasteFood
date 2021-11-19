package br.com.fiap.donotestaefood.controller.api;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.donotestaefood.model.PontoDeColeta;
import br.com.fiap.donotestaefood.repository.PontoDeColetaRepository;

@RestController
@RequestMapping("/api/wastefood")
public class PontoDeColetaApiController {

	@Autowired
	private PontoDeColetaRepository repository;

	/*
	 * @GetMapping()
	 * 
	 * @org.springframework.cache.annotation.Cacheable("collectPoint") public
	 * Page<PontoDeColeta> index(@RequestParam(required = false) String title,
	 * 
	 * @PageableDefault(size = 20) Pageable pageable) {
	 * 
	 * if (title == null) return repository.findAll(pageable); // TODO usar contains
	 * return repository.findByTitleLike("%" + title + "%", pageable); }
	 */
	@PostMapping()
	@CacheEvict(value = "collectPoint", allEntries = true)
	public ResponseEntity<PontoDeColeta> create(@RequestBody @Valid PontoDeColeta ponto, UriComponentsBuilder uriBuilder) {
		repository.save(ponto);
		URI uri = uriBuilder.path("/api/wastefood/{id}").buildAndExpand(ponto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping("{id}")
	public ResponseEntity<PontoDeColeta> get(@PathVariable Long id) {
		return ResponseEntity.of(repository.findById(id));
	}

	@DeleteMapping("{id}")
	@CacheEvict(value = "collectPoint", allEntries = true)
	public ResponseEntity<PontoDeColeta> delete(@PathVariable Long id) {
		Optional<PontoDeColeta> task = repository.findById(id);

		if (task.isEmpty())
			return ResponseEntity.notFound().build();

		repository.deleteById(id);

		return ResponseEntity.ok().build();

	}

	@PutMapping("{id}")
	@CacheEvict(value = "collectPoint", allEntries = true)
	public ResponseEntity<PontoDeColeta> update(@RequestBody @Valid PontoDeColeta newPonto, @PathVariable Long id) {
		Optional<PontoDeColeta> optional = repository.findById(id);

		if (optional.isEmpty())
			return ResponseEntity.notFound().build();

		PontoDeColeta ponto = optional.get();

		ponto.setTipoDeAlimento(newPonto.getTipoDeAlimento());
		ponto.setDataDeEntrega(newPonto.getDataDeEntrega());
		ponto.setEstoqueDeAlimento(newPonto.getEstoqueDeAlimento());

		repository.save(ponto);

		return ResponseEntity.ok(ponto);
	}

}
