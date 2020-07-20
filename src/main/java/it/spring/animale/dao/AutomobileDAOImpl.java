package it.spring.animale.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.spring.animale.dto.CambioProprietaDTO;
import it.spring.animale.model.Animale;
import it.spring.animale.model.Automobile;
import it.spring.animale.model.Automobilista;
import it.spring.animale.model.Proprietario;
import it.spring.animale.repository.AutomobileRepository;
import it.spring.animale.repository.AutomobilistaRepository;

@Component
public class AutomobileDAOImpl implements AutomobileDAO
{
	@Autowired
	AutomobileRepository automobileRepository;
	
	@Autowired
	AutomobilistaRepository automobilistaRepository;
	
	@Override
	public Automobilista findAutomobilistaById(Long id) 
	{
		Optional<Automobilista> optional = automobilistaRepository.findById(id);
		
		return optional.isPresent() ? optional.get() : null;
	}
	
	@Override
	public Automobile findAutomobileById(String targa) 
	{
		Optional<Automobile> optional = automobileRepository.findById(targa);
		
		return optional.isPresent() ? optional.get() : null;
	}
	
	//aggiungi automobilista
	@Override
	public void aggiungiAutomobilista(Automobilista automobilista) throws Exception 
	{
//		if(automobilista.getId() == null)
//			throw new Exception("Inserire id valido");
		
//		Optional<Automobilista> automobilistaOptional = automobilistaRepository.findById(automobilista.getId());
//		if(automobilistaOptional.isPresent())
//			throw new Exception("Automobilista gia' presente con id fornito");
//		else
//		{
			Long maxId = automobilistaRepository.findFirstByOrderByIdDesc().getId();
			automobilista.setId(maxId + 1);
			
			automobilistaRepository.save(automobilista);
			System.out.println("Automobilista inserito");
//		}
	}
	
	//aggiungi automobile
	@Override
	public void aggiungiAutomobile(Automobile automobile) throws Exception
	{
		if(automobile.getTarga() == null)
			throw new Exception("Inserire una targa valida");
		
		Optional<Automobile> automobileOptional = automobileRepository.findByTarga(automobile.getTarga());
		
		if(automobileOptional.isPresent())
			throw new Exception("Automobile gia' presente con targa fornita");
		else
		{
			automobileRepository.save(automobile);
			System.out.println("Automobile inserita");
		}	
	}
	
	//fornisce la lista di tutti i modelli di una certa marca, senza ripetizioni
	@Override
	public List<Automobile> cercaPerMarca(String marca) throws Exception
	{
		List<Automobile> listaAutoMarca = automobileRepository.findByMarca(marca);
		
		if(listaAutoMarca.isEmpty())
			throw new Exception("Nessun modello per la marca: " + marca);
		else
		{
			for(Automobile automobile : listaAutoMarca)
			{
				System.out.println(automobile);
			}	
		}
		
		return listaAutoMarca;
	}
	
	//fornisce la lista di auto possedute da un automobilista
	@Override
	public List<Automobile> listaAutoAutomobilista(Long idAutomobilista) throws Exception
	{
		Automobilista automobilista = findAutomobilistaById(idAutomobilista);
		
		if(automobilista == null)
			throw new Exception("Automobilista non presente");
		else
			System.out.println("Automobili acquistate: " + automobilista.getListaAutomobile());
				
		return automobilista.getListaAutomobile();
	}
	
	//rimuove le relazioni delle auto con l’automobilista(senza cancellare le auto) e poi rimuove l’automobilista
	@Override
	public void rimuoviDatiAutomobilista(Long idAutomobilista) throws Exception
	{
		Automobilista automobilista = findAutomobilistaById(idAutomobilista);
		if(automobilista == null)
			throw new Exception("Automobilista non presente");
		else
		{
			automobilistaRepository.delete(automobilista);
			System.out.println("Automobilista rimosso");
		}
	}
	
	//assegna il nuovo proprietario all’automobile con la targa fornita
	@Override
	public void cambioProprieta(CambioProprietaDTO cambioProprietaDto) throws Exception
	{
		Optional<Automobile> automobileOptional = automobileRepository.findByTarga(cambioProprietaDto.getTarga());
		Automobilista automobilista = findAutomobilistaById(cambioProprietaDto.getId());
		
		if(automobilista == null)
			throw new Exception("Automobilista non trovato");
		
		if(automobileOptional.isPresent())
		{	
			automobileOptional.get().setAutomobilista(automobilista);
			automobileRepository.save(automobileOptional.get());
			System.out.println("Cambio proprieta' effettuato");
		}	
		else
		{
			throw new Exception("Automobile non trovata");
		}
	}
	
	//rimuove l’auto con la targa fornita
	@Override
	public void rimuoviAutomobile(String targa) throws Exception
	{
		Optional<Automobile> automobileOptional = automobileRepository.findByTarga(targa);
		
		if(!automobileOptional.isPresent())
			throw new Exception("Animale non presente");
		else
		{
			automobileRepository.delete(automobileOptional.get());
			System.out.println("Automobile rimossa");
		}
	}
	
	//fornisce l’elenco delle targhe delle auto dell’automobilista dato
	@Override
	public List<String> targheAutomobilista(Long idAutomobilista) throws Exception
	{
		Automobilista automobilista = findAutomobilistaById(idAutomobilista);
		List<String> targheAuto = new ArrayList<String>();
		
		if(automobilista == null)
			throw new Exception("Automobilista non trovato");
		
		for(Automobile automobile : automobilista.getListaAutomobile())
		{
			targheAuto.add(automobile.getTarga());
		}
		
		System.out.println(targheAuto);
		return targheAuto;
		
	}
	
	//restituisce tutte le auto di una certa marca immatricolate in un certo anno
	@Override
	public List<Automobile> autoAnno(String marca, int anno) throws Exception
	{
		List<Automobile> listaAutoMarca = automobileRepository.findByMarca(marca);
		
		List<Automobile> listaAutoAnno = listaAutoMarca.stream().filter(p -> p.getAnno() == anno).collect(Collectors.toList());
		
		System.out.println(listaAutoAnno);
		return listaAutoAnno;
	}
}
