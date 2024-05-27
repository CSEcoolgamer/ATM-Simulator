
package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton deposit, back;
    String pinnumber;
    
    Deposit(String pinnumber) {
        this.pinnumber = pinnumber; 
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 800);
        add(image);
        
        
        
        //Header section in Deposit section:
        JLabel text = new JLabel("Enter the amount you want to Deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(140, 250, 700, 35);
        image.add(text);
        
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(150, 300, 260, 25);
        image.add(amount);
        
        
        // Deposit Button:
        deposit = new JButton("Deposit");
        deposit.setBounds(280, 430, 130, 25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        
        //Back Button:
        back = new JButton("Back");
        back.setBounds(280, 460, 130, 25);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(750,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Deposit");             
            } else {
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    
    public static void main(String args[]) {
        new Deposit("");
    } 
}
