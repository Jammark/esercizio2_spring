package com.esercizio2spring.esercizio2_srping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.esercizio2spring.esercizio2spring.model.Bevanda;
import com.esercizio2spring.esercizio2spring.model.Consumation;
import com.esercizio2spring.esercizio2spring.model.Ingrediente;
import com.esercizio2spring.esercizio2spring.model.IngredienteDecorator;
import com.esercizio2spring.esercizio2spring.model.Pizza;

@Configuration
public class AppConfig {

	@Bean
	public Ingrediente getPomodoro() {
		return new Ingrediente("Pomodoro", 0.50, 100);
	}

	@Bean
	public Ingrediente getMozzarella() {
		return new Ingrediente("Mozzarella", 1.00, 140);
	}

	@Bean
	public Ingrediente getAnanas() {
		return new Ingrediente("Ananas", 2.00, 200);
	}

	@Bean
	public Ingrediente getProsciutto() {
		return new Ingrediente("Prosciutto cotto", 1.00, 300);
	}

	@Bean
	public Ingrediente getFunghi() {
		return new Ingrediente("funghi", 2.00, 400);
	}

	@Bean
	public Ingrediente getMais() {
		return new Ingrediente("mais", 2.50, 400);
	}

	@Bean
	public Ingrediente getSalame() {
		return new Ingrediente("salame piccante", 3.00, 500);
	}

	@Bean
	public Bevanda getCola() {
		return new Bevanda("Pepsi", 3.0);
	}

	@Bean
	public Bevanda getAcqua() {
		return new Bevanda("Acqua Minerale", 1.50);
	}

	@Bean
	public Bevanda getBirra() {
		return new Bevanda("Heineken", 4.0);
	}

	@Bean
	public Consumation getHawaiana() {
		return new IngredienteDecorator(new IngredienteDecorator(new IngredienteDecorator(
				new IngredienteDecorator(new Pizza("Hawaiana", 1200), getAnanas()), getProsciutto()), getPomodoro()),
				getMozzarella());
	}

	@Bean
	public Consumation getCottoEFunghi() {
		return new IngredienteDecorator(new IngredienteDecorator(
				new IngredienteDecorator(new IngredienteDecorator(new Pizza("Cotto e funghi", 900), getFunghi()),
						getProsciutto()),
				getPomodoro()), getMozzarella());

	}

	@Bean
	public Consumation getDiavola() {
		return

		new IngredienteDecorator(new IngredienteDecorator(
				new IngredienteDecorator(new Pizza("Diavola", 1100), getSalame()), getPomodoro()), getMozzarella());

	}

	@Bean
	public Consumation getMaisECotto() {
		return new IngredienteDecorator(new IngredienteDecorator(new IngredienteDecorator(
				new IngredienteDecorator(new Pizza("Mais e cotto", 800), getMais()), getProsciutto()), getPomodoro()),
				getMozzarella());

	}
}
