/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagement;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author bodeySolieman
 */
public class getTimeNow {
    public void getTimeNow(int []arr)
    {
        Date x = new Date();
        SimpleDateFormat y = new SimpleDateFormat("hh dd mm yyyy");
        String []str = y.format(x).split(" ");
        int index = 0;
        for(String s:str)
        {
            arr[index] = Integer.parseInt(s);
            index++;
        }
        
    }
    public int [] getTimeNow()
    {
        Date x = new Date();
        SimpleDateFormat y = new SimpleDateFormat("hh dd mm yyyy");
        String []str = y.format(x).split(" ");
        int []arr = new int[5];
        int index = 0;
        for(String s:str)
        {
            arr[index] = Integer.parseInt(s);
            index++;
        }
        return arr;
    }
}
