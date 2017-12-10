
package raniatask;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class fileManager {
    public boolean write(String FilePath, Object data)
    {
        try 
        {
            ObjectOutputStream writter = new ObjectOutputStream(new FileOutputStream(FilePath));
            writter.writeObject(data);
            writter.close();
            return true;
        }
        catch (IOException e) 
        {
            System.out.println("Can't write ...!\n" + e);
        }
        return false;
    }
    
    public Object read(String FilePath) 
    {
        Object Result = null;
        try 
        {    
            ObjectInputStream Reader = new ObjectInputStream(new FileInputStream(FilePath));
            Result = Reader.readObject();
        }
        catch (IOException e) 
        {
            System.out.println(e);
        }
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(fileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Result;
    }//end of read 
}
