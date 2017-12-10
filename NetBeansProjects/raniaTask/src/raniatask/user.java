package raniatask;
import java.util.*;

public class user {
    
    private String fName;
    private String lName;
    private String email;
    private String password;
    private int id;
    private int role;
    
    public user(){}
    
    public user(String firstName, String lastName, String email, String password, int id, int role)
    {
        this.fName = firstName;
        this.lName = lastName;
        this.email = email;
        this.password = password;
        this.id = id;
        this.role = role;    
    }
    
    public boolean addNewUSer(user newUser, ArrayList<user> allUsers)
    {
        for (user us : allUsers)
        {
            if(us.getEmail().equals(newUser.getEmail()))
            {
                return false;
            }
        }
        allUsers.add(newUser);
        return true;
    }
    
    public boolean removeUser(ArrayList<user> allUsers, String email)
    {
        for(int i = 0; i < allUsers.size() ; i++)
        {
            if(allUsers.get(i).getEmail().equals(email))
            {
                allUsers.remove(i);
                return true;
            }
        }return false;
    }
        
    public ArrayList getUsersByRole(ArrayList<user> allUsers, int role)
    {
        if( role >= 1 && role <=4 && !allUsers.isEmpty())
        {
            if(role == 1)
            {
                ArrayList<employee> employees = new ArrayList<>();
                for(user person : allUsers)
                {
                    if( person.getRole() == 1 )
                    {
                        employee x = new employee(person.getFirstName(),person.getLastName(),person.getEmail(), person.getPassword(), person.getphoneNumber(), person.getGender(),person.getAddress(),person.getId());
                        employees.add(x);
                    }//end of if
                }//dnd of for
                if(employees.size() > 0)
                {return (ArrayList <employee>)employees;}
                return null;
            }//end of role 1
            
            if(role == 2)
            {
                ArrayList<teamLeader> TL = new ArrayList<>();
                for(user person : allUsers) {
                    if( person.getRole() == 2 )
                    {
                        teamLeader leader = new teamLeader(person.getFirstName(),person.getLastName(),person.getEmail(), person.getPassword(), person.getphoneNumber(), person.getGender(),person.getAddress(),person.getId());
                        TL.add(leader);
                    }
                }
                return (ArrayList<teamLeader>) TL;
            }//end of role 2
            
            if(role == 3)
            {
                ArrayList<projectManager> PM = new ArrayList<>();
                for( user person : allUsers )
                {
                    if( person.getRole() == 3 )
                    {
                        projectManager manager = new projectManager(person.getFirstName(),person.getLastName(),person.getEmail(), person.getPassword(), person.getphoneNumber(), person.getGender(),person.getAddress(),person.getId());
                        PM.add(manager);
                    }//end of if
                }//end of for
                return (ArrayList<projectManager>) PM;
            }//end of role 3
            
            if(role == 4)
            {
                ArrayList<admin> admin = new ArrayList<>();
                for( user person : allUsers )
                {
                    if( person.getRole() == 4 )
                    {
                        admin ad = new admin(person.getFirstName(),person.getLastName(),person.getEmail(), person.getPassword(), person.getphoneNumber(), person.getGender(),person.getAddress(),person.getId());
                        admin.add(ad);
                    }//end of if
                }//end of for
                return (ArrayList<admin>)admin;
            }//end of role 4
        }
        return null;
    }
    
    public boolean commitToFile(ArrayList<user> allUsers)
    {
        fileManager f = new fileManager();
        boolean fin = f.write("user.bin",allUsers);//not finished
        return fin;
    }
    
    public ArrayList<user> readFromFile()
    {
        fileManager f = new fileManager();
        return (ArrayList<user>)f.read("user.bin");
    }
    
    public int generateId(ArrayList<user> allUsers)
    {
        return (allUsers.get(allUsers.size()-1).getId() + 1);
    }
    // still not finished 
    public boolean login(String eamil, String Password, ArrayList<user> allUsers)
    {
        for(user us : allUsers)
        {
            if(us.getEmail().equals(email) && us.getPassword().equals(password))
            {
                return true;
            }
        }
        return false;
    }
   
    
    public void setFirstName(String fname)
    {
        this.fName = fname;
    }
    public String getFirstName()
    {
        return this.fName;
    }
    
    public void setLastName(String lname)
    {
        this.lName = lname;
    }
    public String getLastName()
    {
        return this.lName;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getEmail()
    {
        return this.email;
    }
    
    public void setPassword(String pass)
    {
        this.password = pass;
    }
    public String getPassword()
    {
        return this.password;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return this.id;
    }
    
    public void setRole(int role)
    {
        this.role = role;
    }
    public int getRole()
    {
        return this.role;
    }
}
