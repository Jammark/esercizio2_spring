package com.esercizio2spring.esercizio2_srping;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.esercizio2spring.esercizio2spring.model.Bevanda;
import com.esercizio2spring.esercizio2spring.model.Consumation;
import com.esercizio2spring.esercizio2spring.model.Ingrediente;
import com.esercizio2spring.esercizio2spring.model.IngredienteDecorator;
import com.esercizio2spring.esercizio2spring.model.Pizza;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

	@Value("${pomodoro}")
	private double prezzoPomodoro;

	@Value("${mozzarella}")
	private double prezzoMozzarella;

	@Value("${ananas}")
	private double prezzoAnanas;

	@Value("${prosciutto}")
	private double prezzoProsciutto;

	@Value("${funghi}")
	private double prezzoFunghi;

	@Value("${salame}")
	private double prezzoSalame;

	@Value("${mais}")
	private double prezzoMais;

	@Value("${acqua}")
	private double prezzoAcqua;

	@Value("${cola}")
	private double prezzoCola;

	@Value("${birra}")
	private double prezzoBirra;

	@Bean
	public Ingrediente getPomodoro() {
		return new Ingrediente("Pomodoro", this.prezzoPomodoro, 100);
	}

	@Bean
	public Ingrediente getMozzarella() {
		return new Ingrediente("Mozzarella", this.prezzoMozzarella, 140);
	}

	@Bean
	public Ingrediente getAnanas() {
		return new Ingrediente("Ananas", this.prezzoAnanas, 200);
	}

	@Bean
	public Ingrediente getProsciutto() {
		return new Ingrediente("Prosciutto cotto", this.prezzoProsciutto, 300);
	}

	@Bean
	public Ingrediente getFunghi() {
		return new Ingrediente("funghi", this.prezzoFunghi, 400);
	}

	@Bean
	public Ingrediente getMais() {
		return new Ingrediente("mais", this.prezzoMais, 400);
	}

	@Bean
	public Ingrediente getSalame() {
		return new Ingrediente("salame piccante", this.prezzoSalame, 500);
	}

	@Bean
	public Bevanda getCola() {
		return new Bevanda("Pepsi", this.prezzoCola);
	}

	@Bean
	public Bevanda getAcqua() {
		return new Bevanda("Acqua Minerale", this.prezzoAcqua);
	}

	@Bean
	public Bevanda getBirra() {
		return new Bevanda("Heineken", this.prezzoBirra);
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
