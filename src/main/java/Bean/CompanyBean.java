package Bean;

import java.io.Serializable;

public class CompanyBean implements Serializable{
    
    private String name;
    private String email;
    private String password;
    private String address;
    private String mnumber;
    private String logo;

    public CompanyBean() {
        
        this.name = null;
        this.email = null;
        this.password = null;
        this.address = null;
        this.mnumber = null;
        this.logo = null;
        
    }
    
    public CompanyBean(String name, String email, String password, String address, String mnumber, String logo) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.mnumber = mnumber;
        this.logo = logo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMnumber() {
        return mnumber;
    }

    public void setMnumber(String mnumber) {
        this.mnumber = mnumber;
    }
    
    

}
