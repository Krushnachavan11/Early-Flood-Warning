/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package flood_detection01;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


/**
 *
 * @author Mohit
 */
public class ServerReceiver extends Thread{
    public void run()
    {
     String main="D://Danger Sms.mp3";
        
       
        System.out.println("Recevier Starter");
        try
        {
            ServerSocket s= new ServerSocket(1215);
            while(true)
            {
                Socket ss= s.accept();
                InputStream is = ss.getInputStream();
                DataInputStream dis= new DataInputStream(is);
                String ms=dis.readUTF();
                System.out.println(ms);
                   
               if(ms.equals("Flood Occured"))
               {
                  new AlertGen().generateAlert(main);;
               }

     }
            }
        
        catch(Exception e)
        {

        }
       
    }
}
