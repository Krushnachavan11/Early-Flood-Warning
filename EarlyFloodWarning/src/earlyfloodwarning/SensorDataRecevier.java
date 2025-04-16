/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package earlyfloodwarning;

import java.util.ArrayList;
import jssc.SerialPort;
import jssc.SerialPortException;

/**
 *
 * @author welcome
 */
public class SensorDataRecevier extends Thread
{
    public static int count=0;
       public void run()
    {
         String str1;
         
        //In the constructor pass the name of the port with which we work
        SerialPort serialPort1 = new SerialPort("COM10");
      
        try {
            //Open port
            serialPort1.openPort();
         

            //We expose the settings. You can also use this line - serialPort.setParams(9600, 8, 1, 0);
            serialPort1.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
         

            Thread.sleep(1000);//Very important !!!


String val="";
            //Read data from port
       for (int i = 0; i >-1; i++) 
            {
                str1 = serialPort1.readString();
          
              // System.out.println("sensor Value "+str1);
        
                if (str1 != null) {
                 //  System.out.println(str1);
                 
                 if(str1.contains(":"))
                 {
                    // System.out.println(str1);
                     String st[] = str1.split(":");
                     val = st[1];
                     val = val.trim();
                     System.out.println("Water Level: " + val);
                     if(new DigitChecker().isDigit(val))
                     {
                         int x=Integer.parseInt(val);
                     if(x<=240)
                     {
                         count++;
                     }
                     }
                     
                

                    }
                   

                }
                

                  
                Thread.sleep(500);
            }
            
            //Closing the port
            serialPort1.closePort();
          

            

        } catch (SerialPortException ex) {
            System.out.println(ex);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
    
}
