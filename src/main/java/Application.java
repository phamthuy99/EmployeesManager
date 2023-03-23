import dao.EmployeeDAO;
import model.Department;
import model.Employee;
import service.AuthenService;
import service.EmployeesService;
import ui.UserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    static EmployeeDAO employeeDAO = new EmployeeDAO();
    static List<Employee> employeeList = new ArrayList<>();
    static List<Department> departmentList = new ArrayList<>();
    static Employee employee = new Employee();
    static Department department = new Department();
    static AuthenService authenService = new AuthenService();
    static EmployeesService employeesService = new EmployeesService();

    static UserInterface ui = new UserInterface();

    static Scanner in = new Scanner(System.in);
    static int option = -1;

    // Main
    public static void main(String[] args) {
        checkLogin();
        handleMenu();
    }
    private static void checkLogin(){
        System.out.println("-----------------ĐĂNG NHẬP-----------------");
        int count = 3;
        boolean isLoginSuccess = false;
        while(count != 0){
            count = count - 1;
            // Dang nhap truoc
            if(!isLoginSuccess){
                System.out.print("- Username: ");
                String username = in.nextLine();
                System.out.print("- Password: ");
                String password = in.nextLine();
                // Kiem tra xem dang nhap dc ko?
                isLoginSuccess = authenService.login(username, password);
            }
            if(count != 0 && !isLoginSuccess){
                System.out.printf("Bạn còn %d lần nhập !\n", count);
            }
        }
        if(!isLoginSuccess){
            System.out.println("\n<!> Đăng nhập thất bại <!>");
            System.exit(0);
        }
        System.out.println("* Đăng nhập thành công *");
    }

    private static void handleEmployeesManager(){
        do {
            // Hiển thị menu nhân viên
            ui.showEmployeesMenu();
            // Nhập dữ liệu
            inputMenu(12);
            // Chọn menu
            switch (option) {
                case 1 -> employeesService.showEmployees();
                case 12 -> handleMenu();
            }

        }
        while (option != 0);
        in.close();
    }

    private static void handleAccountsManager(){
        do {
            // Hiển thị menu tài khoản
            ui.showAccountMenu();
            // Nhập dữ liệu
            inputMenu(6);
            // Chọn menu
            switch (option) {
                case 1 -> authenService.showAllAccount();
                case 6 -> handleMenu();
            }
        }
        while (option != 0);
        in.close();
    }

    private static void handleMenu(){
        do {
            // Hiển thị menu chính
            ui.showMainMenu();
            // Nhập dữ liệu
            inputMenu(3);
            // Chọn menu
            switch (option) {
                case 1 -> handleAccountsManager();
                case 2 -> handleEmployeesManager();
                case 3 -> {
                    System.out.println("Đăng xuất thành công");
                    checkLogin();
                }
            }
        }
        while (option != 0);
        in.close();
    }

    private static void inputMenu(int max) {
        boolean isCheck = false;
        System.out.print("Nhập lựa chọn: ");
        try {
            option = Integer.parseInt(in.nextLine());
        } catch (Exception e) {
            System.out.println("<!> Nhập sai định dạng <!>");
            isCheck = true;
            //continue;
        }
        if (!isCheck) {
            if (option == 0) {
                System.out.println("<!> Thoát <!>");
            }else if (option > max){
                System.out.println("<!> Lựa chọn không hợp lệ <!>");
            }
            //continue;
        }
    }
}





