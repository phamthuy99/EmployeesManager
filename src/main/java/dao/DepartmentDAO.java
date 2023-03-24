package dao;
import connection.MyConnection;
import model.Department;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    public List<Department> getAll() {

        final String sql = "SELECT * FROM departments ";

        List<Department> departmentList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Department d = new Department();
                d.setDepartmentId(rs.getInt("DepartmentId"));
                d.setDepartmentName(rs.getString("DepartmentName"));
                d.setManagerId(rs.getInt("ManagerId"));
                departmentList.add(d);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return departmentList;
    }

}
