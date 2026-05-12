package jdbc;

import java.sql.*;
import java.util.Scanner;

public class InsertStudent {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/wipro_db",
                    "root",
                    "Aryan@2003");

            // Create Table
            Statement st = con.createStatement();
            st.executeUpdate("CREATE TABLE IF NOT EXISTS students(" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "marks INT)");

            // User Input
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            // Insert Query
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO students VALUES(?,?,?)");

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, marks);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Record Inserted Successfully");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}