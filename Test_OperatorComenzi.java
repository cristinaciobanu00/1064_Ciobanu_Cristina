package teste;

import static org.junit.Assert.*;

import org.junit.Test;
import command.Client;
import command.Cofetar;
import command.Comanda;
import command.ComandaTort;
import command.OperatorComenzi;
import exceptii.ExceptieListaGoala;
import exceptii.ExceptieNull;
import singleAndFactory.EnumTort;
import singleAndFactory.TortCiocolata;
import singleAndFactory.TortFrisca;

public class Test_OperatorComenzi {

	@Test
	public void test_preluareComanda_null() {
		
		try {
			OperatorComenzi operatorC = new OperatorComenzi();
			operatorC.preluareComanda(null);
			fail("Metoda accepta valoarea null!!!");
		} catch (ExceptieNull ex) {

		}
	}

	@Test
	public void test_trimitereComanda_null() {
		
		try {
			OperatorComenzi operatorC = new OperatorComenzi();
			operatorC.trimitereComandaCofetar(null);
			fail("Metoda accepta valoarea null!Comanda nu poate fi trimisa "
					+ "spre preparare unei persoane care nnu exista!!");
		} catch (ExceptieNull ex) {

		}
	}


	@Test
	public void test_trimitereComanda_verificareNumarElementeLista() {
		
		try {
			OperatorComenzi operatorC = new OperatorComenzi();
			operatorC.trimitereComandaCofetar(new Cofetar());
			fail("Metoda trimite spre preparare 0 comenzi!");
		} catch (ExceptieListaGoala ex) {

		}
	}


	@Test
	public void test_calculTotal() {

		OperatorComenzi operatorC = new OperatorComenzi();
		double total = operatorC.calculTotal();
		assertEquals(0, total, 0.1);
		operatorC.preluareComanda(new ComandaTort(new Cofetar(), EnumTort.CIOCOLATA, 0.7));
		assertEquals(TortCiocolata.PRET_KG * 0.7, operatorC.calculTotal(), 0.1);

	}

	@Test
	public void test_gramajTotal() {

		OperatorComenzi operatorC = new OperatorComenzi();
		assertEquals(0, operatorC.gramajComanda(), 0.1);
		operatorC.preluareComanda(new ComandaTort(new Cofetar(), EnumTort.CIOCOLATA, 0.7));
		operatorC.preluareComanda(new ComandaTort(new Cofetar(), EnumTort.FRISCA, 1.2));
		double gramajAsteptat = 1.2 + 0.7;
		double gramajReturnat = operatorC.gramajComanda();
		assertEquals(gramajAsteptat, gramajReturnat, 0.1);

	}

	
	@Test
	public void test_finalizareComanda_testTotal_1() {

		OperatorComenzi operatorC = new OperatorComenzi();
		assertEquals(0, operatorC.gramajComanda(), 0.1);
		operatorC.preluareComanda(new ComandaTort(new Cofetar(), EnumTort.CIOCOLATA, 0.7));
		operatorC.preluareComanda(new ComandaTort(new Cofetar(), EnumTort.FRISCA, 1.2));
		Client c = new Client("Ion", "adresa", "078111111", new Double(15));
		operatorC.setClient(c);
		double totalAsteptat = TortCiocolata.PRET_KG * 0.7 + TortFrisca.PRET_KG * 1.2 + 15;
		double totalReturnat = operatorC.finalizeazaComanda().getTotal();
		assertEquals(totalAsteptat, totalReturnat, 0.1);

	}

	@Test
	public void test_finalizareComanda_testTotal_2() {

		OperatorComenzi operatorC = new OperatorComenzi();
		assertEquals(0, operatorC.gramajComanda(), 0.1);
		operatorC.preluareComanda(new ComandaTort(new Cofetar(), EnumTort.CIOCOLATA, 0.7));
		operatorC.preluareComanda(new ComandaTort(new Cofetar(), EnumTort.FRISCA, 1.2));
		Client c = new Client("Ion", "adresa", "078111111", new Double(2));
		operatorC.setClient(c);
		double totalAsteptat = TortCiocolata.PRET_KG * 0.7 + TortFrisca.PRET_KG * 1.2;
		double totalReturnat = operatorC.finalizeazaComanda().getTotal();
		assertEquals(totalAsteptat, totalReturnat, 0.1);

	}

	
	@Test
	public void test_finalizareComanda_testTotal_3() {

		OperatorComenzi operatorC = new OperatorComenzi();
		assertEquals(0, operatorC.gramajComanda(), 0.1);
		operatorC.preluareComanda(new ComandaTort(new Cofetar(), EnumTort.CIOCOLATA, 0.7));
		operatorC.preluareComanda(new ComandaTort(new Cofetar(), EnumTort.FRISCA, 1.2));
		Client c = new Client("Ion", "adresa", "078111111", new Double(2));
		operatorC.setClient(c);
		double totalAsteptat = TortCiocolata.PRET_KG * 0.7 + TortFrisca.PRET_KG * 1.2;
		Comanda comanda = operatorC.finalizeazaComanda();
		double totalReturnat = comanda.getTotal();
		assertEquals(totalAsteptat, totalReturnat, 0.1);
		double gramajAsteptat = 1.2 + 0.7;
		double gramajReturnat = comanda.getGramaj();
		assertEquals(gramajAsteptat, gramajReturnat, 0.1);

	}

	@Test
	public void test_finalizareComanda_testTotal_4() {

		OperatorComenzi operatorC = new OperatorComenzi();
		assertEquals(0, operatorC.gramajComanda(), 0.1);
		operatorC.preluareComanda(new ComandaTort(new Cofetar(), EnumTort.CIOCOLATA, 0.7));
		operatorC.preluareComanda(new ComandaTort(new Cofetar(), EnumTort.FRISCA, 1.2));
		Client c = new Client("Ion", "adresa", "078111111", new Double(2));
		operatorC.setClient(c);
		double totalAsteptat = TortCiocolata.PRET_KG * 0.7 + TortFrisca.PRET_KG * 1.2;
		double gramajAsteptat = 1.2 + 0.7;
		Comanda comanda = operatorC.finalizeazaComanda();
		assertEquals(gramajAsteptat, comanda.getGramaj(), 0.1);
		assertEquals(totalAsteptat, comanda.getTotal(), 0.1);
		assertEquals(c, comanda.getClient());

	}

	
	@Test
	public void test_setNumeOperator() {

		try {
			OperatorComenzi operatorC = new OperatorComenzi();
			operatorC.setNumeOperator(null);
			fail("Metoda accepta valoarea null!!!");
		} catch (ExceptieNull ex) {

		}
	}

	

	@Test
	public void test_setClient() {

		try {
			OperatorComenzi operatorC = new OperatorComenzi();
			operatorC.setClient(null);
			fail("Metoda accepta valoarea null!!!");
		} catch (ExceptieNull ex) {

		}

	}
}
