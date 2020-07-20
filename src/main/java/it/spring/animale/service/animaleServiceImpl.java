package it.spring.animale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.spring.animale.dao.CustomSpringDAO;
import it.spring.animale.dao.ProprietarioDAO;
import it.spring.animale.dto.AnimaleDTO;
import it.spring.animale.dto.ProprietarioDTO;
import it.spring.animale.model.Animale;
import it.spring.animale.model.Customer;
import it.spring.animale.model.Product;
import it.spring.animale.model.Proprietario;
import it.spring.animale.utils.Converter;

@Service
public class animaleServiceImpl implements animaleService 
{
	@Autowired
	CustomSpringDAO customerDAO;
	
	@Autowired
	ProprietarioDAO proprietarioDAO;

	@Override
	public Proprietario findById(Long idProprietario) {
		return proprietarioDAO.findById(idProprietario);
	}
	
	@Override
	public Animale findById(String idAnimale) {
		return proprietarioDAO.findById(idAnimale);
	}
	
	@Override
	public List<Animale> animaliProprietario(Long idProprietario) throws Exception {
		return proprietarioDAO.animaliProprietario(idProprietario);
	}
	
//	public Customer findById(Long id) 
//	{
//		return customDAO.findById(id);
//	}

	public Customer findByEmail(String email) {
		return customerDAO.findByEmail(email);
	}

	@Override
	public void addOrder(Long idCustomer, Long idProduct) throws Exception {
		customerDAO.addOrder(idCustomer, idProduct);
		
	}

	@Override
	public List<Product> listaProdotti(Long idCustomer) throws Exception {
		return customerDAO.listaProdotti(idCustomer);
	}

	@Override
	public void deleteCustomer(Long idCustomer) throws Exception {
		customerDAO.deleteCustomer(idCustomer);
		
	}

	@Override
	public List<Customer> findBySessoAndEta(String sesso, int eta) {
		return customerDAO.findBySessoAndEta(sesso, eta);
	}
	
	@Override
	public void aggiungiProprietario(ProprietarioDTO proprietarioDto) throws Exception 
	{
		Proprietario proprietario = Converter.fromProprietarioDTO2Proprietario(proprietarioDto);
		
		proprietarioDAO.aggiungiProprietario(proprietario);
	}
	
	@Override
	public void aggiungiAnimaleProprietario(Long idProprietario, String idAnimale) throws Exception
	{
		proprietarioDAO.aggiungiAnimaleProprietario(idProprietario, idAnimale);
	}
	
	@Override
	public void aggiungiAnimale(AnimaleDTO animaleDto) throws Exception
	{
		Animale animale = Converter.fromAnimaleDTO2Animale(animaleDto);
		
		proprietarioDAO.aggiungiAnimale(animale);
	}	
	
	@Override
	public void cancellaProprietario(Long idProprietario) throws Exception
	{
		proprietarioDAO.cancellaProprietario(idProprietario);
	}
	
	@Override
	public void cancellaAnimale(String id) throws Exception
	{
		proprietarioDAO.cancellaAnimale(id);
	}
	
	@Override
	public void cancellaAnimaliProprietario(Long idProprietario) throws Exception
	{
		proprietarioDAO.cancellaAnimaliProprietario(idProprietario);
	}
	
	@Override
	public void aggiornaProprietario(ProprietarioDTO proprietarioDto) throws Exception
	{
		Proprietario proprietario = Converter.fromProprietarioDTO2Proprietario(proprietarioDto);
		proprietarioDAO.aggiornaProprietario(proprietario);
	}
	
	@Override
	public void modificaAvatar(String idAnimale, String nuovoAvatar) throws Exception
	{
		proprietarioDAO.modificaAvatar(idAnimale, nuovoAvatar);
	}
	
	@Override
	public List<Proprietario> listaProprietari(String nomeComune) throws Exception
	{
		return proprietarioDAO.listaProprietari(nomeComune);
	}
	
	@Override
	public int  numeroAnimali(Long idProprietario) throws Exception
	{
		return proprietarioDAO.numeroAnimali(idProprietario);
	}

	@Override
	public List<Animale> findByIdProprietario(Long idProprietario) {
		return proprietarioDAO.findByIdProprietario(idProprietario);
	}
}