package it.spring.animale.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product 
{
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NOME_PRODOTTO")
	private String nomeProdotto;
	
	@Column(name = "ID_PRODOTTO")
	private String codice_prodotto;
	
	@Column(name = "PREZZO")
	private double prezzo;
	
	@ManyToMany(mappedBy = "products", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Customer> customersList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public String getCodice_prodotto() {
		return codice_prodotto;
	}

	public void setCodice_prodotto(String codice_prodotto) {
		this.codice_prodotto = codice_prodotto;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public List<Customer> getCustomersList() {
		return customersList;
	}

	public void setCustomersList(List<Customer> customersList) {
		this.customersList = customersList;
	}
	
	public void addCustomer(Customer customer)
	{
		if(customersList == null)
			customersList = new ArrayList<Customer>();
		
		customersList.add(customer);
	}
}
