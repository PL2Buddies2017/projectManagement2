package projectmanagement;
import java.io.Serializable;
import java.util.*;

public class container implements Serializable {
    public ArrayList<employee> employees;
    public ArrayList<teamLeader> teamLeaders;
    public ArrayList<projectManager> projectManagers;
    public ArrayList<admin> admins;
    public ArrayList<user> users;
    public ArrayList<project> projects;
    public ArrayList<vacation> vacations;
    public ArrayList<penaltie> penalties;
    public container()
    {
        this.users = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.teamLeaders = new ArrayList<>();
        this.projectManagers =  new ArrayList<>();
        this.admins = new ArrayList<>();
        this.projects = new ArrayList<>();
        this.vacations = new ArrayList<>();
        this.penalties = new ArrayList<>();
        user master = new user();
        project masterProject = new project();
        this.users = master.readFromFile();
        this.employees = master.getUsersByRole(this.users, 1);
        this.teamLeaders = master.getUsersByRole(this.users, 2);
        this.projectManagers = master.getUsersByRole(this.users, 3);
        this.admins = master.getUsersByRole(this.users, 4);
        this.projects = masterProject.ReadFromFile();
                
        for(employee emp : this.employees)
        {
            ArrayList<vacation> vacs = new ArrayList<>();
            ArrayList<penaltie> penals = new ArrayList<>();
            if(emp.getVacationCount() > 0)
            {
                vacs = emp.getAllVacations();
                for(vacation vac : vacs)
                {
                    this.vacations.add(vac);
                }//end of for
            }//end of if
            if(emp.getPenaltieCount() > 0)
            {
                penals = emp.getAllPenalties();
                for(penaltie pen : penals)
                {
                    this.penalties.add(pen);
                }
            }
        }//end of for           
    }
}
