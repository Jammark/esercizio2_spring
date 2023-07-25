package com.esercizio2spring.esercizio2spring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Tavolo {

	private int coperti, numero;
	private boolean occupato;

	public Tavolo(int coperti, int numero, boolean occupato) {
		super();
		this.coperti = coperti;
		this.numero = numero;
		this.occupato = occupato;
	}

}
