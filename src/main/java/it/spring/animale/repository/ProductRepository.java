package it.spring.animale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.spring.animale.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> 
{

}
