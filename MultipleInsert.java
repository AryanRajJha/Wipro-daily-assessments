package jdbc;

import java.sql.*;
import java.util.Scanner;

public class MultipleInsert {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/wipro_db",
                    "root",
                    "Aryan@2003");

            Statement st = con.createStatement();

            st.executeUpdate("CREATE TABLE IF NOT EXISTS employee(" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "salary DOUBLE)");

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO employee VALUES(?,?,?)");

            System.out.print("How many records you want to insert? ");
            int n = sc.nextInt();

            for (int i = 1; i <= n; i++) {

                System.out.println("\nEnter Employee " + i + " Details");

                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Salary: ");
                double salary = sc.nextDouble();

                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setDouble(3, salary);

                ps.executeUpdate();
            }

            System.out.println("Multiple Records Inserted Successfully");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}