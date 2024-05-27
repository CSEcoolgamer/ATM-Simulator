package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    
    JButton deposit, withdrawal, ministatement, pinchange, fastcash, balanceenquiry, exit;
    String pinnumber;
    
    Transactions(String pinnumber) {
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 800);
        add(image);
        
        
        // Heading :
        JLabel text = new JLabel("Please select your Transactions");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(160, 250, 700, 35);
        image.add(text);
        
        
        // Deposit Button:
        deposit = new JButton("Deposit");
        deposit.setBounds(140, 370, 130, 25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        
        // Cash-Withdrawl Button:
        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(280, 370, 130, 25);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        
        // Fast Cash Button:
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(140, 400, 130, 25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        
        // Mini-Statement Button: 
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(280, 400, 130, 25);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        
        // Pinchange Button:
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(140, 430, 130, 25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        
        // Balance Equiry Button:
        balanceenquiry = new JButton("Balance Equiry");
        balanceenquiry.setBounds(280, 430, 130, 25);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        
        // Exit Button:
        exit = new JButton("Exit");
        exit.setBounds(280, 460, 130, 25);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        setSize(750,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawal) {
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource() == ministatement) {
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Transactions("");
        
    }
    
}
