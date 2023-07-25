package com.esercizio2spring.esercizio2_srping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.esercizio2spring.esercizio2spring.model.Bevanda;
import com.esercizio2spring.esercizio2spring.model.Consumation;
import com.esercizio2spring.esercizio2spring.model.Ingrediente;
import com.esercizio2spring.esercizio2spring.model.Ordine;
import com.esercizio2spring.esercizio2spring.model.PizzaDecorator;
import com.esercizio2spring.esercizio2spring.model.Tavolo;
import com.esercizio2spring.esercizio2spring.model.ToppingDecorator;

@SpringBootTest
class Esercizio2SrpingApplicationTests {

	private static AnnotationConfigApplicationContext ctx;

	@BeforeAll
	static void start() {
		ctx = new AnnotationConfigApplicationContext(Esercizio2SrpingApplication.class);
	}

	@Test
	void contextLoads() {

		Tavolo t = new Tavolo(4, 3, false);
		Ordine o = new Ordine(LocalDate.now(),
				new ArrayList<>(Arrays.asList(
						new ToppingDecorator((PizzaDecorator) ctx.getBean("getHawaiana"),
								(Ingrediente) ctx.getBean("getSalame")),
						(PizzaDecorator) ctx.getBean("getCottoEFunghi"), (Bevanda) ctx.getBean("getBirra"))),
				t, 10, 2);

		double tot = o.getCoperti() * 2.0
				+ o.getConsumazioni().stream().map(Consumation::getPrice).reduce(0.0, (sum, val) -> sum + val);
		assertEquals(o.getTotale(), tot);

	}

	@AfterAll
	static void end() {
		ctx.close();
	}

}
