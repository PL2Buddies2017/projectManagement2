package projectmanagement;

import java.util.regex.Pattern;

public class validation {
    public boolean isEmail(String email)
    {
        return (email.length() > 10 && email.substring(email.length() - 4).equals(".com") && email.contains("@"));
    }
    
    public boolean isAlpha(String str)
    {
        return Pattern.matches("[a-zA-Z]+", str);
    }
    
    public boolean isNum(String str)
    {
        return Pattern.matches("[0-9]+", str);
    }
}
