/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package earlyfloodwarning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author lenovo
 */
public class Login 
{
    public boolean doLogin(String username , String pass)
    {
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/earlyflooddetection","root","root");
            Statement st=con.createStatement();
            
            String query="select * from registrationinfo where user_name='"+username+"' and  password='"+pass+"'" ;
            ResultSet rs=st.executeQuery(query);
            
            if(rs.next())
            {
                flag=true;
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
