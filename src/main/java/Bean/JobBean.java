package Bean;

import java.io.Serializable;

public class JobBean implements Serializable{
    
    private int jobid;
    private String name;
    private String image;
    private String street;
    private String district;
    private String type;
    private String category;
    private String publisheddate;
    private String vacancy;
    private String salary;
    private String gender;
    private String applicationdeadline;
    private String description;
    private String responsibility1;
    private String responsibility2;
    private String responsibility3;
    private String responsibility4;
    private String eduexperience1;
    private String eduexperience2;
    private String eduexperience3;
    private String eduexperience4;
    private int cid;

    public JobBean() {
        this.jobid = 0;
        this.name = null;
        this.image = null;
        this.street = null;
        this.district = null;
        this.type = null;
        this.category = null;
        this.publisheddate = null;
        this.vacancy = null;
        this.salary = null;
        this.gender = null;
        this.applicationdeadline = null;
        this.description = null;
        this.responsibility1 = null;
        this.responsibility2 = null;
        this.responsibility3 = null;
        this.responsibility4 = null;
        this.eduexperience1 = null;
        this.eduexperience2 = null;
        this.eduexperience3 = null;
        this.eduexperience4 = null;
        this.cid = 0;
    }
    
      public JobBean(String name, String image, String street,String district, String type,String category, String publisheddate, String vacancy, String salary, String gender, String applicationdeadline, String description, String responsibility1, String responsibility2, String responsibility3, String responsibility4, String eduexperience1, String eduexperience2, String eduexperience3, String eduexperience4, int cid) {
   
        this.name = name;
        this.image = image;
        this.street = street;
        this.district = district;
        this.type = type;
        this.category = category;
        this.publisheddate = publisheddate;
        this.vacancy = vacancy;
        this.salary = salary;
        this.gender = gender;
        this.applicationdeadline = applicationdeadline;
        this.description = description;
        this.responsibility1 = responsibility1;
        this.responsibility2 = responsibility2;
        this.responsibility3 = responsibility3;
        this.responsibility4 = responsibility4;
        this.eduexperience1 = eduexperience1;
        this.eduexperience2 = eduexperience2;
        this.eduexperience3 = eduexperience3;
        this.eduexperience4 = eduexperience4;
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublisheddate() {
        return publisheddate;
    }

    public void setPublisheddate(String publisheddate) {
        this.publisheddate = publisheddate;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getApplicationdeadline() {
        return applicationdeadline;
    }

    public void setApplicationdeadline(String applicationdeadline) {
        this.applicationdeadline = applicationdeadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponsibility1() {
        return responsibility1;
    }

    public void setResponsibility1(String responsibility1) {
        this.responsibility1 = responsibility1;
    }

    public String getResponsibility2() {
        return responsibility2;
    }

    public void setResponsibility2(String responsibility2) {
        this.responsibility2 = responsibility2;
    }

    public String getResponsibility3() {
        return responsibility3;
    }

    public void setResponsibility3(String responsibility3) {
        this.responsibility3 = responsibility3;
    }

    public String getResponsibility4() {
        return responsibility4;
    }

    public void setResponsibility4(String responsibility4) {
        this.responsibility4 = responsibility4;
    }

    public String getEduexperience1() {
        return eduexperience1;
    }

    public void setEduexperience1(String eduexperience1) {
        this.eduexperience1 = eduexperience1;
    }

    public String getEduexperience2() {
        return eduexperience2;
    }

    public void setEduexperience2(String eduexperience2) {
        this.eduexperience2 = eduexperience2;
    }

    public String getEduexperience3() {
        return eduexperience3;
    }

    public void setEduexperience3(String eduexperience3) {
        this.eduexperience3 = eduexperience3;
    }

    public String getEduexperience4() {
        return eduexperience4;
    }

    public void setEduexperience4(String eduexperience4) {
        this.eduexperience4 = eduexperience4;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }
    
    
    
    
}
