package projectmanagement;
import java.io.Serializable;
import java.util.*;

public abstract class project implements Serializable{
    private int ProjectID;
    private String ProjectName;
    private Date deadline;
    private ArrayList<task> ProjectTasks;
    private boolean status;
    private float Progress;
    public project() {}
    public project(int ProjectID , String ProjectName, Date deadline) 
    {
        this.ProjectID = ProjectID;
        this.ProjectName = ProjectName;
        this.deadline = deadline;      
        this.status = false;
    }
     
    public int generateId(ArrayList<project> projects)
    {
        if(projects.isEmpty())
            return 1;
        else
            return (projects.get(projects.size()-1).ProjectID + 1);
    }
    
    public void setID(int ID) 
    {
        this.ProjectID = ID;
    }

    public void setProjectName(String Pname)
    {
        this.ProjectName= Pname;
    }

    public void setProgress(float prog) 
    {
        this.Progress = prog;
    }
     
    public void setDeadline (Date deadline)
    {
        this.deadline = deadline;
    }
    //check finished or not task status 0 or 1
    public void setProjectStatus(boolean finshed)
    {
        this.status = finshed;
    }
   
    
    //getter
    public int getID() 
    {
        return this.ProjectID;
    }

    public String getName() 
    {
        return this.ProjectName;
    }

    public float getProgress() 
    {
        return this.Progress;
    }

    public Date getProjectDeadLine()
    {
        return this.deadline;
    }
    
    public boolean getStatus()
    {
        return this.status;
    }
    
    public boolean commitToFile(ArrayList<project> projects)
    {
        fileManager x = new fileManager();
        boolean y = x.write("project.bin", projects);
        return y;
    }

    public ArrayList<project> ReadFromFile()
    {
        fileManager x = null;
        return (ArrayList<project>) x.read("project.bin");
    }

     
    public ArrayList<project> getAllProject()
    {
        return (ArrayList<project>)this.ReadFromFile();
    }

   public int SearchProject(int id, ArrayList<project> projects)
   {
       for (int i = 0; i < projects.size(); i++) 
       {
            if (projects.get(i).ProjectID == id) 
            return i;     
       }
       return -1;
   }
   
  // public ArrayList getAllProjectTasks(){}
   
   
   public float calcProjectProgress ()
   {
       float suc = 0;
       for(task t : this.ProjectTasks)
       {
           suc= (t.getStatus())?suc++:suc;
       }
       return ((suc/this.ProjectTasks.size())*100);
   }
}

