package teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import exceptii.ExceptieListaGoala;
import exceptii.ExceptieNull;
import exceptii.ExceptieNumarNegativ;
import main.Facade;
import main.Produs;
import singleAndFactory.EnumTort;

public class Test_Facade {

	
	@Test
	public void test_adaugaComanda_valoriNull() {
		
		try{
			Facade facade=new Facade();
			facade.adaugaComanda(null, null, null, null, null, null);
			fail("Metoda nu trateaza cazul in care valorile introduse sunt null");
		}
		catch(ExceptieNull ex){
			
			
		}
	}
	
	@Test
	public void test_adaugaComanda_parametruDistanta() {
		
		try{
			Facade facade=new Facade();
			facade.adaugaComanda("Crstina", "matei b", "0784613666",
					new Double(-2), new ArrayList<Produs>(), "modalitate");
			fail("Metoda nu trateaza cazul in care distanta este negativa");
		}
		catch(ExceptieNumarNegativ ex){
			
			
		}
	}
	
	
	@Test
	public void test_adaugaComanda_listaProduseGoala() {
		
		try{
			Facade facade=new Facade();
			facade.adaugaComanda("Crstina", "matei b", "0784613666", 
					new Double(2), new ArrayList<Produs>(), "modalitate");
			fail("Metoda nu trateaza cazul in care distanta este negativa");
		}
		catch(ExceptieListaGoala ex){
			
			
		}
	}
	
	@Test
	public void test_modalitatePlata() {
		
		try{
			Facade facade=new Facade();
			List<Produs> produse=new ArrayList<Produs>();
			produse.add(new Produs(EnumTort.CIOCOLATA, 2));
			facade.adaugaComanda("Crstina", "matei b", "0784613666", new Double(22),produse , "mod");
			fail("Metoda nu trateaza cazul in care modalitatea de plata nu este definita");
		}
		catch(UnsupportedOperationException ex){
			
			
		}
	}
	
}
