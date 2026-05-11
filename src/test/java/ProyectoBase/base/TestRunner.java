package ProyectoBase.base;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({	/* Ingresar los runners correspondiente a los diferentes tests a ejecutar */
	ProyectoBase.web.runners.WebBaseRunner.class
})
public class TestRunner {

}
