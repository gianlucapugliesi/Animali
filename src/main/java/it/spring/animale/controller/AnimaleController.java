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
import it.spring.animale.dto.AnimaleDTO;
import it.spring.animale.dto.EsitoDTO;
import it.spring.animale.dto.ProprietarioDTO;
import it.spring.animale.model.Animale;
import it.spring.animale.model.Proprietario;
import it.spring.animale.service.animaleService;

@RestController
@RequestMapping("/animale")
public class AnimaleController 
{
	@Autowired
	animaleService animaleService;
	
	//restituisce la lista di tutti gli animali posseduti dal proprietario con l'ID fornito
	@RequestMapping(value = "/animaliProprietario/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Animale>> animaliProprietario(@PathVariable Long id) throws Exception 
	{
		List<Animale> listaAnimali = animaleService.animaliProprietario(id);

		return ResponseEntity.status(HttpStatus.OK).body(listaAnimali);
	}
	
	//aggiungi prprietario
	@RequestMapping(value = "/aggiungiProprietario", method = RequestMethod.PUT)
	public ResponseEntity<EsitoDTO> aggiungiProprietario(@RequestBody ProprietarioDTO proprietarioDto)
	{
		System.out.println("Metodo aggiungi proprietario");
		
		try {
			animaleService.aggiungiProprietario(proprietarioDto);
			
			EsitoDTO esito = new EsitoDTO(HttpStatus.OK, "OK");
			
			return ResponseEntity.status(HttpStatus.OK).body(esito);
			
		}catch(Exception e){
			
			EsitoDTO esitoEccezione = new EsitoDTO(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(esitoEccezione);
		}
	}
	
	//aggiunge un animale
	@RequestMapping(value = "/aggiungiAnimale", method = RequestMethod.PUT)
	public ResponseEntity<EsitoDTO> aggiungiAnimale(@RequestBody AnimaleDTO animaleDto)
	{
		System.out.println("Metodo aggiungi proprietario");
		
		try {
			animaleService.aggiungiAnimale(animaleDto);
			
			EsitoDTO esito = new EsitoDTO(HttpStatus.OK, "OK");
			
			return ResponseEntity.status(HttpStatus.OK).body(esito);
			
		}catch(Exception e){
			
			EsitoDTO esitoEccezione = new EsitoDTO(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(esitoEccezione);
		}
	}
	
	//aggiunge la relazione fra un proprietario ed il suo animale
	@RequestMapping(value = "/aggiungiAnimaleProprietario", method = RequestMethod.PUT)
	public ResponseEntity<EsitoDTO> aggiungiAnimaleProprietario(@RequestBody ProprietarioDTO proprietarioDto) throws Exception
	{
		System.out.println("Metodo aggiungi adozione");
		
		try {
			
			for(String idAnimale : proprietarioDto.getListaIdAnimali())
			{
				animaleService.aggiungiAnimaleProprietario(proprietarioDto.getId(), idAnimale);
			}
			
			EsitoDTO esito = new EsitoDTO(HttpStatus.OK, "OK");
			
			return ResponseEntity.status(HttpStatus.OK).body(esito);
			
		}catch(Exception e){
			
			EsitoDTO esitoEccezione = new EsitoDTO(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(esitoEccezione);
		}
	}
	
	//cancellaProprietario
	@RequestMapping(value = "/cancellaProprietario/{id}", method = RequestMethod.GET) 
	public ResponseEntity<EsitoDTO> cancellaProprietario(@PathVariable Long id) throws Exception
	{
		try {
			animaleService.cancellaProprietario(id);
			
			EsitoDTO esito = new EsitoDTO(HttpStatus.OK, "OK");
			
			return ResponseEntity.status(HttpStatus.OK).body(esito);
			
		}catch(Exception e){
			
			EsitoDTO esitoEccezione = new EsitoDTO(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(esitoEccezione);
		}
	}
	
	//cancella animale
	@RequestMapping(value = "/rimuoviAnimale/{id}", method = RequestMethod.GET) 
	public ResponseEntity<EsitoDTO> cancellaAnimale(@PathVariable String id) throws Exception
	{
		try {
			animaleService.cancellaAnimale(id);
			
			EsitoDTO esito = new EsitoDTO(HttpStatus.OK, "OK");
			
			return ResponseEntity.status(HttpStatus.OK).body(esito);
			
		}catch(Exception e){
			
			EsitoDTO esitoEccezione = new EsitoDTO(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(esitoEccezione);
		}
	}
	
	//cancella tutti gli animali di un proprietario
	@RequestMapping(value = "/cancellaAnimaliProprietario/{id}", method = RequestMethod.GET)
	public ResponseEntity<EsitoDTO> cancellaAnimaliProprietario(@PathVariable Long idProprietario) throws Exception
	{
		try {
			animaleService.cancellaAnimaliProprietario(idProprietario);
			
			EsitoDTO esito = new EsitoDTO(HttpStatus.OK, "OK");
			
			return ResponseEntity.status(HttpStatus.OK).body(esito);
			
		}catch(Exception e){
			
			EsitoDTO esitoEccezione = new EsitoDTO(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(esitoEccezione);
		}
	}
	
	//aggiorna dati proprietario
	@RequestMapping(value = "/aggiornaProprietario", method = RequestMethod.PUT)
	public ResponseEntity<EsitoDTO> aggiornaProprietario(@RequestBody ProprietarioDTO proprietarioDto)
	{
		System.out.println("Metodo aggiorna proprietario");
		
		try {
			animaleService.aggiornaProprietario(proprietarioDto);
			
			EsitoDTO esito = new EsitoDTO(HttpStatus.OK, "OK");
			
			return ResponseEntity.status(HttpStatus.OK).body(esito);
			
		}catch(Exception e){
			
			EsitoDTO esitoEccezione = new EsitoDTO(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(esitoEccezione);
		}
	}
	
	//modifica avatar
	@RequestMapping(value = "/modificaAvatar/{idAnimale, nuovoAvatar}", method = RequestMethod.PUT)
	public ResponseEntity<EsitoDTO> modificaAvatar(@PathVariable String idAnimale, String nuovoAvatar) throws Exception
	{
		System.out.println("Metodo aggiorna avatar");
		
		try {
			animaleService.modificaAvatar(idAnimale, nuovoAvatar);
			
			EsitoDTO esito = new EsitoDTO(HttpStatus.OK, "OK");
			
			return ResponseEntity.status(HttpStatus.OK).body(esito);
			
		}catch(Exception e){
			
			EsitoDTO esitoEccezione = new EsitoDTO(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(esitoEccezione);
		}
	}
	
	//nome in comune
	@RequestMapping(value = "/listaProprietari/{nomeComune}", method = RequestMethod.GET)
	public ResponseEntity<List<Proprietario>> listaProprietari(@PathVariable String nomeComune) throws Exception
	{
		List<Proprietario> listaProprietari = animaleService.listaProprietari(nomeComune);
		
		return ResponseEntity.status(HttpStatus.OK).body(listaProprietari);
	}
	
	//numero animale proprietario
	@RequestMapping(value = "/numeroAnimali/{idProprietario}", method = RequestMethod.GET)
	public ResponseEntity<Integer> numeroAnimali(@PathVariable Long idProprietario) throws Exception
	{
		int numeroAnimali = animaleService.numeroAnimali(idProprietario);
		
		return ResponseEntity.status(HttpStatus.OK).body(numeroAnimali);
	}
}