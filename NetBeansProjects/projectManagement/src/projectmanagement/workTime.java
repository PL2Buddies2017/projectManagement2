package projectmanagement;

import java.util.*;
import java.text.SimpleDateFormat;

public class workTime {
    private Date EntryTime;
    private Date ExitTime;
    private int []arr;
    public workTime()
    {
        this.EntryTime =  new Date();
        this.arr = new int[2];
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
     public void SetExitTime() 
    {
        this.ExitTime = new Date();
    }
     public Date GetExitTime() 
    {
        return this.ExitTime ;
    }
     
     
     public void calcAllhours()
     {
        long dif = this.ExitTime.getTime() - this.EntryTime.getTime();
        this.arr[0] = (int) (dif / (60 * 60 * 1000));
        dif -= arr[0] * 60 * 60 * 1000;
	this.arr[1] = (int)(dif / (60 * 1000));
     }
     
     public int getMonth()
     {
         SimpleDateFormat form = new SimpleDateFormat("MM");
         String month = form.format(this.ExitTime);
         return (int)Integer.parseInt(month);
     }
     
     public long getWorkHours(ArrayList<workTime> wTime, int month)
     {
         int allHours = 0;
         int min = 0;
         if(wTime.size() > 0)
         {
             wTime.get( wTime.size() - 1).SetExitTime();
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
         return this.arr[0];
     }
     public long getMin()
     {
         return this.arr[1];
     }
}     