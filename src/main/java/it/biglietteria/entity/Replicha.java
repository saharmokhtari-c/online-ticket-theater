package it.biglietteria.entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "repliche")

public class Replicha {
	
	@Id
	@Column(nullable = false,length = 4)
	private String codreplica;
	
	@ManyToOne
	@JoinColumn(name="spettacolo_cod_spettacolo",nullable = false)
	@JsonIgnoreProperties("repliche")

	private Spettacolo spettacolo;
	
	@OneToMany(mappedBy ="replicha", fetch = FetchType.EAGER)
	private List<Biglietto> biglietti = new ArrayList<>();
			@JsonIgnoreProperties("repliche")		
	
	@Column(name="data_replica",nullable = false ,length = 10)
	private String dataReplica;

	public Replicha() {}
	public Replicha(String codreplica, Spettacolo spettacolo, String dataReplica) {
		
		this.codreplica = codreplica;
		this.spettacolo = spettacolo;
		this.dataReplica = dataReplica;
	
	
	
	

}
	public String getCodreplica() {
		return codreplica;
	}
	public void setCodreplica(String codreplica) {
		this.codreplica = codreplica;
	}
	public Spettacolo getSpettacolo() {
		return spettacolo;
	}
	public void setSpettacolo(Spettacolo spettacolo) {
		this.spettacolo = spettacolo;
	}
	public List<Biglietto> getBiglietti() {
		return biglietti;
	}
	public void setBiglietti(List<Biglietto> biglietti) {
		this.biglietti = biglietti;
	}
	public String getDataReplica() {
		return dataReplica;
	}
	public void setDataReplica(String dataReplica) {
		this.dataReplica = dataReplica;
	}
}