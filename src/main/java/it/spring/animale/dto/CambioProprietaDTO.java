package it.spring.animale.dto;

public class CambioProprietaDTO 
{
	private Long id;
	private String targa;
	
	public CambioProprietaDTO() {}
	
	public CambioProprietaDTO(Long id, String targa) {
		super();
		this.id = id;
		this.targa = targa;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	
	
}
