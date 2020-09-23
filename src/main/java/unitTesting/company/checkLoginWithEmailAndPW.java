/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitTesting.company;

import DAO.CompanyDao;
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
        
        CompanyDao companydao = new CompanyDao();
        
        String userEmail = "yasiruswaris@gmail.com";
        String password = "12345";
        
        assertFalse(companydao.isValid(userEmail,password));
        
    }
    
    
    @Test
    public void ValidEmaiAndValidPW(){
        
        CompanyDao companydao = new CompanyDao();
        
        String userEmail = "yasiruswaris@gmail.com";
        String password = "123";
        
        assertTrue(companydao.isValid(userEmail,password));
        
    }
    
    @Test
    public void InvalidEmaiAndInvalidPW(){
        
        CompanyDao companydao = new CompanyDao();
        
        String userEmail = "yasiru@gmail.com";
        String password = "123";
        
        assertFalse(companydao.isValid(userEmail,password));
        
    }
    
    @Test
    public void InvalidEmaiAndValidPW(){
        
        CompanyDao companydao = new CompanyDao();
        
        String userEmail = "abcde";
        String password = "12345";
        
        assertFalse(companydao.isValid(userEmail,password));
        
    }
    
    
}
