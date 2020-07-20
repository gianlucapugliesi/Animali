package it.spring.animale.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import it.spring.animale.dto.ProprietarioDTO;
import it.spring.animale.model.Animale;
import it.spring.animale.model.Proprietario;

@Component
public interface ProprietarioDAO 
{
	public Proprietario findById(Long idProprietario);
	public Animale findById(String idAnimale);
	public List<Animale> findByIdProprietario (Long idProprietario);
	public List<Animale> animaliProprietario(Long idProprietario) throws Exception;
	public void aggiungiProprietario(Proprietario proprietario) throws Exception;
	public void aggiungiAnimale(Animale animale) throws Exception;
	public void aggiungiAnimaleProprietario(Long idProprietario, String idAnimale) throws Exception;
	public void cancellaProprietario(Long idProprietario) throws Exception;
	public void cancellaAnimale(String id) throws Exception;
	public void cancellaAnimaliProprietario(Long idProprietario) throws Exception;
	public void aggiornaProprietario(Proprietario p) throws Exception;
	public void modificaAvatar(String idAnimale, String nuovoAvatar) throws Exception;
	public List<Proprietario> listaProprietari(String nomeComune) throws Exception;
	public int  numeroAnimali(Long idProprietario) throws Exception;
}