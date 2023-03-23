package service;

import dao.EmployeeDAO;
import model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeesService {

    private final EmployeeDAO  employeeDAO = new EmployeeDAO();
    //private final List<Employee>  employeeList = new ArrayList<>();
    public void showEmployees(){
        System.out.println(employeeDAO.getAll());
    }


}
