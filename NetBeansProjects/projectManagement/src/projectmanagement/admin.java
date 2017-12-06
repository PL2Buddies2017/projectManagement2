package projectmanagement;

import java.util.ArrayList;

public class admin extends user {
    
    public admin()
    {
        this.setRole(4);
    }
    public admin(String fName, String lName,String email, String password, String phoneNumber, String gender,String address,int id)
    {
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhoneNumber(phoneNumber);
        this.setGender(gender);
        this.setAddress(address);
        this.setId(id);
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
}
