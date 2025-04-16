/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package earlyfloodwarning;

/**
 *
 * @author Lenovo
 */
public class DigitChecker 
{
    public boolean isDigit(String str)
    {
        boolean flag=false;
        try
        {
            int x=Integer.parseInt(str);
            flag=true;
        }
        catch(Exception ex)
        {
           
            System.out.println("Exception ex "+ex);
        }
        return flag;
    }
}
