/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package earlyfloodwarning;

import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class SerialNumber 
{
    public int getSerialNumber()
    {
        int srno=0;
        ArrayList SerialNum=new SerialNumberFetcher().getData();
       // System.out.println(SerialNum);
        
        
        if(SerialNum.isEmpty())
        {
            srno=1;
//            SerialNum.add(srno);
        }
        else
        {
            String big=(String)SerialNum.get(0);
                 int bg=Integer.parseInt(big);
            for (int i = 0; i < SerialNum.size(); i++) 
            {
                
                 
                 String sr=(String)SerialNum.get(i);
                 int s=Integer.parseInt(sr);
                 if(s>bg)
                 {
                     bg=s;
                 }
                srno=bg+1;
            }
//            SerialNum.add(srno);
        }
        SerialNum.add(srno);
       // System.out.println("Serial number: "+SerialNum);
        return srno;
    }
}
