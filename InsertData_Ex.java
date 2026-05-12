package jdbc;

import java.sql.*;

public class InsertData_Ex {

    public static void main(String[] args) {

        try {

            String url = "jdbc:mysql://localhost:3306/wipro_db";
            String username = "root";
            String password = "Aryan@2003";

            Connection con = DriverManager.getConnection(url, username, password);

            Statement st = con.createStatement();

            String query = "INSERT INTO employees_ VALUES (5, 'Deva', 105, 30000)";

            int rows = st.executeUpdate(query);

            System.out.println(rows + " row inserted successfully");

            con.close();

        } catch (Exception e) {

            System.out.println(e);

        }
    }
}