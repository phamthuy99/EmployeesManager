package ui;

public class UserInterface {
    public void showMainMenu(){
        System.out.println("---------------- M E N U ----------------");
        System.out.println("1. Quản lý thông tin tài khoản");
        System.out.println("2. Quản lý nhân viên");
        System.out.println("3. Đăng xuất");
        System.out.println("0. Thoát");
    }
    public void showAccountMenu(){
        System.out.println("--------QUẢN LÝ THÔNG TIN TÀI KHOẢN--------");
        System.out.println("1. Danh sách tài khoản");
        System.out.println("2. Thêm tài khoản mới");
        System.out.println("3. Cập nhật thông tin tài khoản");
        System.out.println("4. Xóa tài khoản theo mã");
        System.out.println("5. Tìm kiếm tài khoản theo mã");
        System.out.println("6. Quay lại");
        System.out.println("0. Thoát");
    }
    public void showEmployeesMenu() {
        System.out.println("--------QUẢN LÝ THÔNG TIN NHÂN VIÊN--------");
        System.out.println("1. Danh sách nhân viên");
        System.out.println("2. Thêm nhân viên mới");
        System.out.println("3. Cập nhật thông tin nhân viên");
        System.out.println("4. Xóa nhân viên theo mã");
        System.out.println("5. Tìm kiếm nhân viên theo theo mã");
        System.out.println("6. Danh sách phòng ban");
        System.out.println("7. Thêm phòng ban mới");
        System.out.println("8. Cập nhật phòng ban");
        System.out.println("9. Xóa phòng ban theo mã");
        System.out.println("10. Chuyển phòng ban cho một nhân viên");
        System.out.println("11. Tính thuế thu nhập cá nhân");
        System.out.println("12. Quay lại");
        System.out.println("0. Thoát");
    }
}
