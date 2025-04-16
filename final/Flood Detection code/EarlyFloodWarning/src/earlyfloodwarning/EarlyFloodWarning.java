/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package earlyfloodwarning;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author lenovo
 */
public class EarlyFloodWarning {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
         LogInFrame lif=new LogInFrame();
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        lif.setVisible(true);
        lif.setSize(d);
    }
    
}
