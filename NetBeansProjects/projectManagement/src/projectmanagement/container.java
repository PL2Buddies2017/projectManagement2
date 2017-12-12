package projectmanagement;
import java.io.Serializable;
import java.util.*;

public class container implements Serializable {
    
    public ArrayList<employee> employees;
    public ArrayList<teamLeader> teamLeaders;
    public ArrayList<projectManager> projectManagers;
    public ArrayList<admin> admins;
    public ArrayList<project> projects;
    public ArrayList<vacation> vacations;
    public ArrayList<penaltie> penalties;
    public int currentUserRole;
    public boolean activeSession;
    public employee empSession;
    public teamLeader TLSession;
    public projectManager PMSession;
    public admin adSession;
    public int activeIndex;
    public int userId;
    public container()
    {
        this.employees = new ArrayList<>();
        this.teamLeaders = new ArrayList<>();
        this.projectManagers =  new ArrayList<>();
        this.admins = new ArrayList<>();
        this.projects = new ArrayList<>();
        this.vacations = new ArrayList<>();
        this.penalties = new ArrayList<>();
        this.activeSession = false;
        admin masterAdmin = new admin();
        project masterProject = new project();
        projectManager masterPM = new projectManager();
        teamLeader masterTL = new teamLeader();
        employee masterEmployee = new employee();
        
        this.admins = masterAdmin.read();
        this.projectManagers = masterPM.read();
        this.teamLeaders = masterTL.read();
        this.employees = masterEmployee.read();
    }//end of constructor
    
    public ArrayList<String> addNewUser(String fname,String lname,String email,String password,String phone,String gender,String address,int role)
    {
        ArrayList<String> strErr = new ArrayList<>();
        
        validation valid = new validation();
        if(!valid.isAlpha(fname))
        {
            strErr.add("First Name not valid");
        }
        if(!valid.isAlpha(lname))
        {
            strErr.add("Last Name not valid");
        }
        if(!valid.isEmail(email))
        {
            strErr.add("Email Not valid");
        }
        if(password.length() < 8 || valid.isNum(password))
        {
            String passErr =  new String();
            boolean len = false;
            if(password.length() < 8)
            {
                passErr = "password should be more than 8 character";
                len = true;
            }
            if(!valid.isNum(password))
            {
                passErr += (len)?" and cotain at least 1 ":"password should contain letter";
            }
            strErr.add(passErr);
        }
        if(!valid.isNum(phone) || phone.length() != 11)
        {
            strErr.add("phone Number not valid");
        }
        boolean flag = false;
        for (admin admin : this.admins) {
            if(admin.getEmail().equals(email))
            {
                strErr.add("Email is already exist in Admin's emails");
                flag = true;
                break;
            }
        }
        if(!flag)
        {
            for(projectManager pm : this.projectManagers)
            {
                if(pm.getEmail().equals(email))
                {
                    strErr.add("Email is already exist in project Manager's emails");
                    flag = true;
                    break;
                }
            }
            if(!flag)
            {
                for(teamLeader tl : this.teamLeaders)
                {
                    if(tl.getEmail().equals(email))
                    {
                        strErr.add("Email is already exist in team leader's emails");
                        flag = true;
                        break;
                    }//end of if
                }// end of for 
            }//end of flah team leader
            if(!flag)
            {
                for(employee emp : this.employees)
                {
                    if(emp.getEmail().equals(email))
                    {
                        strErr.add("Email is already exist in employees' emails");
                        break;
                    }//end of if
                }
            }
        }//end of flag project manager
        if(strErr.isEmpty())
        {
            switch(role)
            {
                case 1:
                    employee newEmp = new employee(fname, lname, email, password, phone, gender, address);
                    this.employees.add(newEmp);
                    newEmp.commit(this.employees);
                    break;
                case 2:
                    teamLeader newTL = new teamLeader(fname, lname, email, password, phone, gender, address);
                    this.teamLeaders.add(newTL);
                    newTL.commit(this.teamLeaders);
                    break;
                case 3:
                    projectManager newPM = new projectManager(fname, lname, email, password, phone, gender, address);
                    this.projectManagers.add(newPM);
                    newPM.commit(this.projectManagers);
                    break;
                case 4:
                    admin newAdmin = new admin(fname, lname, email, password, phone, gender, address);
                    this.admins.add(newAdmin);
                    newAdmin.commit(this.admins);
                    break;
                default:strErr.add("role not correct");
            }//end of switch
        }//end of add new user
        return strErr;
    }
    
