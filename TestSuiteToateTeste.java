package teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Test_Chain.class, Test_Client.class, Test_ComandaPlasata.class, Test_EfectuarePlata.class,
		Test_Facade.class, Test_Factory.class, Test_OperatorComenzi.class, Test_Singleton.class,
		TestSuiteCommandPattern.class })
public class TestSuiteToateTeste {

}
