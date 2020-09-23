
package unitTesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import unitTesting.user.addAlreadyExistUser;
import unitTesting.user.addUserWithoutEmail;
 
@RunWith(Suite.class)

@Suite.SuiteClasses({
   addAlreadyExistUser.class,
   addUserWithoutEmail.class
})

public class TestSuite {
    
}
