package it.spring.animale.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "PROPRIETARIO")
public class Proprietario 
{
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "COGNOME")
	private String cognome;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "SESSO")
	private String sesso;
	
	@Column(name = "ETA")
	private int eta;
	
	//			colonna della foreign key	tutte le operazioni collegate	carica subito le relazioni 
	@OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Animale> listaAnimali;

	public Proprietario () {}
		
	public Proprietario(Long id, String nome, String cognome, String email, String sesso, int eta) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.sesso = sesso;
		this.eta = eta;
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

	public List<Animale> getListaAnimali() {
		return listaAnimali;
	}

	public void setListaAnimali(List<Animale> listaAnimali) {
		this.listaAnimali = listaAnimali;
	}
	
	public void aggiungiAnimale(Animale animale) {
		if(listaAnimali == null)
			listaAnimali = new ArrayList<Animale>();
		
		listaAnimali.add(animale);
	}

	@Override
	public String toString() {
		return "Proprietario [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", sesso="
				+ sesso + ", eta=" + eta + "]";
	}	
}