package projectmanagement;
import java.util.*;

public class vacation
{
    private int ID;
    private int EmployeeID;
    private Date vacationTime;
    private boolean Status;
    
    public vacation(int EmployeeID, Date Vacation)
    {
        this.EmployeeID = EmployeeID;
        this.vacationTime = Vacation;
        this.Status = false;
        fileManager f = new fileManager();
        int generateId = (((int)f.read("vacId.bin"))+1);
        this.setId(generateId);
        f.write("vacId.bin", generateId);
    }   
    
    public void setId(int ID)
    {
        this.ID = ID;
    }
    public int getId()
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
