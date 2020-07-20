package it.spring.animale.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.spring.animale.model.Customer;
import it.spring.animale.model.Product;
import it.spring.animale.repository.CustomerRepository;
import it.spring.animale.repository.ProductRepository;

@Component
public class CustomerSpringDAOImpl implements CustomSpringDAO 
{
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public Customer findById(Long id)
	{
		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		
		return optionalCustomer.isPresent() ? optionalCustomer.get() : null;
	}

	public Customer findByEmail(String email) {
		Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
		
		return optionalCustomer.isPresent() ? optionalCustomer.get() : null;
	}

	public void addOrder(Long idCustomer, Long idProduct) throws Exception {
		/* cercare il customer */
		Customer customer = findById(idCustomer);
		if(customer == null)
			throw new Exception("Customer non presente");
		
		/* controllare se esiste gia' l'ordine */
		Optional<Product> optionalProduct = customer.getProducts().stream().filter(p -> p.getId() == idProduct).findFirst();
		if(optionalProduct.isPresent())
			throw new Exception("Ordine gia' presente");
				
		/* controllare se esiste il prodotto */
		Optional<Product> prodotto = productRepository.findById(idProduct);
		if(!prodotto.isPresent())
			throw new Exception("Prodotto non presente");
		
		/* aggiungere ordine */
		customer.addProduct(prodotto.get());
		customerRepository.save(customer);
		
	}

	@Override
	public List<Product> listaProdotti(Long idCustomer) throws Exception {
		/*  cercare il customer */
		Optional<Customer> optionalCustomer = customerRepository.findById(idCustomer);
		if(!optionalCustomer.isPresent())
			throw new Exception("Customer non presente");
	
		return optionalCustomer.get().getProducts() ;
	}

	@Override
	public void deleteCustomer(Long idCustomer) throws Exception {
		/* cercare il customer */
		Optional<Customer> optionalCustomer = customerRepository.findById(idCustomer);
		if(!optionalCustomer.isPresent())
			throw new Exception("Customer non presente");
		
		customerRepository.delete(optionalCustomer.get());
	}

	@Override
	public List<Customer> findBySessoAndEta(String sesso, int eta) {
		return customerRepository.findBySessoAndEta(sesso, eta);
	}

	
}