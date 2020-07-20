package it.spring.animale.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.spring.animale.model.Proprietario;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> 
{
	Optional<Proprietario> findByEmail(String email);
	
	Proprietario findFirstByOrderByIdDesc();
}
