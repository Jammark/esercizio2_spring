package com.esercizio2spring.esercizio2spring.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Ordine {

	private LocalDate acquisizione;
	private List<Consumation> consumazioni;
	private Tavolo tavolo;
	private int numero, coperti;

	public Ordine(LocalDate acquisizione, List<Consumation> consumazioni, Tavolo tavolo, int numero, int coperti) {
		super();
		this.acquisizione = acquisizione;
		this.consumazioni = consumazioni;
		this.tavolo = tavolo;
		this.numero = numero;
		this.coperti = coperti;
	}

	public double getTotale() {
		return this.coperti * getCoperto()
				+ consumazioni.stream().map(Consumation::getPrice).reduce(0.0, (val1, val2) -> val1 + val2);
	}

	private double getCoperto() {
		return 2.0;
	}

	@Override
	public String toString() {
		return "Ordine [acquisizione=" + acquisizione + ", consumazioni=["
				+ consumazioni.stream().map(Consumation::getName).collect(Collectors.joining(",")) + "], tavolo="
				+ tavolo + ", numero=" + numero + ", coperti=" + coperti + ", getTotale()=" + getTotale() + "]";
	}

}
