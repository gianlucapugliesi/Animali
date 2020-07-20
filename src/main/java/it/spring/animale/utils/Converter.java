package it.spring.animale.utils;

import it.spring.animale.dto.AnimaleDTO;
import it.spring.animale.dto.AutomobileDTO;
import it.spring.animale.dto.AutomobilistaDTO;
import it.spring.animale.dto.ProprietarioDTO;
import it.spring.animale.model.Animale;
import it.spring.animale.model.Automobile;
import it.spring.animale.model.Automobilista;
import it.spring.animale.model.Proprietario;

public class Converter 
{
	public static Automobilista fromAutomobilistaDTO2Automobilista(AutomobilistaDTO automobilistaDTO)
	{
		Automobilista automobilista = new Automobilista();
		automobilista.setNome(automobilistaDTO.getNome());
		automobilista.setCognome(automobilistaDTO.getCognome());
		automobilista.setEmail(automobilistaDTO.getEmail());
		automobilista.setSesso(automobilistaDTO.getSesso());
		automobilista.setEta(automobilistaDTO.getEta());
		
		return automobilista;
	}
	
	public static Automobile fromAutomobileDTO2Automobile(AutomobileDTO automobileDto)
	{
		Automobile automobile = new Automobile();
		automobile.setTarga(automobileDto.getTarga());
		automobile.setModello(automobileDto.getModello());
		automobile.setMarca(automobileDto.getMarca());
		automobile.setAnno(automobileDto.getAnno());
		automobile.setAutomobilista(automobileDto.getAutomobilista());
		
		return automobile;
	}
	
	public static Proprietario fromProprietarioDTO2Proprietario(ProprietarioDTO proprietarioDTO)
	{
		Proprietario proprietario = new Proprietario();
		proprietario.setNome(proprietarioDTO.getNome());
		proprietario.setCognome(proprietarioDTO.getCognome());
		proprietario.setEmail(proprietarioDTO.getEmail());
		proprietario.setSesso(proprietarioDTO.getSesso());
		proprietario.setEta(proprietarioDTO.getEta());
		
		return proprietario;
	}
	
	public static Animale fromAnimaleDTO2Animale(AnimaleDTO animaleDto)
	{
		Animale animale = new Animale();
		animale.setId(animaleDto.getId());
		animale.setNomeScientifico(animaleDto.getNomeScientifico());
		animale.setAvatar(animaleDto.getAvatar());
		
		return animale;
	}
}
