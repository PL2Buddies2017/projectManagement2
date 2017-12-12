package projectmanagement;

import java.io.Serializable;
import java.util.ArrayList;

public class admin extends user implements Serializable{
    
    public admin()
    {
        this.setRole(4);
    }
    public admin(String fName, String lName,String email, String password, String phoneNumber, String gender,String address)
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
        this.setRole(4);
    }
    
    public admin searchAdmin(ArrayList<admin> admins, int id)
    {
        if(admins.size() > 0)
        {
            for(admin admin : admins)
            {
                if( admin.getId() == id )
                    return admin;
            }
        }
        return null;
    }
    
    public void commit(ArrayList<admin>ad)
    {
        fileManager f = new fileManager();
        f.write("admin.bin", ad);
    }
    
    public ArrayList<admin> read()
    {
        return (ArrayList<admin>)this.readFromFile("admin.bin");
    }
}
