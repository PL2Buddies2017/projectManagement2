
package raniatask;

import java.util.ArrayList;


public class employee extends user{
    
    public employee(String fName, String lName,String email, String password,int id)
    {
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setEmail(email);
        this.setPassword(password);
        this.setId(id);
        this.setRole(1);
    }
    
}
