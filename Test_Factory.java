package teste;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import exceptii.ExceptieNull;
import singleAndFactory.EnumTort;
import singleAndFactory.ITort;
import singleAndFactory.TortCiocolata;
import singleAndFactory.TortFactory;
import singleAndFactory.TortFrisca;
import singleAndFactory.TortFructe;

public class Test_Factory {

	// 1-verificare daca metoda returneaza un obiect de tipul dorit
	@Test
	public void test_factoryObiectReturnat() {
		
		ITort tortCiocolata = TortFactory.getTort(EnumTort.CIOCOLATA, 0.5);
		Assert.assertTrue(tortCiocolata instanceof TortCiocolata);
	}

	//2-testeaza daca metoda accepta valoarea null
	@Test
	public void test_factory_NullTipTort() {
		
		try {
			ITort tort = TortFactory.getTort(null, 0.5);
			fail("Nu a fost tratat cazul cu null!");
		} catch (ExceptieNull ex) {

		}

	}
	// 3-verificare daca metoda arunca o exceptie atunci cand se introduce un alt tip de tort, altul decat cele 
	//pe care cofetaria le produce
	@Test
	public void test_factoryAruncareExceptie() {
		
		try {
			ITort tort = TortFactory.getTort(EnumTort.TIRAMISU, 0.5);
			fail("Tip tort netratat!");

		} catch (UnsupportedOperationException ex) {

		}

	}
	
	//4-testare daca metoda trateaza cazul in care se introduce gramajul tortului este null
	
	@Test
	public void test_factoryGramajNull() {
		
		try {
			ITort tort =  TortFactory.getTort(EnumTort.FRISCA, null);
			fail("Nu ai tratat cazul in care se introduce valoarea null!");
		} catch (ExceptieNull ex) {

		}

	}
	// 5-testare daca metoda returneaza corect gramajul tortului
	@Test
	public void test_factoryGramajTort() {

		TortFrisca tort = (TortFrisca) TortFactory.getTort(EnumTort.FRISCA, 1.3);
		Assert.assertEquals(1.3, tort.getGramaj(), 0.1);

	}




	// 6-testare daca metoda verifica gramajul tortului(nu putem avea un tort de -5 kg)
	@Test
	public void test_factoryGramajNegativ() {
		
		try {
			ITort tortCiocolata = TortFactory.getTort(EnumTort.CIOCOLATA, -0.5);
			fail("Nu ai luat in calcul cazul in care se introduc valori negative!!!!");
		} catch (UnsupportedOperationException ex) {

		}

	}

	// 7-testare daca metoda getPret() returneaza valoarea corecta
	
	@Test
	public void test_pretTort_CrossCheck() {
		
		double cantitate = 1.6;
		TortFructe tort = new TortFructe(1.6);
		assertEquals("Testare metoda getPret()", 1.6 * TortFructe.PRET_KG, tort.getPret(), 0.1);

	}

	


}
