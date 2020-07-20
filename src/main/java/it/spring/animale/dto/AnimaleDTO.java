package it.spring.animale.dto;

public class AnimaleDTO 
{
	private String id;
	private String nomeScientifico;
	private String avatar;
	
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
	
	public AnimaleDTO() {}
	
	public AnimaleDTO(String id, String nomeScientifico, String avatar, String dataAdozione) {
		super();
		this.id = id;
		this.nomeScientifico = nomeScientifico;
		this.avatar = avatar;
	}
}