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
public class ViewMaker 
{
    public void getDataView()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/earlyflooddetection","root","root");
            Statement st1=(Statement) con.createStatement();
            Statement st2=(Statement) con.createStatement();
            
            String query="select * from locationinfo";
            
            ResultSet rs1=st1.executeQuery(query);
            ResultSet rs2=st2.executeQuery(query);
            
             int row=0;
            
            while(rs1.next())
            {
                row++;
            }
            
            int i=0;
             String[][] data=new String[row][3];
              while(rs2.next())
            {
                String srno=rs2.getString(1);
                String area=rs2.getString(2);
                String ip=rs2.getString(3);
                data[i][0]=srno;
                data[i][1]=area;
                data[i][2]=ip;
                i++;
            }
             DataViewFrame.data1=data;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
