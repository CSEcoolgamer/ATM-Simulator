
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, income, education, occupation;
    String formno;
    
    SignupTwo(String formno){
        
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
                
        //Page 2 Heading:
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(250,40,400,30);
        add(additionalDetails);
        
        //Religion:
        JLabel rel = new JLabel("Religion: ");
        rel.setFont(new Font("Raleway", Font.BOLD, 20));
        rel.setBounds(100,140,100,30);
        add(rel);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        //Category:
        JLabel cat = new JLabel("Category: ");
        cat.setFont(new Font("Raleway", Font.BOLD, 20));
        cat.setBounds(100,190,200,30);
        add(cat);
        
        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        
        //Income:
        JLabel in = new JLabel("Income: ");
        in.setFont(new Font("Raleway", Font.BOLD, 20));
        in.setBounds(100,240,200,30);
        add(in);
        
        String incomeCategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        
        //Educational Qualification:
        JLabel edu = new JLabel("Educational ");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100,290,200,30);
        add(edu);

        JLabel qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100,315,200,30);
        add(qualification);
        
        String educationValues[] = {"Non-Graduation", "Graduation", "Post-Graduation", "Doctrate", "Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        //Occupation:
        JLabel occ = new JLabel("Occupation: ");
        occ.setFont(new Font("Raleway", Font.BOLD, 20));
        occ.setBounds(100,390,200,30);
        add(occ);
        
        String occupationValues[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
        
        //Pan Number:
        JLabel panNumber = new JLabel("PAN Number: ");
        panNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        panNumber.setBounds(100,440,200,30);
        add(panNumber);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        
        
        //Aadhar Number:
        JLabel aadharNumber = new JLabel("Aadhar Number: ");
        aadharNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharNumber.setBounds(100,490,200,30);
        add(aadharNumber);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        
        
        //Senior Citizen:
        JLabel seniorCitizen = new JLabel("Senior Citizen: ");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100,540,200,30);
        add(seniorCitizen);
        
        //Radio Button for Senior Citizen:
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        //For clicking only one button at a time:
        ButtonGroup seniorCitizengroup = new ButtonGroup();
        seniorCitizengroup.add(syes);
        seniorCitizengroup.add(sno);
        
        
        //Existing Account:
        JLabel existingAccount = new JLabel("Existing Account: ");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100,590,200,30);
        add(existingAccount);
        
        //Radio Button for Existing Account:
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        //For clicking only one button at a time:
        ButtonGroup existingAccountgroup = new ButtonGroup();
        existingAccountgroup.add(eyes);
        existingAccountgroup.add(eno);
        
        
        //Next Button:
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(750,750);
        setLocation(300,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){ 
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        
        String seniorCitizen = null;
        if (syes.isSelected()){
            seniorCitizen = "Yes";
        } else if(sno.isSelected()){
            seniorCitizen = "No";
        }
        
        String existingAccount = null;
        if (eyes.isSelected()){
            existingAccount = "Yes";
        }else if (eno.isSelected()){
            existingAccount = "No";
        }
        
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
      
       
        try{
            Conn c = new Conn();
            // "String'"+variable+"'String"
            String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorCitizen+"', '"+existingAccount+"')";
            c.s.executeUpdate(query);      // DML command 
            
            
            //SignupThree object:
            setVisible(false);
            new SignupThree(formno).setVisible(true);
            
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new SignupTwo("");
    }
    
}
