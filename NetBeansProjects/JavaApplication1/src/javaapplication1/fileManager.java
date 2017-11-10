package javaapplication1;

import java.util.*;
import java.io.*;


public class fileManager {
    
   private String filename;
   private String exe;
   private String fileDir;
   private String allPath;
   private File usag;
   /* Start of FileManger class constructor */
   public fileManager(String file)
   {
       this.filename = file;
       this.exe = "";
       this.fileDir = "";
   }
   
   public fileManager(String file , String e)
   {
       this.filename = file;
       this.exe = e;
       this.fileDir = "";
   }
   public fileManager(String file , String e, String dir)
   {
       this.filename = file;
       this.exe = e;
       this.fileDir = dir;
   }
   /* End of FileManger class constructor */
   
    /* Start of setter */
   public void setFileName(String f)
   {
       this.filename = f;
   }
   public void setExetention(String e)
   {
       this.exe = e;
   }
    public void setPathName(String p)
    {
        this.fileDir = p;
    }
   /* End of setter */
   /* Start of Methodes */
    public String GetAll()
    {
        String fileToStr = new String();
        this.collectFilePath();
        
        try{
            this.collectFilePath();
        this.usag = new File(this.allPath);
        Scanner get = new Scanner(usag);
        while(get.hasNext())
        {
            fileToStr += get.nextLine();
        }
        
        }
        catch(IOException e)
        {
            System.out.println("Error" + e);
        }
        
        return fileToStr;
    }
    
    public boolean setAll(String x, boolean append)
    {
        BufferedWriter writer = null;
        FileWriter lol = null;
        this.usag = null;
        try
        {
            this.collectFilePath();
            this.usag = new File(this.allPath);
            lol = new FileWriter(this.usag,append);
            writer = new BufferedWriter(lol);
            writer.write(x);
            writer.close();
        }
        catch(IOException e)
        {
            System.out.println("Error" + e);
            return false;
        }
        return true;
    }
    private void collectFilePath()
    {
        this.allPath = this.fileDir + this.filename + this.exe;
    }
    
    /* End of Methodes */
}
