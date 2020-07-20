package it.spring.animale.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.spring.animale.dto.AutomobileDTO;
import it.spring.animale.dto.AutomobilistaDTO;
import it.spring.animale.dto.CambioProprietaDTO;
import it.spring.animale.model.Automobile;
import it.spring.animale.model.Automobilista;

@Service
public interface AutomobileService 
{
	public Automobilista findAutomobilistaById(Long id);
	public Automobile findAutomobileById(String targa);
	
	public void aggiungiAutomobilista(AutomobilistaDTO automobilistaDTO) throws Exception;
	public void aggiungiAutomobile(AutomobileDTO automobileDto) throws Exception;
	public List<Automobile> cercaPerMarca(String marca) throws Exception;
	public List<Automobile> listaAutoAutomobilista(Long idAutomobilista) throws Exception;
	public void rimuoviDatiAutomobilista(Long idAutomobilista) throws Exception;
	public void cambioProprieta(CambioProprietaDTO cambioProprietaDto) throws Exception;
	public void rimuoviAutomobile(String targa) throws Exception;
	public List<String> targheAutomobilista(Long idAutomobilista) throws Exception;
	public List<Automobile> autoAnno(String marca, int anno) throws Exception;
	
	
}
