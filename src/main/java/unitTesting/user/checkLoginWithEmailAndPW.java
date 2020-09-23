/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitTesting.user;

import DAO.UserDao;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author yasir
 */
public class checkLoginWithEmailAndPW {
    
    @Test
    public void ValidEmaiAndInvalidPW(){
        
        UserDao userdao = new UserDao();
        
        String userEmail = "yasiruswaris@gmail.com";
        String password = "12345";
        
        assertFalse(userdao.isValid(userEmail,password));
        
    }
    
    
    @Test
    public void ValidEmaiAndValidPW(){
        
        UserDao userdao = new UserDao();
        
        String userEmail = "yasiruswaris@gmail.com";
        String password = "123";
        
        assertTrue(userdao.isValid(userEmail,password));
        
    }
    
    @Test
    public void InvalidEmaiAndInvalidPW(){
        
        UserDao userdao = new UserDao();
        
        String userEmail = "yasiru@gmail.com";
        String password = "123";
        
        assertFalse(userdao.isValid(userEmail,password));
        
    }
    
    @Test
    public void InvalidEmaiAndValidPW(){
        
        UserDao userdao = new UserDao();
        
        String userEmail = "abcde";
        String password = "12345";
        
        assertFalse(userdao.isValid(userEmail,password));
        
    }
    
    
}
