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
public class EditLocation 
{
    public boolean getEditLocation(int srno,String area, String ip)
    {
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/earlyflooddetection","root","root");
            Statement st=con.createStatement();
            String query="update locationinfo set  area='"+area+"',ip='"+ip+"' where sr_no='"+srno+"' ";
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
