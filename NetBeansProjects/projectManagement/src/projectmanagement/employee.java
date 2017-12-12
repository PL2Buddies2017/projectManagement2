package projectmanagement;
import java.io.Serializable;
import java.util.ArrayList;

public class employee extends user implements Serializable{
    private ArrayList <penaltie> penalties;
    private ArrayList <vacation> vacations;
    private ArrayList <workTime> workTimes;
    
    public employee(String fName, String lName,String email, String password, String phoneNumber, String gender,String address)
    {
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhoneNumber(phoneNumber);
        this.setGender(gender);
        this.setAddress(address);
        fileManager f = new fileManager();
        int generateId = (((int)f.read("generateId.bin"))+1);
        f.write("generateId.bin", generateId);
        this.setId(generateId);
        this.setRole(1);
        this.vacations = new ArrayList<>();
        this.penalties = new ArrayList<>();
        this.workTimes = new ArrayList<>();
    }
    
    public void commit(ArrayList<employee> emp)
    {
        fileManager f = new fileManager();
        f.write("employee.bin", emp);
    }
    
    public ArrayList<employee> read()
    {
        return (ArrayList<employee>)this.readFromFile("employee.bin");
    }
    
    public employee()
    {
        this.setRole(1);
    }
    public void addPenaltie(penaltie penal)
    {
        this.penalties.add(penal);
    }
    
    public void addVacation(vacation vac)
    {
        this.vacations.add(vac);
    }
    
    public void addWorktime(workTime x)
    {
        this.workTimes.add(x);
    }
    
    public ArrayList<penaltie> getAllPenalties()
    {
        return (ArrayList<penaltie>)this.penalties;
    }
    
    public ArrayList<vacation> getAllVacations()
    {
        return (ArrayList<vacation>)this.vacations;
    }
    
    public ArrayList<workTime> getAllWorkTime()
    {
        return (ArrayList<workTime>)this.workTimes;
    }
    
    public int getVacationCount()
    {
        return (int)this.vacations.size();
    }
    
    public int getPenaltieCount()
    {
        return (int)this.penalties.size();
    }
    
    public employee searchEmployee(ArrayList<employee> employees, int id)
    {
        if(employees.size() > 0)
        {
            for(employee emp : employees)
            {
                if( emp.getId() == id )
                    return emp;
            }
        }
        return null;
    }
    public void setEntryTime()
    {
        workTime newDay = new workTime();
        newDay.GetExitTime();
        this.workTimes.add(newDay);
    }
    public void setExitTime()
    {
        this.workTimes.get(this.workTimes.size()-1).SetExitTime();
    }
}

