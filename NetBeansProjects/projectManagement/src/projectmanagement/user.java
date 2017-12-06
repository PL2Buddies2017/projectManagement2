package projectmanagement;
import java.io.Serializable;
import java.util.*;

public class user implements Serializable{
    /* start of vars*/
    private String fName;
    private String lName;
    private String email;
    private String password;
    private String phoneNumber;
    private String gender;
    private String address;
    private int id;
    private int role;
    /* end of vars*/
    
    /* start of overloaded constructor */
    public user(String fName, String lName,String email, String password, String phoneNumber, String gender,String address,int id,int role)
    {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.id = id;
        this.role = role;
    }
    
    /* default constructor */
    public user(){}
    /* end of overloaded constructor */
    
    /* start of methods */
    boolean login(String email, String password, ArrayList x)
    {
        user ser;
        for( int i=0 ; i<(int)x.size() ; i++)
        {
            ser = (user)x.get(i);
            if(ser.getEmail().equals(email) && ser.getPassword().equals(password))
            {
               return true;
            }
        }
        return false;
    }
    
    public int generateId ( ArrayList<user> x )
    {
        if(x.isEmpty())
            return 1;
        else if(x.size() > 0)
            return (x.get(x.size()-1).getId() + 1);
        
        return 0;
    }
    
    public ArrayList getUsersByRole(ArrayList<user> allUsers, int role)
    {
        
        if( role >= 1 && role <=4 )
        {
            if(role == 1)
            {
                ArrayList<employee> employees = new ArrayList<>();
                for( user person : allUsers )
                {
                    if( person.getRole() == 1 )
                    {
                        employee x = new employee(person.getFirstName(),person.getLastName(),person.getEmail(), person.getPassword(), person.getphoneNumber(), person.getGender(),person.getAddress(),person.getId());
                        employees.add(x);
                    }//end of if
                }//dnd of for
                
                return (ArrayList <employee>)employees;
            }//end of role 1
            
            if(role == 2)
            {
                ArrayList<teamLeader> TL = new ArrayList<>();
                for (user person : allUsers) {
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
                return (ArrayList<admin>) admin;
            }//end of role 4
        }
        return null;
    }
    /* end of methods */
    public ArrayList<user> readFromFile()
    {
        ArrayList<user> users = new ArrayList<>();
        fileManager f = new fileManager();
        users = (ArrayList<user>)f.read("user.bin");
        return (ArrayList<user>)users;
    }
    
    /* start of getter */
    public String getFirstName()
    {
        return this.fName;
    }
    
    public String getLastName()
    {
        return this.lName;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    public String getphoneNumber()
    {
        return this.phoneNumber;
    }
    
    public String getGender()
    {
        return this.gender;
    }
    public String getAddress()
    {
        return this.address;
    }
    public int getRole()
    {
        return this.role;
    }
    public int getId()
    {
        return this.id;
    }
    /* end of getter */
    
    /* start of setter */
    public void setFirstName(String fName)
    {
        this.fName = fName;
    }
    
    public void setLastName(String lName)
    {
        this.lName = lName;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public boolean setRole(int role)
    {
        if(role >= 1 && role<=4)
        {
            this.role = role;
            return true;
        }else
        {
            return false;
        }
    }
    /* end of setter */
    
    /* dealing  with file */
    public void commitToFile(ArrayList<user> users)
    {
        fileManager commit = new fileManager();
        commit.write("user.bin", users);
    }
    
    public user searchUser(ArrayList<user> users, int id)
    {
        if(users.size() > 0)
        {
            for(user user : users)
            {
                if( user.getId() == id )
                    return user;
            }
        }
        return null;
    }
    public boolean removeUser(ArrayList<user> users, int id)
    {
        if(users.size() > 0)
        {
            for(int i = 0; i < users.size() ; i++)
            {
                if( users.get(i).getId() == id )
                {
                    users.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
}
