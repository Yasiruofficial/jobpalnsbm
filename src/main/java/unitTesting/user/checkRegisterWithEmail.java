/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitTesting.user;

import Bean.UserBean;
import DAO.UserDao;
import static junit.framework.Assert.assertNotSame;
import org.junit.Test;

/**
 *
 * @author yasir
 */
public class checkRegisterWithEmail {
    
    UserDao userdao = new UserDao();
    String tempXp[] = { "1", "2","6","9","4" };
    
    private final String email = "yasirusweearis@gmail.com";
    private final String fname = "testfname";
    private final String lname = "testlname";
    private final String password = "testpassword";
    private final String address = "testaddress";
    private final String mnumber = "testmnumber";
    private final String gender = "testgender";
    private final String bday = "30-20-2014";
    private final String exyears = "20";
    private final String[] experience = tempXp ;
    private final String photo = "/img/user/male.jpg"; 
    
    UserBean testBean1 = new UserBean( email, fname, lname, password, address, mnumber, gender, bday, exyears, experience, photo);
    UserBean testBean2 = new UserBean( null, fname, lname, password, address, mnumber, gender, bday, exyears, experience, photo);

    @Test
    public void checkWithAlreadyExistEmail(){
   
        assertNotSame(1, (userdao.add(testBean1)) );
    }
    
    @Test
    public void checkWithNullEmail(){
   
        assertNotSame(1, (userdao.add(testBean2)) );
    }
}
