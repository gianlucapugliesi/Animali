package it.spring.animale.dto;

import it.spring.animale.model.Automobilista;

public class AutomobileDTO 
{
	private String targa;
	private String modello;
	private String marca;
	private int anno;
	private Automobilista automobilista;
	
	public AutomobileDTO() {}
	
	public AutomobileDTO(String targa, String modello, String marca, int anno, Automobilista automobilista) {
		super();
		this.targa = targa;
		this.modello = modello;
		this.marca = marca;
		this.anno = anno;
		this.automobilista = automobilista;
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
	
	
}
