
package unitTesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import unitTesting.user.checkLoginWithEmailAndPW;
import unitTesting.user.checkRegisterWithEmail;

 
@RunWith(Suite.class)

@Suite.SuiteClasses({
    
   checkRegisterWithEmail.class,
   checkLoginWithEmailAndPW.class
        
})

public class TestSuite {
    
}
