package unitTesting.job;

import Bean.JobBean;
import DAO.JobDao;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

public class insertJob {
    JobDao testDao = new JobDao();
    
    private final String name = "testname";
    private final String image ="test/img.jpg";
    private final String street ="teststreet" ;
    private final String district ="Palo Alto" ;
     private final String type ="Part Time" ;
    private final String category ="testcat" ;
    private final String publisheddate = "14-20-2020";
    private final String vacancy ="20";
    private final String salary = "testsalary";
    private final String gender = "testgender";
    private final String applicationdeadline = "20-20-2020" ;
    private final String description ="testdescription" ;
    private final String responsibility1 ="testresponsibility1" ;
    private final String responsibility2 ="testresponsibility2";
    private final String responsibility3 = "testresponsibility3";
    private final String responsibility4 ="testresponsibility4";
    private final String eduexperience1 ="testeduexperience1" ;
    private final String eduexperience2 ="testeduexperience2";
    private final String eduexperience3 ="testeduexperience3";
    private final String eduexperience4 ="testeduexperience4";
    private final int cid = 16;
    
    JobBean testBean = new JobBean(name, image, street, district, type, category, publisheddate, vacancy, salary, gender, applicationdeadline, description, responsibility1, responsibility2, responsibility3, responsibility4, eduexperience1, eduexperience2, eduexperience3, eduexperience4, cid);

    @Test
    public void check(){

        assertEquals(1,testDao.add(testBean));
    }
    
}