    public boolean removeUser(int id, int role)
    {
        switch(role)
        {
            case 1:
                
                for(int i = 0; i < this.employees.size() ; i++)
                {
                    if(this.employees.get(i).getId() == id)
                    {
                        this.employees.remove(i);
                        employee masterEmployee = new employee();
                        masterEmployee.commit(this.employees);
                        return true;
                    }
                }
                break;
            case 2:
                for(int i = 0; i < this.teamLeaders.size() ; i++)
                {
                    if(this.teamLeaders.get(i).getId() == id)
                    {
                        this.teamLeaders.remove(i);
                        teamLeader masterTeamLeader = new teamLeader();
                        masterTeamLeader.commit(this.teamLeaders);
                        return true;
                    }
                }
                break;
            case 3:
                for(int i = 0; i < this.projectManagers.size() ; i++)
                {
                    if(this.projectManagers.get(i).getId() == id)
                    {
                        this.projectManagers.remove(i);
                        projectManager masterPM = new projectManager();
                        masterPM.commit(this.projectManagers);
                        return true;
                    }
                }
                break;
            case 4:
                for(int i = 0; i < this.admins.size() ; i++)
                {
                    if(this.admins.get(i).getId() == id)
                    {
                        this.admins.remove(i);
                        admin masterAdmin = new admin();
                        masterAdmin.commit(this.admins);
                        return true;
                    }
                }
                break;
            default:return false;
        }
        return false;
    }
    
    public int login(String email, String password)
    {
        for(int i = 0; i < this.employees.size() ; i++)
        {
            if(this.employees.get(i).getEmail().equals(email) && this.employees.get(i).getPassword().equals(password))
            {    
                this.empSession = new employee();
                this.empSession = this.employees.get(i);
                this.employees.get(i).setEntryTime();
                this.currentUserRole = 1;
                this.activeSession = true;
                this.activeIndex = i;
                return 1;
            }
        }
        
        for(teamLeader tl : this.teamLeaders)
        {
            if(tl.getEmail().equals(email) && tl.getPassword().equals(password))
            {
                this.TLSession = new teamLeader();
                this.TLSession = tl;
                this.currentUserRole = 2;
                this.activeSession = true;
                return 2;
            }
        }
        
        for(projectManager pm : this.projectManagers)
        {
            if(pm.getEmail().equals(email) && pm.getPassword().equals(password))
            {
                this.PMSession = new projectManager();
                this.PMSession = pm;
                this.currentUserRole = 3;
                this.activeSession = true;
                return 3;
            }
        }
        
        for(admin ad : this.admins)
        {
            if(ad.getEmail().equals(email) && ad.getPassword().equals(password))
            {
                this.adSession = new admin();
                this.adSession = ad;
                this.currentUserRole = 4;
                this.activeSession = true;
                return 4;
            }
        }
        return 0;
    }
    
    public boolean logOut()
    {
        this.activeSession = false;
        if(this.currentUserRole == 1)
        {
            this.employees.get(this.activeIndex).setExitTime();
        }
        this.endSession();
        return true;
    }
    
    public void endSession()
    {
        admin masterAdmin = new admin();
        masterAdmin.commit(this.admins);
        
        projectManager masterPM = new projectManager();
        masterPM.commit(this.projectManagers);
        
        teamLeader masterTL = new teamLeader();
        masterTL.commit(this.teamLeaders);
        
        employee masterEmployee = new employee();
        masterEmployee.commit(this.employees);
        
        project masterProject = new project();
        //masterProject.commitToFile(this.projects);   
    }
}//end of class