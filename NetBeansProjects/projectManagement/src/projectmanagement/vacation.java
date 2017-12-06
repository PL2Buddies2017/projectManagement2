package projectmanagement;

import java.io.Serializable;
import java.util.*;

public class vacation implements Serializable
{
    private int ID;
    private int EmployeeID;
    private Date vacationTime;
    private boolean Status;
    
    public vacation(int ID, int EmployeeID, Date Vacation)
    {
        this.ID = ID;
        this.EmployeeID = EmployeeID;
        this.vacationTime = Vacation;
        this.Status = false;
    }   
    
    public void setID(int ID)
    {
        this.ID = ID;
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
    /*
    public ArrayList<vacation> getVacationByEmployeeId(ArrayList<vacation> vacations, int id)
    {
        ArrayList<vacation> empVacation = new ArrayList<>();
        for(vacation vac : vacations)
        {
            if(vac.getEmployeeID() == id)
            {
                empVacation.add(vac);
            }
        }
        if(empVacation.size() > 0)
        return empVacation;
        else return null;
    }*/
    /*
    public ArrayList<vacation> readFromFile()
    {
        fileManager f = new fileManager();
        return (ArrayList<vacation>)f.read("vacation.bin");
    }
    public void commitToFile(ArrayList<vacation> vacations)
    {
        fileManager f = new fileManager();
        f.write("vacation.bin", vacations);
    }
    */
}
