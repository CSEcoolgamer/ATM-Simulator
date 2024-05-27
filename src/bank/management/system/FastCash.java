package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton rs100, rs500, rs1000, rs2000, rs5000, rs10000, back;
    String pinnumber;
    
    FastCash(String pinnumber) {
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 800);
        add(image);
        
        
        // Heading :
        JLabel text = new JLabel("Select  Withdrawal  Amount");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(180, 250, 700, 35);
        image.add(text);
        
        
        rs100 = new JButton("Rs 100");
        rs100.setBounds(140, 370, 130, 25);
        rs100.addActionListener(this);
        image.add(rs100);
        
        
        rs500 = new JButton("Rs 500");
        rs500.setBounds(280, 370, 130, 25);
        rs500.addActionListener(this);
        image.add(rs500);
        
        
        rs1000 = new JButton("Rs 1000");
        rs1000.setBounds(140, 400, 130, 25);
        rs1000.addActionListener(this);
        image.add(rs1000);
        
        
        rs2000 = new JButton("Rs 2000");
        rs2000.setBounds(280, 400, 130, 25);
        rs2000.addActionListener(this);
        image.add(rs2000);
        
        
        rs5000 = new JButton("Rs 5000");
        rs5000.setBounds(140, 430, 130, 25);
        rs5000.addActionListener(this);
        image.add(rs5000);
        
        
        rs10000 = new JButton("Rs 10000");
        rs10000.setBounds(280, 430, 130, 25);
        rs10000.addActionListener(this);
        image.add(rs10000);
        
        
        // Exit Button:
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
        if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            // extract the amount (which is displayed on the particular button)
            String amount = ((JButton)ae.getSource()).getText().substring(3); // Rs 100
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
                
                // For maintaining/calculating the balance:
                int balance = 0;
                while(rs.next()) {    //rs.next is use to move the rows in the database
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount")); //convert the string into int. and then add it to balance;
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawal', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " +amount+ " Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            } catch (Exception e) {
                System.out.println(e);
            }
        } 
    }
    
    public static void main(String args[]){
        new FastCash("");
        
    }
    
}
