package jdbc;

import java.sql.*;
import java.util.Scanner;

public class LoginValidation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/wipro_db",
                    "root",
                    "Aryan@2003");

            // Create users table
            Statement st = con.createStatement();

            st.executeUpdate("CREATE TABLE IF NOT EXISTS users(" +
                    "username VARCHAR(50), " +
                    "password VARCHAR(50))");

            // Insert sample user
            st.executeUpdate(
                    "INSERT INTO users VALUES('admin','1234')");

            // User Input
            System.out.print("Enter Username: ");
            String uname = sc.nextLine();

            System.out.print("Enter Password: ");
            String pass = sc.nextLine();

            // Validation Query
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM users WHERE username=? AND password=?");

            ps.setString(1, uname);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Invalid Username or Password");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}