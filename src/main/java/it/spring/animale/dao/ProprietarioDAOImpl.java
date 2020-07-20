package it.spring.animale.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import it.spring.animale.model.Animale;
import it.spring.animale.model.Proprietario;
import it.spring.animale.repository.AnimaleRepository;
import it.spring.animale.repository.ProprietarioRepository;

@Component
public class ProprietarioDAOImpl implements ProprietarioDAO 
{
	@Autowired
	ProprietarioRepository proprietarioRepository;
	
	@Autowired
	AnimaleRepository animaleRepository;
	
	@Override
	public Proprietario findById(Long idProprietario) 
	{
		Optional<Proprietario> optional = proprietarioRepository.findById(idProprietario);
		
		return optional.isPresent() ? optional.get() : null;
	}
	
	@Override
	public Animale findById(String idAnimale) 
	{
		Optional<Animale> optional = animaleRepository.findById(idAnimale);
		
		return optional.isPresent() ? optional.get() : null;
	}
	
	@Override
	public List<Animale> findByIdProprietario(Long idProprietario) 
	{
//		List<Animale> optional = animaleRepository.findByIdProprietario(idProprietario);
//		
//		return optional;
		return null;
	}
	
	//restituisce la lista di tutti gli animali posseduti dal proprietario con l'ID fornito
	@Override
	public List<Animale> animaliProprietario(Long idProprietario) throws Exception {
		/* controllare proprietario */
		Proprietario proprietario = findById(idProprietario);
		if(proprietario == null)
			throw new Exception("Proprietario non presente");
		else
			System.out.println("Animali adottati: " + proprietario.getListaAnimali());
				
		return proprietario.getListaAnimali();
	}

	//aggiunge un nuovo Proprietario sul DB, se non esiste un proprietario con la stessa email
	@Override
	public void aggiungiProprietario(Proprietario proprietario) throws Exception 
	{
		Long maxId = proprietarioRepository.findFirstByOrderByIdDesc().getId();
		proprietario.setId(maxId + 1);
		
		proprietarioRepository.save(proprietario);
		System.out.println("Proprietario inserito");
		
//		/* controllo per email */
//		if(proprietario.getEmail() == null)
//			throw new Exception("Email non presente");
//		
//		Optional<Proprietario> proprietarioOptional = proprietarioRepository.findByEmail(proprietario.getEmail());
//		if(proprietarioOptional.isPresent())
//			throw new Exception("Proprietario gia' presente con email fornita");
//		else
//		{
//			proprietarioRepository.save(proprietario);
//			System.out.println("Proprietario inserito");
//		}
	}
	
	//aggiunge un animale al DB se non ne esiste un altro con lo stesso codice
	@Override
	public void aggiungiAnimale(Animale animale) throws Exception
	{
		if(animale.getId() == null)
			throw new Exception("Codice non presente");
	
		Optional<Animale> animaleOptional = animaleRepository.findById(animale.getId());
		
		if(animaleOptional.isPresent())
			throw new Exception("Animale gia' presente con id fornito");
		else
		{
			animaleRepository.save(animale);
			System.out.println("Animale inserito");
		}	
	}
	
	//aggiunge la relazione fra un proprietario ed il suo animale
	@Override
	public void aggiungiAnimaleProprietario(Long idProprietario, String idAnimale) throws Exception
	{
		Proprietario proprietario = findById(idProprietario);
		if(proprietario == null)
			throw new Exception("Proprietario non presente");
		
		Animale animale = findById(idAnimale);
		if(animale.getId() == null)
			throw new Exception("Animale non presente");
		
		Optional<Animale> optionalAnimale = proprietario.getListaAnimali().stream().filter(p -> p.getId() == idAnimale).findFirst();
		if(optionalAnimale.isPresent())
			throw new Exception("Adozione gia' presente");
		else
		{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String data = formatter.format(date);
			
			animale.setProprietario(proprietario);
			animale.setDataAdozione(data);
			proprietario.aggiungiAnimale(animale);
			proprietarioRepository.save(proprietario);
			System.out.println("Adozione eseguita");
		}	
	}
	
