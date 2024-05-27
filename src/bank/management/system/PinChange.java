
package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener {
    
    
    JPasswordField pin, repin;
    JButton change, back;
    JLabel text, pintext, repintext;
    String pinnumber;
    
    PinChange(String pinnumber) {
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 800);
        add(image);
        
         
        // Heading:
        text = new JLabel("Change Your PIN ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(220, 250, 700, 35);
        image.add(text);
        
        
        // New Pin:
        pintext = new JLabel("New PIN: ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 12));
        pintext.setBounds(140, 300, 180, 25);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(260, 300, 160, 25);
        image.add(pin);
        
        
        // Re-Enter New Pin:
        repintext = new JLabel("Re-Enter New PIN: ");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 12));
        repintext.setBounds(140, 340, 180, 25);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(260, 340, 160, 25);
        image.add(repin);
        
                
        // Change Button:
        change = new JButton("Change");
        change.setBounds(280, 430, 130, 25);
        change.addActionListener(this);
        image.add(change);
        
        
        // Back Button:
        back = new JButton("Back");
        back.setBounds(280, 460, 130, 25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(750,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change){
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
            
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN Doesn't Match");
                    return;
                }
                
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter New PIN");
                    return;
                }
                
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";
                String query2 = "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";
                String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                
                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                
                setVisible(false);
                new Transactions(rpin).setVisible(true);
                
            } catch (Exception e) {
                 System.out.println(e);
            }
            
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    
    public static void main(String args[]) {
        
        new PinChange("").setVisible(true);
        
    }
    
}
