package Bean;

import java.io.Serializable;


public class UserBean implements Serializable{
    
    private String email;
    private String fname;
    private String lname;
    private String password;
    private String address;
    private String mnumber;
    private String gender;
    private String bday;
    private String exyears;
    private String[] experience;
    private String photo;

    public UserBean() {
        this.email = null;
        this.fname = null;
        this.lname = null;
        this.password = null;
        this.address = null;
        this.mnumber = null;
        this.gender = null;
        this.bday = null;
        this.exyears = null;
        this.experience = null;
        this.photo = null;
    }
    
    public UserBean(String email, String fname, String lname, String password, String address, String mnumber, String gender, String bday, String exyears, String[] experience, String photo) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.address = address;
        this.mnumber = mnumber;
        this.gender = gender;
        this.bday = bday;
        this.exyears = exyears;
        this.experience = experience;
        this.photo = photo;
    }


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public String getExyears() {
        return exyears;
    }

    public void setExyears(String exyears) {
        this.exyears = exyears;
    }

    public String[] getExperience() {
        return experience;
    }

    public void setExperience(String[] experience) {
        this.experience = experience;
    }

}
