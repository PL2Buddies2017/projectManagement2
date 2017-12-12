package projectmanagement;
import java.io.Serializable;
import java.util.*;
public class projectManager extends user implements Serializable{
    public projectManager(){}
    public projectManager(String fName, String lName,String email, String password, String phoneNumber, String gender,String address)
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
        this.setRole(3);
    }
    
    public void commit(ArrayList<projectManager> allManagers)
    {
        fileManager f = new fileManager();
        f.write("projectManager.bin", allManagers);
    }
    
    public ArrayList<projectManager> read()
    {
        return (ArrayList<projectManager>)this.readFromFile("projectManager.bin");
    }
}