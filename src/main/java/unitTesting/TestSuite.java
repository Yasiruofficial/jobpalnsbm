
package unitTesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

 
@RunWith(Suite.class)

@Suite.SuiteClasses({
    
   unitTesting.user.checkLoginWithEmailAndPW.class,
   unitTesting.user.checkRegisterWithEmail.class,
   unitTesting.company.checkLoginWithEmailAndPW.class,
   unitTesting.company.checkRegisterWithEmail.class
        
})

public class TestSuite {
    
}
