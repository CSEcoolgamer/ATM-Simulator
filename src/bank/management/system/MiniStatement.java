
package bank.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class MiniStatement extends JFrame implements ActionListener {
    
    JLabel mini, bank, card, bal;
    JButton b1;
    
    // constructor:
    MiniStatement(String pinnumber) {
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
        
        mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);
        
        // Heading:
        bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        // Card:
        card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        // Balance:
        bal = new JLabel();
        bal.setBounds(20, 400, 300, 20);
        add(bal);
        
        
        try { 
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pinnumber = '"+pinnumber+"' ");
            while(rs.next()) {
                card.setText("Card Number : " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" +rs.getString("cardnumber").substring(12));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            Conn conn = new Conn();
            int balance = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
            while (rs.next()) {
                
                // using HTML tag and nbsp we can add the spaces:
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount")); //convert the string into int. and then add it to balance;
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            
            bal.setText("Your Current Account Balance is : Rs " + balance);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        //Button Exit:
        b1 = new JButton("Exit");
        b1.setBounds(150, 500, 100, 25);
        b1.addActionListener(this);
        add(b1);
        
        
        
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String args[]) {
        new MiniStatement("").setVisible(true);
    }
    
}
