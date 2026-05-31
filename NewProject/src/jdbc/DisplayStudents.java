package jdbc;

import java.sql.*;

public class DisplayStudents {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/wipro_db",
                    "root",
                    "Aryan@2003");

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM students");

            System.out.println("ID\tNAME\tMARKS");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getInt("marks"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}