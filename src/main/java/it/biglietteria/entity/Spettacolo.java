package it.biglietteria.entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "spettacoli")
public class Spettacolo {
	
	@Id
	@Column(name="cod_spettacolo",nullable = false , length = 4)
	private String codSpettacolo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties("spettacoli")
	@JoinColumn(name="teatro_cod_teatro",nullable = false)
	
	private Teatro teatro;
	
	@OneToMany(mappedBy = "spettacolo" , fetch = FetchType.LAZY)
	private List<Replicha> repliche = new ArrayList<>();
	
	@Column(length = 40)
	private String titolo;
	
	@Column(length = 25)
	private String autore;
	
	@Column(length = 25)
	private String regista;
	
	@Column()
	private BigDecimal prezzo;

	public Spettacolo() {}
	
	
	
	
	public Spettacolo(String codSpettacolo, Teatro teatro, String titolo, String autore, String regista,
			BigDecimal prezzo) {
		
		this.codSpettacolo = codSpettacolo;
		this.teatro = teatro;
		this.titolo = titolo;
		this.autore = autore;
		this.regista = regista;
		this.prezzo = prezzo;
	}




	public String getCodSpettacolo() {
		return codSpettacolo;
	}




	public void setCodSpettacolo(String codSpettacolo) {
		this.codSpettacolo = codSpettacolo;
	}




	public Teatro getTeatro() {
		return teatro;
	}




	public void setTeatro(Teatro teatro) {
		this.teatro = teatro;
	}




	public List<Replicha> getRepliche() {
		return repliche;
	}




	public void setRepliche(List<Replicha> repliche) {
		this.repliche = repliche;
	}




	public String getTitolo() {
		return titolo;
	}




	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}




	public String getAutore() {
		return autore;
	}




	public void setAutore(String autore) {
		this.autore = autore;
	}




	public String getRegista() {
		return regista;
	}




	public void setRegista(String regista) {
		this.regista = regista;
	}




	public BigDecimal getPrezzo() {
		return prezzo;
	}




	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	
	
	
	
}
