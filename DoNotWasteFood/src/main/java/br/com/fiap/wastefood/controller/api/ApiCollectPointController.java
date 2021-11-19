package br.com.fiap.wastefood.controller.api;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

import br.com.fiap.wastefood.model.CollectPoint;
import br.com.fiap.wastefood.repository.CollectPointRepository;

@RestController
@RequestMapping("/api/wastefood")
public class ApiCollectPointController {
	
	@Autowired
	private CollectPointRepository repository;
	
	@GetMapping()
	@Cacheable("collectPoint")
	public Page<CollectPoint> index(
			@RequestParam(required = false) String tipoDeAlimento,
			@PageableDefault(size = 20) Pageable pageable){
		
		if(tipoDeAlimento == null) 
			return repository.findAll(pageable);
		//TODO usar contains
		return repository.findBytipoDeAlimentoLike("%" + tipoDeAlimento + "%", pageable);
	}
	
	@PostMapping()
	@CacheEvict(value = "collectPoint", allEntries = true)
	public ResponseEntity<CollectPoint> create(@RequestBody @Valid CollectPoint point, UriComponentsBuilder uriBuilder) {
		repository.save(point);
		URI uri = uriBuilder
					.path("/api/wastefood/{id}")
					.buildAndExpand(point.getId())
					.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<CollectPoint>  get(@PathVariable Long id) {
		return ResponseEntity.of(repository.findById(id));
	}
	
	@DeleteMapping("{id}")
	@CacheEvict(value = "collectPoint", allEntries = true)
	public ResponseEntity<CollectPoint> delete(@PathVariable Long id){
		Optional<CollectPoint> point = repository.findById(id);
		
		if(point.isEmpty()) 
			return ResponseEntity.notFound().build() ;
		
		repository.deleteById(id);
		
		return ResponseEntity.ok().build();
		
	}
	
	@PutMapping("{id}")
	@CacheEvict(value = "collectPoint", allEntries = true)
	public ResponseEntity<CollectPoint> update(@RequestBody @Valid CollectPoint newPoint, @PathVariable Long id){
		Optional<CollectPoint> optional = repository.findById(id);
		
		if(optional.isEmpty()) 
			return ResponseEntity.notFound().build() ;
		
		CollectPoint collectPoint = optional.get();
		
		collectPoint.setTipoDeAlimento(newPoint.getTipoDeAlimento());
		collectPoint.setDataDeEntrega(newPoint.getDataDeEntrega());
		collectPoint.setEstoqueDeAlimento(newPoint.getEstoqueDeAlimento());
		
		repository.save(collectPoint);
		
		return ResponseEntity.ok(collectPoint);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
