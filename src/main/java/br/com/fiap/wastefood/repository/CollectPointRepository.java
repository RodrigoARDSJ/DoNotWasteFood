package br.com.fiap.wastefood.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.wastefood.model.CollectPoint;

public interface CollectPointRepository extends JpaRepository<CollectPoint, Long>{

	Page<CollectPoint> findBytipoDeAlimentoLike(String tipoDeAlimento, Pageable pageable);
	
//	long countByUserId(long id);
}
