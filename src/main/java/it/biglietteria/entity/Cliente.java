package it.biglietteria.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "clienti")

public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_cliente")
	private Integer codCliente;
	
   @ Column(nullable = false , length = 20)
    private String cognome;
	
	@ Column (nullable = false , length = 20)
	private String nome;
	
	@Column(nullable = false , length = 14)
	private String telefono;
	
	@Column(nullable = false , length = 30)
	private String email;
	
	@OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY)
	private List<Biglietto> biglietti = new ArrayList<>();

	public Cliente() {}
	public Cliente(Integer codCliente, String cognome, String nome, String telefono, String email) {
		
		this.codCliente = codCliente;
		this.cognome = cognome;
		this.nome = nome;
		this.telefono = telefono;
		this.email = email;
	}
	public Integer getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Biglietto> getBiglietti() {
		return biglietti;
	}
	public void setBiglietti(List<Biglietto> biglietti) {
		this.biglietti = biglietti;
	}
	
	
	

}
