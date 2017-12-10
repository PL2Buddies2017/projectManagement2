package raniatask;
import java.util.*;

public class report {
    
    private String reason;
    private Date reportDate;
    private int empID;
    
    public report(){}
    public report(String reason, int empId)
    {
        this.reason = reason;
        this.reportDate = new Date();
        this.empID = empId;
    }
    
    public void setReason(String reason)
    {
        this.reason = reason;
    }
    public String getReason()
    {
        return this.reason;
    }
    
    public void setDate(Date date)
    {
        this.reportDate = date;
    }
    public Date getDate()
    {
        return this.reportDate;
    }   
}