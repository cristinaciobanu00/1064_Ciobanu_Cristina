package teste;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import exceptii.ExceptieNull;
import exceptii.ExceptieNumarNegativ;
import strategy.EfectuarePlata;
import strategy.PlataCard;
import strategy.PlataRamburs;

public class Test_EfectuarePlata {
	private final ByteArrayOutputStream redirectSyso = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(redirectSyso));

	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);

	}

	@Test
	public void test_constructor1() {
		try {
			EfectuarePlata efectuarePlata = new EfectuarePlata(null, null);
			fail("Constructorul accepta null!");
		} catch (ExceptieNull ex) {

		}

	}

	@Test
	public void test_setTotal() {

		try {
			EfectuarePlata efectuarePlata = new EfectuarePlata();
			efectuarePlata.setTotal(null);
			fail("Metoda setTotal  accepta null!");
		} catch (ExceptieNull ex) {

		}
	}

	@Test
	public void test_setTotal_valoriNegative() {

		try {
			EfectuarePlata efectuarePlata = new EfectuarePlata();
			efectuarePlata.setTotal(new Double(-2.3));
			fail("Metoda setTotal  accepta valori negative!");
		} catch (ExceptieNumarNegativ ex) {

		}
	}

	@Test
	public void test_setModalitatePlata() {

		try {
			EfectuarePlata efectuarePlata = new EfectuarePlata();
			efectuarePlata.setModalitatePlata(null);
			fail("Metoda setModalitatePlata  accepta null!");
		} catch (ExceptieNull ex) {

		}
	}

	@Test
	public void test_efectueazaPlata_valoareNull() {

		try {
			EfectuarePlata efectuarePlata = new EfectuarePlata();
			efectuarePlata.efectueazaPlata();
			fail("Metoda nu testeaza daaca modalitatePlata si total sunt setate");
		} catch (ExceptieNull ex) {

		}

	}

	@Test
	public void test_efectueazaPlata_functionareCorecta_Card() {

		EfectuarePlata plata = new EfectuarePlata();
		plata.setTotal(new Double(2));
		plata.setModalitatePlata(new PlataCard());
		plata.efectueazaPlata();
		assertEquals("Comanda in valoare de  " + plata.getTotal() + " va fi achitata folosind cardul!",
				redirectSyso.toString());
	}

	@Test
	public void test_efectueazaPlata_functionareCorecta_Cash() {

		EfectuarePlata plata = new EfectuarePlata();
		plata.setTotal(new Double(2));
		plata.setModalitatePlata(new PlataRamburs());
		plata.efectueazaPlata();
		assertEquals("Comanda in valoare de  " + plata.getTotal() +
				" va fi achitata cash!", redirectSyso.toString());
	}
}
