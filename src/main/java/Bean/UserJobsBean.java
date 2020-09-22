package Bean;

import java.io.Serializable;

public class UserJobsBean implements Serializable{
    
    private int userid;
    private int jobid;

    public UserJobsBean() {
        this.userid = 0;
        this.jobid = 0;
    }
    public UserJobsBean(int userid, int jobid) {
        this.userid = userid;
        this.jobid = jobid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    @Override
    public String toString() {
        return "UserJobsBean{" + "userid=" + userid + ", jobid=" + jobid + '}';
    }
    
    
}
