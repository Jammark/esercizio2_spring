package com.esercizio2spring.esercizio2spring.model;

public abstract class Consumation {

	private String name;

	public Consumation(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public abstract double getPrice();

}
