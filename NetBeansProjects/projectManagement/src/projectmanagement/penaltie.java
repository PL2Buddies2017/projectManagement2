
package projectmanagement;

public class penaltie{
    
    private int  id;
    private int empId;
    private String  Reason;
    
    public penaltie(int  id ,String  Reason, int empId)
    {
        this.id = id;
        this.Reason = Reason;
        this.empId = empId;
    }
    public penaltie(){}
    
    public void setId(int ReasonID)
    {
        this.id = ReasonID;
    }
    
    public void setEmpId(int id)
    {
        this.empId = id;
    }
    
    public void setReason(String Reason)
    {
        this.Reason = Reason;
    }
     
    public String getReason(String Reason)
    {
       return this.Reason;
    }
    
    public int  getId(int ReasonID)
    {
        return this.id;
    }
    
    public int getEmpId()
    {
        return this.empId;
    }
}
