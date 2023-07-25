package com.esercizio2spring.esercizio2spring.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IngredienteDecorator extends PizzaDecorator {

	private Ingrediente ingrediente;

	public IngredienteDecorator(Consumation campo, Ingrediente ingrediente) {
		super(campo.getName(), campo);
		this.ingrediente = ingrediente;
	}

	@Override
	public double getPrice() {

		return super.getPrice() + ingrediente.getPrice();
	}

	@Override
	protected Ingrediente[] ingredienti() {
		if (getCampo() instanceof IngredienteDecorator) {
			IngredienteDecorator id = (IngredienteDecorator) getCampo();
			List<Ingrediente> lista = new ArrayList<>(Arrays.asList(id.ingredienti()));
			lista.add(this.ingrediente);
			return lista.toArray(new Ingrediente[0]);
		} else {
			return new Ingrediente[] { this.ingrediente };
		}

	}

	@Override
	public String toString() {
		return this.getName() + " ("
				+ Arrays.asList(this.ingredienti()).stream().map(i -> i.getName()).collect(Collectors.joining(","))
				+ ")";
	}

	@Override
	public int getCalorie() {

		return Arrays.asList(ingredienti()).stream().map(Ingrediente::getCalorie)
				.reduce((subtotal, element) -> subtotal + element).orElseThrow();
	}

}
