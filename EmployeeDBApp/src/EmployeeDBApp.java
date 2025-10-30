import java.sql.*;
import java.util.Scanner;

public class EmployeeDBApp {
    static final String URL = "jdbc:mysql://localhost:3306/companydb";
    static final String USER = "root";      // your MySQL username
    static final String PASSWORD = "";  // your MySQL password

    static Connection con;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection(
            	    "jdbc:mysql://localhost:3306/employeedb",
            	    "root",
            	    ""  // <---- empty string, not null
            	);
            	

            Scanner sc = new Scanner(System.in);
            int choice;
            do {
                System.out.println("\n=== Employee Database ===");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                case 1:
                    addEmployee(sc);
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployee(sc);
                    break;
                case 4:
                    deleteEmployee(sc);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }

            } while (choice != 5);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void addEmployee(Scanner sc) throws SQLException {
        System.out.print("Enter name: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("Enter department: ");
        String dept = sc.nextLine();
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        String sql = "INSERT INTO employee (name, department, salary) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, dept);
        ps.setDouble(3, salary);
        ps.executeUpdate();
        System.out.println(" Employee added successfully!");
    }

    static void viewEmployees() throws SQLException {
        String sql = "SELECT * FROM employee";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\nID | Name | Department | Salary");
        System.out.println("--------------------------------");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " | " +
                               rs.getString("name") + " | " +
                               rs.getString("department") + " | " +
                               rs.getDouble("salary"));
        }
    }

    static void updateEmployee(Scanner sc) throws SQLException {
        System.out.print("Enter employee ID to update: ");
        int id = sc.nextInt();
        System.out.print("Enter new salary: ");
        double newSalary = sc.nextDouble();

        String sql = "UPDATE employee SET salary = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, newSalary);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();
        if (rows > 0)
            System.out.println(" Employee updated successfully!");
        else
            System.out.println(" Employee not found!");
    }

    static void deleteEmployee(Scanner sc) throws SQLException {
        System.out.print("Enter employee ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM employee WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        if (rows > 0)
            System.out.println("Employee deleted successfully!");
        else
            System.out.println(" Employee not found!");
    }
}
