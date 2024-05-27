# ATM-Simulator-System

## Overview
The ATM-Simulator-System is a secure and efficient internet banking application developed using Java, Apache Server Pages, and MySQL. It provides comprehensive net banking facilities, including secure login, money transfers, and interbank transactions. The system also integrates with Western Union for fund transfers, supports payee management, and implements robust user authentication mechanisms to ensure the highest level of security for users.

## Features
- *Secure Login*: Ensures user authentication through robust mechanisms.
- *Money Transfers*: Allows users to transfer funds within the bank and to other banks.
- *Interbank Transactions*: Facilitates transactions between different banks.
- *Western Union Integration*: Supports fund transfers via Western Union.
- *Payee Management*: Allows users to add, edit, and manage payees for quick transactions.
- *High-Level Security*: Implements strong authentication and security protocols to protect user data and transactions.

## Technologies Used
- *Java*: Core language for application development.
- *Apache Server Pages (ASP)*: For dynamic web page generation and handling server-side operations.
- *MySQL*: Database management system to store user data, transaction history, and other relevant information.

## Installation and Setup
### Prerequisites
- Java Development Kit (JDK) installed on your machine.
- Apache Tomcat server for deploying JSP files.
- MySQL database server.

### Steps
1. *Clone the Repository*
   sh
   git clone https://github.com/yourusername/ATM-Simulator-System.git
   cd ATM-Simulator-System
   

2. *Set Up the Database*
   - Install MySQL server.
   - Create a database named atm_simulator.
   - Import the provided SQL script (database.sql) to set up the required tables and initial data.
     sh
     mysql -u root -p atm_simulator < database.sql
     

3. *Configure Database Connection*
   - Update the database connection settings in the application's configuration file (dbconfig.properties):
     properties
     db.url=jdbc:mysql://localhost:3306/atm_simulator
     db.username=root
     db.password=yourpassword
     

4. *Deploy the Application*
   - Deploy the application on the Apache Tomcat server by copying the project to the webapps directory of Tomcat.
   - Start the Tomcat server:
     sh
     <TOMCAT_HOME>/bin/startup.sh
     

5. *Access the Application*
   - Open your web browser and navigate to http://localhost:8080/ATM-Simulator-System.

## Usage
1. *Login*
   - Use your credentials to log in securely.
2. *Dashboard*
   - Access your account dashboard to view balance, transaction history, and other details.
3. *Fund Transfer*
   - Use the money transfer feature to send funds within the bank or to other banks.
4. *Western Union Transfer*
   - Integrate and use Western Union for international fund transfers.
5. *Manage Payees*
   - Add or remove payees to streamline your transaction process.

## Security
The ATM-Simulator-System employs robust security measures, including:
- *Encryption*: All sensitive data is encrypted.
- *Authentication*: Multi-factor authentication mechanisms ensure secure access.
- *Audit Trails*: All transactions are logged for security audits and monitoring.


---

Thank you for using the ATM-Simulator-System! We hope it meets all your internet banking needs securely and efficiently.
