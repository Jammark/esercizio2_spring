package com.esercizio2spring.esercizio2spring.model;

import lombok.Getter;

@Getter
public class Pizza extends Consumation {

	private int calorie;

	public Pizza(String name, int calorie) {
		super(name);
		this.calorie = calorie;

	}

	@Override
	public double getPrice() {

		return 5.0;
	}

	@Override
	public String toString() {
		return "Pizza [getName()=" + getName() // + " -Pizza con "
		// +
		// Arrays.asList(this.getCampi()).stream().map(Consumation::getName).collect(Collectors.joining("
		// , "))
				+ "]";
	}

}
