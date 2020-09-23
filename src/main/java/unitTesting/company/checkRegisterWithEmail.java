/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitTesting.company;

import Bean.CompanyBean;
import DAO.CompanyDao;
import static junit.framework.Assert.assertNotSame;
import org.junit.Test;

/**
 *
 * @author yasir
 */
public class checkRegisterWithEmail {
    
    CompanyDao companyDao = new CompanyDao();
    
    String tempXp[] = { "1", "2","6","9","4" };
    
    private final String email = "yasirusweearis@gmail.com";
    private final String name = "testfname";
    private final String password = "testpassword";
    private final String address = "testaddress";
    private final String mnumber = "testmnumber";
    private final String photo = "/img/company/company.jpg"; 
    
    CompanyBean testBean1 = new CompanyBean(name, email, password, address, mnumber, photo);
    CompanyBean testBean2 = new CompanyBean(name, null, password, address, mnumber, photo);

    @Test
    public void checkWithAlreadyExistEmail(){
   
        assertNotSame(1, (companyDao.add(testBean1)) );
    }
    
    @Test
    public void checkWithNullEmail(){
   
        assertNotSame(1, (companyDao.add(testBean2)) );
    }
}
