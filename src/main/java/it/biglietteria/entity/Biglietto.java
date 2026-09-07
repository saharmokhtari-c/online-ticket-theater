package it.biglietteria.entity;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "biglietti")
public class Biglietto {
@Id
@Column(name="cod_operazione",nullable = false , length = 4)
private String codOperazione;

@ManyToOne
@JoinColumn(name="cliente_cod_cliente",nullable = false)
@JsonIgnoreProperties("biglietti")

private Cliente cliente;

@ManyToOne
@JoinColumn(name="replicha_codreplica",nullable = false)
@JsonIgnoreProperties("biglietti")

private Replicha replicha;

@Column(name="data_ora",length = 20)
private LocalDateTime dataOra;

@Column(name ="tipo_pagamento",length = 20)
private String tipoPagamento;

@Column(nullable = false)
private Integer quantita;

public Biglietto() {}

public Biglietto(String codOperazione, Cliente cliente, Replicha replica, LocalDateTime dataOra, String tipoPagamento,
		Integer quantita) {
	
	this.codOperazione = codOperazione;
	this.cliente = cliente;
	this.replicha = replica;
	this.dataOra = dataOra;
	this.tipoPagamento = tipoPagamento;
	this.quantita = quantita;
}

public String getCodOperazione() {
	return codOperazione;
}

public void setCodOperazione(String codOperazione) {
	this.codOperazione = codOperazione;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public Replicha getReplicha() {
	return replicha;
}

public void setReplicha(Replicha replicha) {
	this.replicha = replicha;
}

public LocalDateTime getDataOra() {
	return dataOra;
}

public void setDataOra(LocalDateTime dataOra) {
	this.dataOra = dataOra;
}

public String getTipoPagamento() {
	return tipoPagamento;
}

public void setTipoPagamento(String tipoPagamento) {
	this.tipoPagamento = tipoPagamento;
}

public Integer getQuantita() {
	return quantita;
}

public void setQuantita(Integer quantita) {
	this.quantita = quantita;
}





}


