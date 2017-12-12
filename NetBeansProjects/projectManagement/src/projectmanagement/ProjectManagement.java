package projectmanagement;

import java.util.*;
import java.text.*;
import java.util.regex.Pattern;

public class ProjectManagement {    
    public static void main(String []args) {
        
        container con = new container();
        
        /*ArrayList<employee> all = new ArrayList<>();
        employee x = new employee();
        x.commit(all);*/
        /*
        String fname, lname, email, password, phone, gender, address;
        int role;
        Scanner input = new Scanner(System.in);
        fname = input.next();
        lname = input.next();
        email = input.next();
        password = input.next();
        phone = input.next();
        gender = input.next();
        address = input.next();
        role = 1;
        
        ArrayList<String> err = con.addNewUser(fname, lname, email, password, phone, gender, address, role);
        if(err.isEmpty())
        {
            System.out.println("the new user added");
        }
        else
        {
            for(String e : err)
            {
                System.out.println(e);
            }
        }*/
        //abdelrhman mohamed abdelrhman.soleman98@gmail.com pass12345 01113348877 male elharam
        /*user master = new user();
        ArrayList<user> users = new ArrayList<>();
        user x1 = new user("abdelrhman","solieman","abdelrhman.solieman@gmail.com","12345","01226644175","mail","1212",1,1);
        user x2 = new user("abdelrhman","solieman","abdelrhman.solieman@gmail.com","12345","01226644175","mail","1212",1,2);
        user x3 = new user("abdelrhman","solieman","abdelrhman.solieman@gmail.com","12345","01226644175","mail","1212",1,3);
        user x4 = new user("abdelrhman","solieman","abdelrhman.solieman@gmail.com","12345","01226644175","mail","1212",1,4);
        users.add(x1);
        users.add(x2);
        users.add(x3);
        users.add(x4);
        master.commitToFile(users);*/
        //
        //Date x = new Date();
        //System.out.print(x);
        
        //container m = new container();
        //System.out.print(m.employees.size());
        /*user master = new user();
        ArrayList<user> users = new ArrayList<>();
        users = master.readFromFile();
        //System.out.print(users.get(0).getEmail());
        
        ArrayList<employee> emp = new ArrayList<>();
        emp = master.getUsersByRole(users, 1);
        
        Date now = new Date();
        ArrayList<project> y1 = new ArrayList<>();
        
        task masterTask = new task();
        ArrayList<task> tasks = new ArrayList<>();
        task t1 = new task(masterTask.generateId(tasks),"firstTask",1,emp.get(0),"ay 7aga",now);
        tasks.add(t1);
        project z1 = new project();
        project x1 = new project(z1.generateId(y1),"firstProject",now,tasks);
        y1.add(x1);
        project u1 = new project(z1.generateId(y1),"secondProject",now,tasks);
        y1.add(u1);
        u1.commitToFile(y1);
        System.out.print(y1.get(0).getName());*/
        //container lol = new container();
 
        
        //System.out.print(m.employees.size());
        /*user master = new user();
        ArrayList<user> users = new ArrayList<>();
        users = master.readFromFile();
        //System.out.print(users.get(0).getEmail());
        
        ArrayList<employee> emp = new ArrayList<>();
        emp = master.getUsersByRole(users, 1);
        
        Date now = new Date();
        ArrayList<project> y1 = new ArrayList<>();
        
        task masterTask = new task();
        ArrayList<task> tasks = new ArrayList<>();
        task t1 = new task(masterTask.generateId(tasks),"firstTask",1,emp.get(0),"ay 7aga",now);
        tasks.add(t1);
        project z1 = new project();
        project x1 = new project(z1.generateId(y1),"firstProject",now,tasks);
        y1.add(x1);
        project u1 = new project(z1.generateId(y1),"secondProject",now,tasks);
        y1.add(u1);
        u1.commitToFile(y1);
        System.out.print(y1.get(0).getName());*/
        //container lol = new container();
       
    }
}
