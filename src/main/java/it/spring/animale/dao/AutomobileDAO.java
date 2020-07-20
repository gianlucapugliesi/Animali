package it.spring.animale.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import it.spring.animale.dto.CambioProprietaDTO;
import it.spring.animale.model.Automobile;
import it.spring.animale.model.Automobilista;

@Component
public interface AutomobileDAO
{
	public Automobilista findAutomobilistaById(Long id);
	public Automobile findAutomobileById(String targa);
	
	
	public void aggiungiAutomobilista(Automobilista automobilista) throws Exception;
	public void aggiungiAutomobile(Automobile automobile) throws Exception;
	public List<Automobile> cercaPerMarca(String marca) throws Exception;
	public List<Automobile> listaAutoAutomobilista(Long idAutomobilista) throws Exception;
	public void rimuoviDatiAutomobilista(Long idAutomobilista) throws Exception;
	public void cambioProprieta(CambioProprietaDTO cambioProprietaDto) throws Exception;
	public void rimuoviAutomobile(String targa) throws Exception;
	public List<String> targheAutomobilista(Long idAutomobilista) throws Exception;
	public List<Automobile> autoAnno(String marca, int anno) throws Exception;
	
}
