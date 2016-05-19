package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import main.AplicatieComenzi;

public class Test_Singleton {

	@Test
	public void test_singleton1() {
		assertSame(AplicatieComenzi.getInstance("Cofetaria mea"), AplicatieComenzi.getInstance("Cofetaria mea"));
	}

	@Test
	public void test_singleton2() {

		AplicatieComenzi instanta1 = AplicatieComenzi.getInstance("Cofetaria mea");
		AplicatieComenzi instanta2 = AplicatieComenzi.getInstance("Cofetarie 2");
		assertEquals("Cofetaria mea", instanta2.getTitlu());
	}

}
