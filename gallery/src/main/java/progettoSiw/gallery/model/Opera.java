package progettoSiw.gallery.model;

import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Opera {
	//TODO : inserire foto opera e gestione OneToMany/ManyToOne bidirezionale

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=1)
	private String titolo;

	@NotNull
	private Integer anno;

	@NotNull
	@Size(min=1)
	private String dimensioni;

	@NotNull
	@Size(min=1)
	private String tecnica;

	@ManyToOne
	private Autore autore;


	private byte[] imgOpera;

	public Opera(){

	}

	public Opera(String titolo,Integer anno,String dimensioni,String tecnica,Autore autore){
		this.titolo=titolo;
		this.anno=anno;
		this.dimensioni=dimensioni;
		this.tecnica=tecnica;
		this.autore=autore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public String getDimensioni() {
		return dimensioni;
	}

	public void setDimensioni(String dimensioni) {
		this.dimensioni = dimensioni;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public String getImgOpera() {
		String encoded = Base64.getEncoder().encodeToString(this.imgOpera);
		return encoded;
	}

	public void setImgOpera(byte[] imgOpera) {
		this.imgOpera = imgOpera;
	}


}
