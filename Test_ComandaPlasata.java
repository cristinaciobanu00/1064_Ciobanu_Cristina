package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import command.Client;
import exceptii.ExceptieListaGoala;
import exceptii.ExceptieNull;
import observer.ComandaPlasata;

public class Test_ComandaPlasata {

	@Test
	public void test_adauga() {

		try {
			ComandaPlasata cPlasata = new ComandaPlasata();
			cPlasata.adaugaObservator(null);
			fail("Nu poti introduce un observator null!");
		} catch (ExceptieNull ex) {

		}
	}

	@Test
	public void test_sterge_null() {

		try {
			ComandaPlasata cPlasata = new ComandaPlasata();
			cPlasata.stergeObservator(null);
			fail("Metoda nu trebuie sa accepte null!!!!!");
		} catch (ExceptieNull ex) {

		}
	}

	@Test
	public void test_sterge_listaGoala() {

		try {
			ComandaPlasata cPlasata = new ComandaPlasata();
			cPlasata.stergeObservator(new Client());
			fail("Metoda nu poate sterge dintr-o lista goala!!!!!");
		} catch (ExceptieListaGoala ex) {

		}
	}

	@Test
	public void test_anunta() {

		try {
			ComandaPlasata cPlasata = new ComandaPlasata();
			cPlasata.anunta(null);
			fail("Metoda nu trebuie sa accepte null!!!!!");
		} catch (ExceptieNull ex) {

		}
	}

	@Test
	public void test_adaugaComanda() {

		try {
			ComandaPlasata cPlasata = new ComandaPlasata();
			cPlasata.adaugaComanda(null);
			fail("Metoda nu trebuie sa accepte null!!!!!");
		} catch (ExceptieNull ex) {

		}
	}

}
