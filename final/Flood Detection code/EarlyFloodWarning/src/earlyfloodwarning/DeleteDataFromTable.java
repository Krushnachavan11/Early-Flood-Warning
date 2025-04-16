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
public class DeleteDataFromTable 
{
     public void getButtonDataDeleted(String cell)
    {
         boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/earlyflooddetection","root","root");
            Statement st=con.createStatement();
            
            String query="delete from locationinfo where sr_no='"+cell+"'";
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
       // return flag;    
    }
}
