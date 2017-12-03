package projectmanagement;

import java.util.*;
import java.text.*;

public class ProjectManagement {    
    public static void main(String []args) {
        fileManager x = new fileManager();
        user y = new user("bodey","Solieman", "abdelrhman.solieman98@gmail.com", "1234567","01113348877","male","anything",1,1);
        user z = new user("bodey","Solieman", "abdelrhman.solieman98@gmail.com", "1234567","01113348877","male","anything",2,1);
        employee kok = new employee("bodey","Solieman", "abdelrhman.solieman98@gmail.com", "1234567","01113348877","male","anything",2);
        ArrayList<user> all = new ArrayList();
        all.add(y);
        all.add(z);
        x.write("user.bin", all);
        all = (ArrayList<user>)x.read("user.bin");
        System.out.print(all.get(1).getId());
    }
    
}
