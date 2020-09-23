package unitTesting;

import DAO.UserJobsDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Test {

    
    public static void main(String[] args) {
        
        Result result = JUnitCore.runClasses(TestSuite.class);

      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
      
    }
    
}
