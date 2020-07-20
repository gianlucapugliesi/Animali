package it.spring.animale.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "automobilista")

public class Automobilista 
{
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "sesso")
	private String sesso;
	
	@Column(name = "eta")
	private int eta;
	
	//			colonna della foreign key	tutte le operazioni collegate	carica subito le relazioni 
//	@OneToMany(mappedBy = "automobilista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private List<Automobile> listaAutomobili;

	@OneToMany(mappedBy = "automobilista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Automobile> listaAutomobili;
	
	public Automobilista () {
		this.listaAutomobili = new ArrayList<Automobile>();
	}
		
	public Automobilista(Long id, String nome, String cognome, String email, String sesso, int eta) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.sesso = sesso;
		this.eta = eta;
		this.listaAutomobili = new ArrayList<Automobile>();
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

	public List<Automobile> getListaAutomobile() {
		return listaAutomobili;
	}

	public void setListaAutomobili(List<Automobile> listaAutomobili) {
		this.listaAutomobili = listaAutomobili;
	}
	
	public void aggiungiAutomobile(Automobile automobile) {
		if(listaAutomobili == null)
			listaAutomobili = new ArrayList<Automobile>();
		
		listaAutomobili.add(automobile);
	}

	@Override
	public String toString() {
		return "Automobilista [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", sesso="
				+ sesso + ", eta=" + eta + "]";
	}	
}
