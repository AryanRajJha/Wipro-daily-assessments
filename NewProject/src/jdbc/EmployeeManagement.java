package jdbc;

import java.sql.*;

public class EmployeeManagement {

    static final String URL = "jdbc:mysql://localhost:3306/company_db";
    static final String USER = "root";
    static final String PASSWORD = "Aryan@2003";

    public static void main(String[] args) {

        try {

            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connection
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully!");

            // ==============================
            // 1. Insert Records
            // ==============================

            String insertQuery = "INSERT INTO employees VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(insertQuery);

            ps.setInt(1, 106);
            ps.setString(2, "Rohan");
            ps.setString(3, "IT");
            ps.setDouble(4, 65000);
            ps.executeUpdate();

            ps.setInt(1, 107);
            ps.setString(2, "Neha");
            ps.setString(3, "HR");
            ps.setDouble(4, 47000);
            ps.executeUpdate();

            ps.setInt(1, 108);
            ps.setString(2, "Karan");
            ps.setString(3, "Finance");
            ps.setDouble(4, 85000);
            ps.executeUpdate();

            ps.setInt(1, 109);
            ps.setString(2, "Simran");
            ps.setString(3, "Marketing");
            ps.setDouble(4, 55000);
            ps.executeUpdate();

            ps.setInt(1, 110);
            ps.setString(2, "Aditya");
            ps.setString(3, "IT");
            ps.setDouble(4, 72000);
            ps.executeUpdate();

            System.out.println("5 Employee Records Inserted Successfully!");

            // ==============================
            // 2. Fetch Salary > 50000
            // ==============================

            String fetchQuery = "SELECT * FROM employees WHERE salary > ?";

            PreparedStatement ps2 = con.prepareStatement(fetchQuery);

            ps2.setDouble(1, 50000);

            ResultSet rs = ps2.executeQuery();

            System.out.println("\nEmployees with Salary > 50000");

            while(rs.next()) {

                System.out.println(
                        rs.getInt("emp_id") + " "
                        + rs.getString("emp_name") + " "
                        + rs.getString("department") + " "
                        + rs.getDouble("salary")
                );
            }

            // ==============================
            // 3. Delete Employee by ID
            // ==============================

            String deleteQuery = "DELETE FROM employees WHERE emp_id = ?";

            PreparedStatement ps3 = con.prepareStatement(deleteQuery);

            ps3.setInt(1, 107);

            int deleted = ps3.executeUpdate();

            System.out.println("\nDeleted Records: " + deleted);

            // ==============================
            // 4. Update Employee Salary
            // ==============================

            String updateQuery =
                    "UPDATE employees SET salary = ? WHERE emp_id = ?";

            PreparedStatement ps4 = con.prepareStatement(updateQuery);

            ps4.setDouble(1, 90000);
            ps4.setInt(2, 108);

            int updated = ps4.executeUpdate();

            System.out.println("Updated Records: " + updated);

            // ==============================
            // 5. Call Stored Procedure
            // ==============================

            CallableStatement cs =
                    con.prepareCall("{CALL searchEmployee(?)}");

            cs.setInt(1, 108);

            ResultSet rs2 = cs.executeQuery();

            System.out.println("\nStored Procedure Result");

            while(rs2.next()) {

                System.out.println(
                        rs2.getInt("emp_id") + " "
                        + rs2.getString("emp_name") + " "
                        + rs2.getString("department") + " "
                        + rs2.getDouble("salary")
                );
            }

            // ==============================
            // 6. Count Total Employees
            // ==============================

            String countQuery = "SELECT COUNT(*) FROM employees";

            Statement st = con.createStatement();

            ResultSet rs3 = st.executeQuery(countQuery);

            if(rs3.next()) {

                System.out.println(
                        "\nTotal Employees: " + rs3.getInt(1)
                );
            }

            // ==============================
            // 7. Highest Salary Employee
            // ==============================

            String highestQuery =
                    "SELECT * FROM employees ORDER BY salary DESC LIMIT 1";

            ResultSet rs4 = st.executeQuery(highestQuery);

            System.out.println("\nHighest Salary Employee");

            while(rs4.next()) {

                System.out.println(
                        rs4.getInt("emp_id") + " "
                        + rs4.getString("emp_name") + " "
                        + rs4.getDouble("salary")
                );
            }

            // ==============================
            // 8. Login Validation
            // ==============================

            String loginQuery =
                    "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement ps5 = con.prepareStatement(loginQuery);

            ps5.setString(1, "admin");
            ps5.setString(2, "admin123");

            ResultSet rs5 = ps5.executeQuery();

            if(rs5.next()) {

                System.out.println("\nLogin Successful!");

            } else {

                System.out.println("\nInvalid Credentials!");
            }

            // ==============================
            // 9. Department-wise Employees
            // ==============================

            String deptQuery =
                    "SELECT * FROM employees WHERE department=?";

            PreparedStatement ps6 = con.prepareStatement(deptQuery);

            ps6.setString(1, "IT");

            ResultSet rs6 = ps6.executeQuery();

            System.out.println("\nIT Department Employees");

            while(rs6.next()) {

                System.out.println(
                        rs6.getInt("emp_id") + " "
                        + rs6.getString("emp_name")
                );
            }

            // ==============================
            // 10. Display All Employees (CRUD Read)
            // ==============================

            String displayQuery = "SELECT * FROM employees";

            ResultSet rs7 = st.executeQuery(displayQuery);

            System.out.println("\nAll Employees");

            while(rs7.next()) {

                System.out.println(
                        rs7.getInt("emp_id") + " "
                        + rs7.getString("emp_name") + " "
                        + rs7.getString("department") + " "
                        + rs7.getDouble("salary")
                );
            }

            // Close Connection
            con.close();

            System.out.println("\nConnection Closed!");

        } catch(Exception e) {

            System.out.println(e);
        }
    }
}