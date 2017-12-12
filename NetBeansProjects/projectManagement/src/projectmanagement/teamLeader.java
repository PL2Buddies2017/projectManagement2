package projectmanagement;
import java.io.Serializable;
import java.util.*;
public class teamLeader extends user implements Serializable{
     public teamLeader()
    {
        this.setRole(2);
    }
    public teamLeader(String fName, String lName,String email, String password, String phoneNumber, String gender,String address)
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
        this.setRole(2);
    }
    
    public void commit(ArrayList<teamLeader> allLeaders)
    {
        fileManager f = new fileManager();
        f.write("teamLeader.bin", allLeaders);
    }
    
    public ArrayList<teamLeader> read()
    {
        return (ArrayList<teamLeader>)this.readFromFile("teamLeader.bin");
    }
}
