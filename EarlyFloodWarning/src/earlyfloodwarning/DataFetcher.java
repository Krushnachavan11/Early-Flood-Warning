/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package earlyfloodwarning;

/**
 *
 * @author lenovo
 */
import java.sql.*;
import java.util.*;
public class DataFetcher
{
    public ArrayList getdata(String username)
    {
        ArrayList a1=new ArrayList();
       
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/earlyflooddetection","root","root");
            Statement st=con.createStatement();
            
            String query="select * from registrationinfo where user_name='"+username+"'" ;
            ResultSet rs=st.executeQuery(query);
            
           if(rs.next())
           {
                a1.add(rs.getString(1));
                a1.add(rs.getString(2));
                a1.add(rs.getString(3));
                a1.add(rs.getString(4));
                a1.add(rs.getString(5));
               // a1.add(rs.getString(6));
               
           }
           //System.out.println("a "+a1);
        }
        catch(Exception e)
        {
            System.out.println(e);
           
        }
      
    return a1;
    }
    
    
     public ArrayList getIPs()
    {
       
        ArrayList ar= new ArrayList();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/earlyflooddetection","root","root");
            Statement st=conn.createStatement();

            String query="Select * from locationinfo";
            ResultSet rs=st.executeQuery(query);

            while(rs.next())
            {
                  
           
            ar.add(rs.getString(3));
         
        
          
            }
          
    
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
       
      return ar;
    }
}
