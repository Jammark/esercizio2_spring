package com.esercizio2spring.esercizio2spring.model;

import lombok.Getter;

@Getter
public abstract class PizzaDecorator extends Consumation {

	private Consumation campo;

	public PizzaDecorator(String name, Consumation campo) {
		super(name);
		this.campo = campo;
	}

	@Override
	public double getPrice() {

		return campo.getPrice();
	}



	protected abstract Ingrediente[] ingredienti();

	public abstract int getCalorie();

}
