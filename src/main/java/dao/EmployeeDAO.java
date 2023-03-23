package dao;

import connection.MyConnection;
import model.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public List<Employee> getAll() {

        final String sql = "SELECT * FROM employees ";

        List<Employee> employeeList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Employee e = new Employee();
                e.setEmployeeID(rs.getInt("EmployeeID"));
                e.setFullName(rs.getString("FullName"));
                e.setPhone(rs.getString("Phone"));
                e.setEmail(rs.getString("Email"));
                e.setDateOfBirth(rs.getString("DateOfBirth"));
                e.setGender(rs.getString("Gender"));
                e.setAddress(rs.getString("Address"));
                e.setPosition(rs.getString("Position"));
                e.setSalary(rs.getDouble("Salary"));
                e.setDepartmentID(rs.getInt("DepartmentID"));
                employeeList.add(e);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employeeList;
    }

}
