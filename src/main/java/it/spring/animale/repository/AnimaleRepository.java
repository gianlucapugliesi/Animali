package it.spring.animale.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.spring.animale.model.Animale;

public interface AnimaleRepository extends JpaRepository<Animale, String> 
{
	Optional<Animale> findById(String id);
	List<Animale> findByNomeScientifico(String nome);
//	List<Animale> findByIdProprietario(Long idProprietario);
	
	//linguaggio jpql si usa in spring
	@Query("select a from Animale a where a.proprietario.id = :idProprietario")
	List<Animale> cercaPerProprietario(@Param("idProprietario") Long idProprietario);
	
//	List<Animale> cercaPerProprietario(Long idProprietario);
}