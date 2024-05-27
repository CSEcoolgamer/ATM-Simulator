//JDBC connectivity:
/*
    1.Register the Driver:
    2.Create Connection:
    3.Create Statement:
    4.Execute Query:
    5.Close Connection:
*/

package bank.management.system;

import java.sql.*;

public class Conn {
     
    Connection c;
    Statement s;
    public Conn(){
        //MYSQL is external entity: Chances of errors will be there(Runtime errors)
        // So to catch the error we'll do EXCEPTIONAL HANDLING.
        try{
            //Register the driver: class-Class & static method-forName(ClassName)
            
            //Now, java can automatically register the driver.
            //Class.forName(com.mysql.cj.jdbc.Driver);
            
            //Create Connection:
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Sachin@24012002");
            // c = DriverManager.getConnection("jdbc:mysql://localhost:3306"); //default db runs on localhost:3306

            //Create statement:
            s = c.createStatement();
        } catch (Exception e){
            System.out.println(e);
        }
        
    }
    
}
