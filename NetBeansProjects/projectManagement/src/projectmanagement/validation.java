package projectmanagement;

public class validation {
    public boolean isEmail(String email)
    {
        return (email.length() > 10 && email.substring(email.length() - 4).equals(".com") && email.contains("@"));
    }
    
    
}