	//cancella dal DB il proprietario avente l'ID fornito e tutti i dati che lo riguardano
	@Override
	public void cancellaProprietario(Long idProprietario) throws Exception
	{
		Proprietario proprietario = findById(idProprietario);
		if(proprietario == null)
			throw new Exception("Proprietario non presente");
		else
		{
			proprietarioRepository.delete(proprietario);
			System.out.println("Proprietario rimosso");
		}
//		Optional<Proprietario> optionalProprietario = proprietarioRepository.findById(idProprietario);
//		if(!optionalProprietario.isPresent())
//			throw new Exception("Proprietario non presente");
//		else
//		{
//			proprietarioRepository.delete(optionalProprietario.get());
//			System.out.println("Proprietario rimosso");
//		}
	}
	
	// cancella dal DB l'animale col codice fornito e tutti i dati che lo riguardano
	@Override
	public void cancellaAnimale(String id) throws Exception
	{
		Optional<Animale> optionalAnimale = animaleRepository.findById(id);
		if(!optionalAnimale.isPresent())
			throw new Exception("Animale non presente");
		else
		{
			animaleRepository.delete(optionalAnimale.get());
			System.out.println("Animale rimosso");
		}
	}
	
	//cancella dal DB tutti gli animale posseduti dal proprietario con l'ID fornito
	@Override
	public void cancellaAnimaliProprietario(Long idProprietario) throws Exception
	{
		List<Animale> animale = animaleRepository.cercaPerProprietario(idProprietario);
		
		if(animale.isEmpty())
			throw new Exception("Il proprietario non ha adottato animali");
		else
		{
			for(int i = 0; i<animale.size(); i++)
			{
				animale.get(i).setDataAdozione(null);
				animale.get(i).setProprietario(null);
				animaleRepository.save(animale.get(i));
				System.out.println("Animale non piu adottati dal proprietario " + idProprietario);
			}
		}
	}
	
	//aggiorna sul DB i dati del proprietario fornito, se presente sul DB, altrimenti lancia un'eccezione
	@Override
	public void aggiornaProprietario(Proprietario p) throws Exception
	{
		Proprietario proprietarioDb = findById(p.getId());
		if(proprietarioDb != null)
		{	
			proprietarioDb.setNome(p.getNome());
			proprietarioDb.setCognome(p.getCognome());
			proprietarioDb.setEmail(p.getEmail());
			proprietarioDb.setSesso(p.getSesso());
			proprietarioDb.setEta(p.getEta());
			proprietarioRepository.save(proprietarioDb);
			System.out.println("Proprietario aggiornato");
		}
		else
			throw new Exception("Id sbagliato");
	}
	
	// modifica sul DB l'avatar dell'animale associato all'ID fornito. Se l'animale non è presente sul DB, 
	//lancia un'eccezione
	@Override
	public void modificaAvatar(String idAnimale, String nuovoAvatar) throws Exception
	{
		Animale animale = findById(idAnimale);
		if(animale.getId() == null)
			throw new Exception("Animale non presente");
		else
		{	
			animale.setAvatar(nuovoAvatar);
			System.out.println("Animale aggiornato");
		}
		
		animaleRepository.save(animale);
	}
	
	//restituisce una lista dei proprietari che hanno almeno un animale col nome comune fornito
	@Override
	public List<Proprietario> listaProprietari(String nomeComune) throws Exception
	{
		List<Proprietario> listaProprietari = new ArrayList<Proprietario>();
		List<Animale> listaAnimale = animaleRepository.findByNomeScientifico(nomeComune);
		
		if(listaAnimale.isEmpty())
			throw new Exception("Nessun animale in comune");
		else
		{
			for(Animale animale : listaAnimale)
			{
				if(animale.getProprietario() != null)
					listaProprietari.add(animale.getProprietario());
			}
		}
		
		return listaProprietari;
	}
	
	//restituisce il numero di animali posseduti dal proprietario con l'ID fornito. 
	//Se il proprietario non esiste nel DB, viene lanciata un'eccezione.
	@Override
	public int  numeroAnimali(Long idProprietario) throws Exception
	{
		Proprietario proprietario = findById(idProprietario);
		if(proprietario == null)
			throw new Exception("Il proprietario non esiste");
		else
			System.out.println("Animali adottati dal proprietario " + idProprietario + ": " + proprietario.getListaAnimali().size());
		
		return proprietario.getListaAnimali().size();
	}
}