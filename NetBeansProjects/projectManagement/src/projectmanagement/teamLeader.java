package projectmanagement;

public class teamLeader extends user{
     public teamLeader()
    {
        this.setRole(2);
    }
    public teamLeader(String fName, String lName,String email, String password, String phoneNumber, String gender,String address,int id)
    {
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhoneNumber(phoneNumber);
        this.setGender(gender);
        this.setAddress(address);
        this.setId(id);
        this.setRole(2);
    }
}
