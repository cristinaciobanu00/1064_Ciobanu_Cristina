package teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Test_Client.class, Test_EfectuarePlata.class })
public class TestSuiteStrategyPattern {

}
