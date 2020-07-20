package it.spring.animale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.spring.animale.dao.AutomobileDAO;
import it.spring.animale.dto.AutomobileDTO;
import it.spring.animale.dto.AutomobilistaDTO;
import it.spring.animale.dto.CambioProprietaDTO;
import it.spring.animale.model.Automobile;
import it.spring.animale.model.Automobilista;
import it.spring.animale.utils.Converter;

@Service
public class AutomobileServiceImpl implements AutomobileService
{
	@Autowired
	AutomobileDAO automobileDao;
	
	@Override
	public Automobilista findAutomobilistaById(Long id) 
	{
		return automobileDao.findAutomobilistaById(id);
	}
	
	@Override
	public Automobile findAutomobileById(String targa) 
	{
		return automobileDao.findAutomobileById(targa);
	}
	
	@Override
	public void aggiungiAutomobilista(AutomobilistaDTO automobilistaDTO) throws Exception
	{
		Automobilista automobilista = Converter.fromAutomobilistaDTO2Automobilista(automobilistaDTO);
		
		automobileDao.aggiungiAutomobilista(automobilista);
	}
	
	@Override
	public void aggiungiAutomobile(AutomobileDTO automobileDto) throws Exception
	{
		Automobile automobile = Converter.fromAutomobileDTO2Automobile(automobileDto);
		
		automobileDao.aggiungiAutomobile(automobile);
	}
	
	@Override
	public List<Automobile> cercaPerMarca(String marca) throws Exception
	{
		return automobileDao.cercaPerMarca(marca);
	}
	
	@Override
	public List<Automobile> listaAutoAutomobilista(Long idAutomobilista) throws Exception
	{
		return automobileDao.listaAutoAutomobilista(idAutomobilista);
	}
	
	@Override
	public void rimuoviDatiAutomobilista(Long idAutomobilista) throws Exception
	{
		automobileDao.rimuoviDatiAutomobilista(idAutomobilista);
	}
	
	@Override
	public void cambioProprieta(CambioProprietaDTO cambioProprietaDto) throws Exception
	{
		automobileDao.cambioProprieta(cambioProprietaDto);
	}
	
	@Override
	public void rimuoviAutomobile(String targa) throws Exception
	{
		automobileDao.rimuoviAutomobile(targa);
	}
	
	@Override
	public List<String> targheAutomobilista(Long idAutomobilista) throws Exception
	{
		return automobileDao.targheAutomobilista(idAutomobilista);
	}
	
	@Override
	public List<Automobile> autoAnno(String marca, int anno) throws Exception
	{
		return automobileDao.autoAnno(marca, anno);
	}
}
