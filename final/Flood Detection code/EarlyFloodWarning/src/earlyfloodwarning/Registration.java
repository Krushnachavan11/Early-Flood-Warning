/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package earlyfloodwarning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author lenovo
 */
public class Registration 
{
    public boolean doRegistration(String name,  String email, String mob, String username, String pass)
    {
        boolean flag=false;
         try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/earlyflooddetection","root","root");
            Statement st=con.createStatement();
            
            String query="insert into registrationinfo values ('"+name+"','"+email+"','"+mob+"','"+username+"','"+pass+"')";
            int x=st.executeUpdate(query);
            if(x>0)
            {
                flag=true;
            }
            else
            {
                flag=false;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            flag=false;
        }
        return flag;
    }
}
