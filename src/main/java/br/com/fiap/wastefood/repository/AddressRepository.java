package br.com.fiap.wastefood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.wastefood.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
