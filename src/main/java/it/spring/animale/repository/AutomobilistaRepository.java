package it.spring.animale.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.spring.animale.model.Automobilista;

@Repository
public interface AutomobilistaRepository extends JpaRepository<Automobilista, Long> 
{
	Optional<Automobilista> findById(Long id);
	
	Automobilista findFirstByOrderByIdDesc();
	
}
