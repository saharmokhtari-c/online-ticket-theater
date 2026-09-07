package it.biglietteria.entity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.*;

@Entity
@Table(name = "teatri")
public class Teatro {
	
	@Id
	@Column(name="cod_teatro",nullable = false , length = 4)
	private String codTeatro;
	
	@Column(length = 30)
	private String nome;
	
	@Column(length = 40)
	private String indirizzo;
	
	@Column(length=25)
	private String citta;
	
	@Column(length = 2)
	private String provincia;
	
	@Column(length=14)
	private String telefono;
	
	@Column()
	private Integer posti;
	
	@OneToMany(mappedBy = "teatro",fetch = FetchType.LAZY)
	private List<Spettacolo> spettacoli = new ArrayList<>();
	
	public Teatro() {}
	public Teatro(String codTeatro, String nome, String indirizzo, String citta, String provincia, String telefono,
			Integer posti, List<Spettacolo> spettacoli) {
		
		this.codTeatro = codTeatro;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.provincia = provincia;
		this.telefono = telefono;
		this.posti = posti;
		this.spettacoli = spettacoli;
	}
	
	public String getCodTeatro() {
		return codTeatro;
	}
	public void setCodTeatro(String codTeatro) {
		this.codTeatro = codTeatro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Integer getPosti() {
		return posti;
	}
	public void setPosti(Integer posti) {
		this.posti = posti;
	}
	public List<Spettacolo> getSpettacoli() {
		return spettacoli;
	}
	public void setSpettacoli(List<Spettacolo> spettacoli) {
		this.spettacoli = spettacoli;
	}
	
	}
