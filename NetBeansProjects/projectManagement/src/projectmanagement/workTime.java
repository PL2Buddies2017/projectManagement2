package projectmanagement;

import java.util.*;

public class workTime {
    private Date EntryTime;
    private Date ExitTime;
    private int EmployeeID;
    
public workTime( Date EntryTime, Date ExitTime,int EmployeeID)
{
    this.EntryTime =  EntryTime;
    this.ExitTime =  ExitTime;
    this.EmployeeID = EmployeeID;
}   
    public void SetEntryTime(Date EntryTime) 
    {
         EntryTime=new Date();
        this.EntryTime=EntryTime ;
    }
     public Date GetEntryTime() 
    {
        return this.EntryTime ;
    }
     public void SetExitTime(Date ExitTime) 
    {
         ExitTime=new Date();
        this.ExitTime=ExitTime ;
    }
     public Date GetExitTime() 
    {
        return this.ExitTime ;
    }
     public void SetEmployeeID(int EmployeeID)
     {
         this.EmployeeID=EmployeeID;
     }
     public int GetEmployeeID()
     {
         return this.EmployeeID;
     }
     public ArrayList calcAllhours(ArrayList All)
     {
        long dif=ExitTime.getTime()-EntryTime.getTime();
        long diffSeconds = dif / 1000 % 60;
	long diffMinutes = dif / (60 * 1000) % 60;
	long diffHours = dif / (60 * 60 * 1000) % 24;
	long diffDays = dif / (24 * 60 * 60 * 1000);
        long []arr = new long[5];
        arr[0]=diffSeconds;
        arr[1]=diffMinutes; 
        arr[2]= diffHours; 
        arr[3]= diffDays;
        All.add(arr);
        return (ArrayList<Object>) (Object) All;
     }
}