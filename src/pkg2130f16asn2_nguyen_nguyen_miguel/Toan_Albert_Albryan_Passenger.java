/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2130f16asn2_nguyen_nguyen_miguel;

/**
 *
 * @author mutan
 */
public class Toan_Albert_Albryan_Passenger {
    private String firstname, lastname, title, dateofbirth, passportno, emailaddress, phoneno;
    
    public Toan_Albert_Albryan_Passenger()
    {
        
    }

    public void setFirstName(String fname)
    {
        firstname = fname;
    }
    
    public void setLastName(String lname)
    {
        lastname = lname;
    }
    
    public void setTitle(String t)
    {
        title = t;
    }
    
    public void setPassport(String pn)
    {
        passportno = pn;
    }
    
    public void setDoB(String DoB)
    {
        dateofbirth = DoB;
    }
    
    public void setemail(String email)
    {
        emailaddress = email;
    }
    
    public void setPhone(String pn)
    {
        phoneno = pn;
    }
    
    public String getFirstName()
    {
        return firstname;
    }
    
    public String getLastName()
    {
        return lastname;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String getPassport()
    {
        return passportno;
    }
    
    public String getDoB()
    {
        return dateofbirth;
    }
    
    public String getemail()
    {
        return emailaddress;
    }
    
    public String getPhone()
    {
        return phoneno;
    }
}
