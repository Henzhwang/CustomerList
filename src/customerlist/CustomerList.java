/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerlist;

/**
 *
 * @author HenryHwang
 */

import java.io.*;
import javax.swing.*;
public class CustomerList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
       String name, address, city, province, posCod;
       String fileName = "CustomerList.txt";
       String lines = null;
       int customersNum = 0;
       
       BufferedReader readFile = new BufferedReader (new FileReader(fileName));
       
       while((lines = readFile.readLine()) != null)
       {
           System.out.println(lines);
       }
       
       PrintWriter fileOut = new PrintWriter (new FileWriter(fileName,true));
       
       while (true)
       {
           try
           {
               customersNum = Integer.parseInt(JOptionPane.showInputDialog("How many " 
               + "customers do you want to input today?"));
           }
           catch(Exception e)
           {
               JOptionPane.showMessageDialog(null, "Plaese enter an integer!");
           }
           break;
       }
       
       for (int i = 0; i< customersNum; i++)
       {
           JOptionPane.showMessageDialog(null,"Time to InPut");
           JOptionPane.showMessageDialog(null,"Customer" + (i + 1) + " :");
           
           name = JOptionPane.showInputDialog("What is the name of the customer ?");
           address = JOptionPane.showInputDialog("What is the address of the customer ?");
           province = JOptionPane.showInputDialog("What province is the customer from ?");
           
           while (true)
           {
               posCod = JOptionPane.showInputDialog("What is the customer's postal code ?" + "\nNote:No Space needed!");
               
               if (Character.isLetter(posCod.charAt(0)) && Character.isDigit(posCod.charAt(1))
               && Character.isLetter(posCod.charAt(2)) && Character.isDigit(posCod.charAt(3))
               && Character.isLetter(posCod.charAt(4)) && Character.isDigit(posCod.charAt(5)))
                       {
                            JOptionPane.showMessageDialog(null, "Thanks for inputting "
                                    + "customers throuh our software\n\n We promise this "
                                    + "info will not leak or be used!");
                       }
               else
               {
                   JOptionPane.showMessageDialog(null,"Please enter the correct format of postal code!");
               }
               break;
           }
           
           fileOut.println("Name: " + name);
           fileOut.println("\nAddress: " + address);
           fileOut.println("\nProvince: " +province);       
           fileOut.println("\nPostal Code: " +posCod); 
           
           fileOut.println("---------------------------------");
       }
           fileOut.close();
       }
       
    }
