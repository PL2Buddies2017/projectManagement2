package projectmanagement;

import java.util.*;
import java.text.SimpleDateFormat;

public class workTime {
    private Date EntryTime;
    private Date ExitTime;
    private int EmployeeID;
    private long []arr;
    public workTime( int EmployeeID)
    {
        this.EntryTime =  new Date();
        this.EmployeeID = EmployeeID;
        this.arr = new long[5];
    }   
    public void SetEntryTime(Date EntryTime) 
    {
        EntryTime = new Date();
        this.EntryTime = EntryTime ;
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
     
     public void calcAllhours()
     {
        long dif = this.ExitTime.getTime() - this.EntryTime.getTime();
        long diffSeconds = dif / 1000 % 60;
	long diffMinutes = dif / (60 * 1000) % 60;
	long diffHours = dif / (60 * 60 * 1000) % 24;
	long diffDays = dif / (24 * 60 * 60 * 1000);
        
        this.arr[0]=diffSeconds;
        this.arr[1]=diffMinutes; 
        this.arr[2]= diffHours; 
        this.arr[3]= diffDays;
     }
     
     public int getMonth()
     {
         SimpleDateFormat form = new SimpleDateFormat("MM");
         String month = form.format(this.ExitTime);
         return (int)Integer.parseInt(month);
     }
     
     public long getWorkHours(ArrayList<workTime> wTime, int month)
     {
         long allHours = 0;
         long min = 0;
         if(wTime.size() > 0)
         {
             Date now = new Date();
             wTime.get( wTime.size() - 1).SetExitTime(now);
             for(workTime work : wTime)
             {
                 if(work.getMonth() == month)
                 {
                     work.calcAllhours();
                     allHours += work.getWorkHour();
                     min += work.getMin();
                     if(min >= 60)
                     {
                         allHours += 1;
                         min -= 60;
                     }
                 }
             }
             return allHours;
         }
         return 0;
     }
     
     public long getWorkHour()
     {
         return this.arr[2];
     }
     public long getMin()
     {
         return this.arr[1];
     }
}