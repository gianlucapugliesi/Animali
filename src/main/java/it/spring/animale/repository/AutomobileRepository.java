package it.spring.animale.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.spring.animale.model.Automobile;

@Repository
public interface AutomobileRepository extends JpaRepository<Automobile, String> 
{
	Optional<Automobile> findByTarga(String targa);
	List<Automobile> findByMarca(String marca);
}
