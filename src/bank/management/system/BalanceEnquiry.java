
package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber) {
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 800);
        add(image);
        
        
        back = new JButton("Back");
        back.setBounds(280, 460, 130, 25);
        back.addActionListener(this);
        image.add(back);
        
        
        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
                
            // For maintaining/calculating the balance:
                
            while(rs.next()) {    //rs.next is use to move the rows in the database
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount")); //convert the string into int. and then add it to balance;
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        // Heading:
        JLabel text = new JLabel("Your Current Amount Balance is Rs " + balance);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 12));
        text.setBounds(160, 250, 700, 35);
        image.add(text);
        
        
        
        setSize(750,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    
    public static void main(String args[]) {
        new BalanceEnquiry("").setVisible(true);
    }
}
