package projectmanagement;
import java.io.Serializable;
import java.util.*;

public class project implements Serializable{
    private int ProjectID;
    private String ProjectName;
    private Date deadline;
    private ArrayList<task> ProjectTasks;
    private boolean status;
    /* start of constructors */
    // default constructor
    public project() {}
    
    // constructor without Tasks
    public project(int ProjectID , String ProjectName, Date deadline) 
    {
        this.ProjectID = ProjectID;
        this.ProjectName = ProjectName;
        this.deadline = deadline;      
        this.status = false;
    }
    
    // constructor with tasks
    public project(int ProjectID , String ProjectName, Date deadline, ArrayList<task> tasks) 
    {
        this.ProjectID = ProjectID;
        this.ProjectName = ProjectName;
        this.deadline = deadline;
        this.ProjectTasks = tasks;
        this.status = false;
    }
    /* end of constructors */
    
    /* start of methods */
    public int generateId(ArrayList<project> projects)
    {
        if(projects.isEmpty())
            return 1;
        else
            return (projects.get(projects.size()-1).ProjectID + 1);
    }
    public boolean commitToFile(ArrayList<project> projects)
    {
        fileManager x = new fileManager();
        boolean y = x.write("project.bin", projects);
        return y;
    }
    public ArrayList<project> ReadFromFile()
    {
        fileManager x = new fileManager();
        return (ArrayList<project>) x.read("project.bin");
    }
    public project SearchProject(ArrayList<project> projects, int id)
    {
        for (project project : projects) {
            if (project.ProjectID == id) 
                return project;
        }
       return null;
    }
    
    public float getProgress()
    {
        float suc = 0;
        for(task t : this.ProjectTasks)
        {
            suc= (t.getStatus())?suc++:suc;
        }
        return (float)((suc/this.ProjectTasks.size())*100);
    }
    /* end of methods */
    
    /* start of setter & getter */
    // ID
    public void setID(int ID) 
    {
        this.ProjectID = ID;
    }
    public int getID() 
    {
        return this.ProjectID;
    }
    // project Name
    public void setProjectName(String Pname)
    {
        this.ProjectName= Pname;
    }
    public String getName() 
    {
        return this.ProjectName;
    }
    
    //deadLine
    public Date getProjectDeadLine()
    {
        return this.deadline;
    }
    public void setDeadline (Date deadline)
    {
        this.deadline = deadline;
    }
    
    // status
    public boolean getStatus()
    {
        return this.status;
    }
    public void setProjectStatus(boolean finshed)
    {   //finished or not task status 0 or 1
        this.status = finshed;
    }
    
    
    /* End of setter & getter */
    
    public project searchProject(ArrayList<project> projects, int id)
    {
        if(projects.size() > 0)
        {
            for(project project : projects)
            {
                if( project.getID() == id )
                    return project;
            }
        }
        return null;
    }
}