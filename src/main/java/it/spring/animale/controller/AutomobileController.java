package it.spring.animale.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import it.spring.animale.dto.AutomobileDTO;
import it.spring.animale.dto.AutomobilistaDTO;
import it.spring.animale.dto.CambioProprietaDTO;
import it.spring.animale.dto.EsitoDTO;
import it.spring.animale.model.Automobile;
import it.spring.animale.service.AutomobileService;

@RestController
@RequestMapping("/automobile") //percorso per arrivare a questa classe
public class AutomobileController 
{
	@Autowired
	AutomobileService automobileService;
	
	//restituisce una lista delle targhe appartenenti ad un automobilista
	@RequestMapping(value = "/getListaTarghe/{id}", method = RequestMethod.GET) //percorso per arrivare a questo metodo
	public ResponseEntity<List<String>> getListaTarghe(@PathVariable Long id) throws Exception
	{
		List<String> listaTarghe = automobileService.targheAutomobilista(id);

		return ResponseEntity.status(HttpStatus.OK).body(listaTarghe);
	}
	
	//restituisce una lista di auto di una marca
	@RequestMapping(value = "/cercaPerMarca/{marca}", method = RequestMethod.GET) 
	public ResponseEntity<List<Automobile>> cercaPerMarca(@PathVariable String marca) throws Exception
	{
		List<Automobile> listaAuto = automobileService.cercaPerMarca(marca);

		return ResponseEntity.status(HttpStatus.OK).body(listaAuto);
	}
	
	//fornisce la lista di auto possedute da un automobilista
	@RequestMapping(value = "/listaAutoAutomobilista/{id}", method = RequestMethod.GET) 
	public ResponseEntity<List<Automobile>> listaAutoAutomobilista(@PathVariable Long id) throws Exception
	{
		List<Automobile> listaAutoId = automobileService.listaAutoAutomobilista(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(listaAutoId);
	}
	
	//restituisce tutte le auto di una certa marca immatricolate in un certo anno
	@RequestMapping(value = "/autoAnno/{marca,anno}", method = RequestMethod.GET) 
	public ResponseEntity<List<Automobile>> autoAnno(String marca, int anno) throws Exception
	{
		List<Automobile> listaAuto = automobileService.autoAnno(marca, anno);
		
		return ResponseEntity.status(HttpStatus.OK).body(listaAuto);
	}
	
	//rimuove l'automobilista con id fornito
	@RequestMapping(value = "/rimuoviDatiAutomobilista/{id}", method = RequestMethod.GET) 
	public ResponseEntity<EsitoDTO> rimuoviDatiAutomobilista(@PathVariable Long id) throws Exception
	{
		try {
			automobileService.rimuoviDatiAutomobilista(id);
			
			EsitoDTO esito = new EsitoDTO(HttpStatus.OK, "OK");
			
			return ResponseEntity.status(HttpStatus.OK).body(esito);
			
		}catch(Exception e){
			
			EsitoDTO esitoEccezione = new EsitoDTO(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(esitoEccezione);
		}
	}
	
	//inserisci automobilista
	@RequestMapping(value = "/aggiungiAutomobilista", method = RequestMethod.PUT)
	public ResponseEntity<EsitoDTO> aggiungiAutomobilista(@RequestBody AutomobilistaDTO automobilistaDto)
	{
		System.out.println("Metodo aggiungi automobilista");
		
		try {
			automobileService.aggiungiAutomobilista(automobilistaDto);
			
			EsitoDTO esito = new EsitoDTO(HttpStatus.OK, "OK");
			
			return ResponseEntity.status(HttpStatus.OK).body(esito);
			
		}catch(Exception e){
			
			EsitoDTO esitoEccezione = new EsitoDTO(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(esitoEccezione);
		}
	}
	
	//inserisci automobile
	@RequestMapping(value = "/aggiungiAutomobile", method = RequestMethod.PUT)
	public ResponseEntity<EsitoDTO> aggiungiAutomobile(@RequestBody AutomobileDTO automobileDto)
	{
		try {
			automobileService.aggiungiAutomobile(automobileDto);
			
			EsitoDTO esito = new EsitoDTO(HttpStatus.OK, "OK");
			
			return ResponseEntity.status(HttpStatus.OK).body(esito);
		}
		catch(Exception e)
		{
			EsitoDTO esitoEccezione = new EsitoDTO(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(esitoEccezione);
		}
	}
	
	//passaggio di proprieta
	@RequestMapping(value = "/cambioProprieta", method = RequestMethod.PUT)
	public ResponseEntity<EsitoDTO> cambioProprieta(@RequestBody CambioProprietaDTO cambioProprietaDto)
	{
		try {
			automobileService.cambioProprieta(cambioProprietaDto);
			
			EsitoDTO esito = new EsitoDTO(HttpStatus.OK, "OK");
			
			return ResponseEntity.status(HttpStatus.OK).body(esito);
			
		}catch(Exception e){
			
			EsitoDTO esitoEccezione = new EsitoDTO(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(esitoEccezione);
		}
	}
	
	//rimuove automobile
	@RequestMapping(value = "/rimuoviAutomobile/{targa}", method = RequestMethod.GET)
	public ResponseEntity<EsitoDTO> rimuoviAutomobile(String targa)
	{
		try {
			automobileService.rimuoviAutomobile(targa);
			
			EsitoDTO esito = new EsitoDTO(HttpStatus.OK, "OK");
			
			return ResponseEntity.status(HttpStatus.OK).body(esito);
			
		}catch(Exception e){
			
			EsitoDTO esitoEccezione = new EsitoDTO(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(esitoEccezione);
		}
	}
}
