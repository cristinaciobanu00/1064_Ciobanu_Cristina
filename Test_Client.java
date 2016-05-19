package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import command.Client;
import exceptii.ExceptieNull;
import exceptii.ExceptieNumarNegativ;

public class Test_Client {

	// 1-testare metoda setNume
	@Test
	public void test_setNume_null() {

		try {
			Client c = new Client();
			c.setNume(null);
			fail("Metoda setNume accepta valoarea null!");
		} catch (ExceptieNull ex) {

		}
	}

	// 2-testare metoda setAdresa
	@Test
	public void test_setAdresa_null() {
		
		try {
			Client c = new Client();
			c.setAdresa(null);
			fail("Metoda setAdresa accepta valoarea null!");
		} catch (ExceptieNull ex) {

		}
	}

	// 3-testare metoda setNrTelefon
	@Test
	public void test_setTelefon_null() {
		
		try {
			Client c = new Client();
			c.setNumarTelefon(null);
			fail("Metoda setNrTelefon accepta valoarea null!");
		} catch (ExceptieNull ex) {

		}
	}

	// 4-testare metoda setNrKm
	@Test
	public void test_setNrKm_null() {
		
		try {
			Client c = new Client();
			c.setDistantaKm(null);
			fail("Metoda setDistantaKm accepta valoarea null!");
		} catch (ExceptieNull ex) {

		}
	}

	// 5-testare metoda setNrKm nu trebuie sa accepte valori mai mici sau egale
	// cu O
	@Test
	public void test_setNrKm_valoriNegative() {
		
		try {
			Client c = new Client();
			c.setDistantaKm(new Double(-3));
			fail("Metoda setDistantaKm accepta valori negative!");
		} catch (ExceptieNumarNegativ ex) {

		}
	}

	// 6-testare constructor
	@Test
	public void test_constructor_parametruNull() {
		
		try {
			Client c = new Client(null, null, "064828181", null);

			fail("Constructorul accepta null!");
		} catch (ExceptieNull ex) {

		}
	}

	// 7-testare constructor
	@Test
	public void test_constructor_parametruDistantaNegativ() {
		
		try {
			Client c = new Client("Cris", "Buc", "064828181", new Double(-10));

			fail("Constructorul accepta distante negative!");
		} catch (ExceptieNumarNegativ ex) {

		}
	}

	// 8-testare metoda notifica

	@Test
	public void test_notifica_mesajNull() {
		
		try {
			Client c = new Client();
			c.notifica(null);
			fail("Metoda accepta valori null");
		} catch (ExceptieNull ex) {

		}
	}

}
