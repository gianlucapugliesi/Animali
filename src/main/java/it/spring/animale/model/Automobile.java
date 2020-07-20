package it.spring.animale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "automobili")

public class Automobile 
{
	@Id
	@Column(name = "targa")
	private String targa;
		
	@Column(name = "modello")
	private String modello;
		
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "anno")
	private int anno;
	
	@ManyToOne
	@JoinColumn(name = "automobilista")
	private Automobilista automobilista;
	
	public Automobile(){}
	
	public Automobile(String targa, String modello, String marca, int anno) 
	{
		super();
		this.targa = targa;
		this.modello = modello;
		this.marca = marca;
		this.anno = anno;
	}
		
	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}
	
	public Automobilista getAutomobilista() {
		return automobilista;
	}

	public void setAutomobilista(Automobilista automobilista) {
		this.automobilista = automobilista;
	}
	
	@Override
	public String toString() {
	return "Automobile [targa =" + targa + ", modello =" + modello + ", marca =" + marca + ", anno ="
			+ anno + ", Automobilista =" + automobilista + "]";
	}
}