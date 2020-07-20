package it.spring.animale.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.spring.animale.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{
	Optional<Customer> findByEmail(String email);
	List<Customer> findBySessoAndEta(String sesso, int eta);
}
