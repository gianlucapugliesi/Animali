package it.spring.animale.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import it.spring.animale.model.Customer;
import it.spring.animale.model.Product;

@Component
public interface CustomSpringDAO 
{
	public Customer findById(Long id);
	public Customer findByEmail(String email);
	public void addOrder(Long idCustomer, Long idProduct) throws Exception;
	public List<Product> listaProdotti(Long idCustomer) throws Exception;
	public void deleteCustomer(Long idCustomer) throws Exception;
	public List<Customer> findBySessoAndEta(String sesso, int eta);
}
