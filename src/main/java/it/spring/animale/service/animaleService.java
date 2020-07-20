package it.spring.animale.service;

import java.util.List;
import org.springframework.stereotype.Service;

import it.spring.animale.dto.AnimaleDTO;
import it.spring.animale.dto.ProprietarioDTO;
import it.spring.animale.model.Animale;
import it.spring.animale.model.Customer;
import it.spring.animale.model.Product;
import it.spring.animale.model.Proprietario;

@Service
public interface animaleService 
{
//	public Customer findById(Long id);
	public Customer findByEmail(String email);
	public void addOrder(Long idCustomer, Long idProduct) throws Exception;
	public List<Product> listaProdotti(Long idCustomer) throws Exception;
	public void deleteCustomer(Long idCustomer) throws Exception;
	public List<Customer> findBySessoAndEta(String sesso, int eta);
	
	public Proprietario findById(Long idProprietario);
	public Animale findById(String idAnimale);
	public List<Animale> findByIdProprietario (Long idProprietario);
	public List<Animale> animaliProprietario(Long idProprietario) throws Exception; 
	public void aggiungiAnimale(AnimaleDTO animaleDto) throws Exception;
	void aggiungiAnimaleProprietario(Long idProprietario, String idAnimale) throws Exception;
	public void aggiungiProprietario(ProprietarioDTO proprietarioDto) throws Exception;
	public void cancellaProprietario(Long idProprietario) throws Exception;
	public void cancellaAnimale(String id) throws Exception;
	public void cancellaAnimaliProprietario(Long idProprietario) throws Exception;
	public void aggiornaProprietario(ProprietarioDTO proprietarioDto) throws Exception;
	public void modificaAvatar(String idAnimale, String nuovoAvatar) throws Exception;
	public List<Proprietario> listaProprietari(String nomeComune) throws Exception;
	public int  numeroAnimali(Long idProprietario) throws Exception;
	
}
