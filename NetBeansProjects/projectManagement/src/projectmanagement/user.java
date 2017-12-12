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
    public int login(String email, String password, ArrayList<user> allUser)
    {
        for(user ser : allUser)
        {
            if(ser.getEmail().equals(email) && ser.getPassword().equals(password))
            {
               return ser.getRole();
            }
        }
        return -1;
    }
    /* end of methods */
    public Object readFromFile(String filepath)
    {
        fileManager f = new fileManager();
        return f.read(filepath);
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
}
