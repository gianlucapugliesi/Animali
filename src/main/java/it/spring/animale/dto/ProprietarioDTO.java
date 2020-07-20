package it.spring.animale.dto;

import java.util.ArrayList;
import java.util.List;

public class ProprietarioDTO 
{
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private String sesso;
	private int eta;
	private List<String> listaIdAnimali;
	
	public List<String> getListaIdAnimali() {
		return listaIdAnimali;
	}
	public void setListaIdAnimali(List<String> listaIdAnimali) {
		this.listaIdAnimali = listaIdAnimali;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	
	public ProprietarioDTO()
	{}
	
	public ProprietarioDTO(Long id, String nome, String cognome, String email, String sesso, int eta) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.sesso = sesso;
		this.eta = eta;
		this.listaIdAnimali = new ArrayList<String>();
	}	
}
