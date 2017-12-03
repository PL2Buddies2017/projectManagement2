package projectmanagement;

import java.util.*;

public class vacation 
{
    private int ID;
    private int EmployeeID;
    private Date vacationTime;
    private boolean Status;
    
    public vacation(int ID, int EmployeeID, Date Vacation, boolean Status)
    {
        this.ID=  ID;
        this.EmployeeID= EmployeeID;
        this.vacationTime=Vacation;
        this.Status=Status;
    }   
    
    public void setID(int ID)
    {
        this.ID=  ID;
    }
    
    public int getID()
    {
         return this.ID;
    }
   
    public void setEmployeeID(int EmployeeID)
    {
      this.EmployeeID=EmployeeID;
    }
    
    public int getEmployeeID()
    {
     return this.EmployeeID;
    }
    
    public void setVacation(Date Vacation)
    {
      this.vacationTime=Vacation;
    }
    
    public Date getVacation()
    {
     return this.vacationTime;
    }
    
    public void setStatus(boolean Status)
    {
      this.Status=Status;
    }
    
    public boolean getStatus()
    {
        return this.Status;
    }  
}
