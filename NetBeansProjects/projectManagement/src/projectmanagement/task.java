package projectmanagement;
import java.util.*;

public class task 
{
    private int id;
    private boolean status;
    private String taskName;
    private int projectId;
    private ArrayList<employee> coders;
    private String taskDesc;
    
    public int generateId(ArrayList<task> tasks)
    {
        if(tasks.isEmpty())
            return 1;
        else 
            return tasks.get(tasks.size()-1).id+1;
    }
    
    public task(){}
    
    public task(int id, String name, int pID, ArrayList<employee> coders, String desc)
    {
        this.id = id;
        this.status = false;
        this.taskName = name;
        this.projectId = pID;
        this.coders = coders;
        this.taskDesc = desc;
    }
    
    public task(int id, String name, int pID, String desc)
    {
        this.id = id;
        this.status = false;
        this.taskName = name;
        this.projectId = pID;
        this.taskDesc = desc;
    }
    
    public void setTaskId(int id)
    {
        this.id = id;
    }
    
    public void setDesc(String desc)
    {
        this.taskDesc = desc;
    }
    
    public void projectID(int pID)
    {
        this.projectId = pID;
    }
    
    public void setTaskName(String name)
    {
        this.taskName = name;
    }
    
    public void setStatus(boolean stat)
    {
        this.status = stat;
    }
    
    public boolean AddNewCoder(employee x)
    {
        for (employee coder : this.coders) {
            if (coder.getId() == x.getId()) {
                return false;//this employee already work in this task
            }
        }
        this.coders.add(x);
        return true;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public int getProjectId()
    {
        return this.projectId;
    }
    
    public String getTaskName()
    {
        return this.taskName;
    }
    
    public boolean getStatus()
    {
        return this.status;
    }
    
    public String getTaskDesc()    
    {
        return this.taskDesc;
    }
    
    public ArrayList<employee> getAllCoders()
    {
        return this.coders;
    }
    
}