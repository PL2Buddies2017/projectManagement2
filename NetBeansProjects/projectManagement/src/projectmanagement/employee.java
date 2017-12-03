package projectmanagement;
import java.util.ArrayList;
public class employee extends user{
    private ArrayList <penaltie> penalties;
    private ArrayList <vacation> vacations;
    private ArrayList <workTime> workTimes;
    
    public employee(String fName, String lName,String email, String password, String phoneNumber, String gender,String address,int id)
    {
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhoneNumber(phoneNumber);
        this.setGender(gender);
        this.setAddress(address);
        this.setId(id);
        this.setRole(1);
    }
    
    public employee()
    {
        this.setRole(1);
    }
    public void addPenaltie(penaltie x)
    {
        this.penalties.add(x);
    }
    
    public void addVacation(vacation x)
    {
        this.vacations.add(x);
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
}