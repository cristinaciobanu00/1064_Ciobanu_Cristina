package teste;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chain.Motociclist;
import chain.SoferMasina;
import command.Client;
import command.Comanda;
import exceptii.ExceptieNull;

public class Test_Chain {

	private final ByteArrayOutputStream redirectSyso = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(redirectSyso));

	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);

	}

	// 1-testare daca metoda setNume poate primi valoarea null
	@Test
	public void test_setNume_valoareNull() {

		try {

			Motociclist motociclist = new Motociclist();
			motociclist.setNume(null);
			fail("Metoda accepta nume null!");

		} catch (ExceptieNull ex) {

		}

	}

	// 2- testare daca metoda gestioneazaComanda poate primi valoarea null
	@Test
	public void test_gestioneazaComanda_comandaNull() {

		try {
			Motociclist motociclist = new Motociclist();
			motociclist.gestioneazaComanda(null);
			fail("Metoda accepta comanda null!");

		} catch (ExceptieNull ex) {

		}

	}

	// 3- testeaza corectitudinii metodei de chain, daca problema este rezolvata de persoana competenta

	@Test
	public void test_gestioneazaComanda_corectitudine() {

		Motociclist motociclist1 = new Motociclist();
		motociclist1.setNume("Motociclist");
		SoferMasina sofer1 = new SoferMasina();
		sofer1.setNume("Sofer2");
		motociclist1.setareSuccesor(sofer1);
		Client client = new Client("Costica", "adresa", "00232102102", new Double(32));
		Comanda comanda1 = new Comanda(client, 210.1, 5.2);
		motociclist1.gestioneazaComanda(comanda1);
		assertEquals("Curierul " + sofer1.getNume() + " va livra comanda utilizand o masina!", redirectSyso.toString());

	}

}
