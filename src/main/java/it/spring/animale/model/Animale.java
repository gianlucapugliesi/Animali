package it.spring.animale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "animale")
public class Animale 
{
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "nome_scientifico")
	private String nomeScientifico;
	
	@Column(name = "avatar")
	private String avatar;
	
	@Column(name = "data_adozione")
	private String dataAdozione;
	
	@ManyToOne
	@JoinColumn(name = "id_proprietario")
	private Proprietario proprietario;
	
	public Animale(){}
	
	public Animale(String id, String nomeScientifico, String avatar) 
	{
		super();
		this.id = id;
		this.nomeScientifico = nomeScientifico;
		this.avatar = avatar;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeScientifico() {
		return nomeScientifico;
	}

	public void setNomeScientifico(String nomeScientifico) {
		this.nomeScientifico = nomeScientifico;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDataAdozione() {
		return dataAdozione;
	}

	public void setDataAdozione(String data) {
		this.dataAdozione = data;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public String toString() {
		return "Animale [id=" + id + ", nomeScientifico=" + nomeScientifico + ", avatar=" + avatar + ", dataAdozione="
				+ dataAdozione + ", proprietario=" + proprietario + "]";
	}
	
	
}
