package service;
import dao.EmployeeDAO;
import model.Employee;
import util.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeesService {

    private final EmployeeDAO  employeeDAO = new EmployeeDAO();
    private final Employee  employee = new Employee();
    private final List<Employee>  employeeList = employeeDAO.getAll();
    private static final Scanner in = new Scanner(System.in);
    private static final Util util = new Util();

    private boolean flag = false;
    public void showEmployees(){
        System.out.println(employeeDAO.getAll());
    }

    public void insertEmployees(){

        System.out.print("\tNhập id: ");
        int id = Integer.parseInt(in.nextLine());
        if (util.isCheckIdEmp(id)){
            System.out.println("<!> Id đã tồn tại <!>");
            return;
        };
        employee.setEmployeeID(id);
        //
        System.out.print("\tNhập họ tên: ");
        String fullName = in.nextLine();
        employee.setFullName(fullName);
        //
        System.out.print("\tNhập số điện thoại: ");
        String phone = in.nextLine();
        if (!util.isValidPhone(phone) && phone.length() != 10){
            System.out.println("<!> SĐT không đúng định dạng<!>");
            return;
        }
        employee.setPhone(phone);
        //
        System.out.print("\tNhập email: ");
        String email = in.nextLine();
        if (!util.isValidEmail(email)){
            System.out.println("<!> Email không hợp lệ <!>");
            return;
        }
        if (util.compareEmail(email)){
            System.out.println("<!> Email đã tồn tại <!>");
            return;
        }
        employee.setEmail(email);
        //
        System.out.print("\tNhập ngày/tháng/năm: ");
        String date = in.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);
        try {
            simpleDateFormat.parse(date);
        }
        catch (ParseException e) {
            System.out.println("<!> Ngày/tháng/năm không đúng định dạng <!>");
            return;
        }
        employee.setDateOfBirth(date);
        //
        System.out.print("\tNhập giới tính: ");
        String gender = in.nextLine();
        if (!util.isCheckGender(gender)){
            System.out.println("<!> Giới tính không chính xác <!>");
            return;
        }
        employee.setGender(gender);
        //
        System.out.print("\tNhập địa chỉ: ");
        String address = in.nextLine();
        if (address == null){
            System.out.println("<!> Địa chỉ không được để rỗng <!>");
            return;
        }
        employee.setAddress(address);
        //
        /*System.out.print("\tNhập tên công việc: ");
        String position = in.next();
        employee.setPosition(position);*/
        //
        System.out.print("\tNhập lương: ");
        int salary;
        try {
            salary = Integer.parseInt(in.nextLine());
        } catch (Exception e) {
            System.out.println("<!> Lương không đúng định dạng <!>");
            return;
        }
        employee.setSalary(salary);
        //
        /*System.out.print("\tNhập ID bộ phận: ");
        int depID = in.nextInt();
        employee.setDepartmentID(depID);*/

        employeeDAO.insert(employee);

        System.out.println("* Thêm thành công *");
    }


    public void getEmployeeById(){
        System.out.print("Nhập id: ");
        int id = in.nextInt();
        for (Employee empId : employeeList){
            if (empId.getEmployeeID() == id){
                flag = true;
                break;
            }
        }
        if (!flag){
            System.out.println("<!> Tài khoản không tồn tại <!>");
            return;
        }
        System.out.println(employeeDAO.getById(id));
    }

    public boolean isCheckNumberIp(int salary){

        return true;
    }

}
