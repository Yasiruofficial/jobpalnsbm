package unitTesting.company;

import Bean.CompanyBean;
import DAO.CompanyDao;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

public class insertCompany {
        
    CompanyDao testDao = new CompanyDao();
    String tempXp[] = { "1", "2","6","9","4" };
    
    String name = "name";
    String email = "email";      
    String password = "password";      
    String address = "address";        
    String mnumber = "mnumber";        
    String logo = "images/company/company.jpg"; 
    
    CompanyBean testBean = new CompanyBean(name, email, password, address, mnumber, logo);   

    @Test
    public void check(){
   
        assertEquals(1, (testDao.add(testBean)) );
    }
}
