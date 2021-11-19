package br.com.fiap.donotestaefood.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.donotestaefood.model.PontoDeColeta;

public interface PontoDeColetaRepository extends JpaRepository<PontoDeColeta, Long>{

//	Page<PontoDeColeta> findByTitleLike(String string, Pageable pageable);

}
