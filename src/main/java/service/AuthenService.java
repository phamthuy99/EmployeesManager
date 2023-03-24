package service;
import dao.AccountDAO;
import model.Account;
import java.util.List;
import java.util.Scanner;

public class AuthenService {
    private final AccountDAO accountDAO = new AccountDAO();
    private final List<Account> accountList = accountDAO.getAll();
    private final Account account = new Account();
    private final Scanner in = new Scanner(System.in);
    private boolean flag = false;

    public boolean login(String userName, String password){
        Account account = accountDAO.getByUserNameAndPassword(userName, password);
        return account != null;
    }

    public void showAllAccount(){
        System.out.println(accountDAO.getAll());
    }
    public void insertAccount(){
        System.out.print("Nhập username: ");
        String user = in.nextLine();
        for (Account accUser : accountList){
            if (accUser.getUsername().equalsIgnoreCase(user)){
                flag = true;
                break;
            }
        }
        if (flag){
            System.out.println("<!> Tài khoản đã tồn tại <!>");
            return;
        }
        account.setUsername(user);
        System.out.print("Nhập password: ");
        account.setPassword(in.nextLine());
        accountDAO.insert(account);
        System.out.println("* Thêm thành công *");
    }
    public void updateAccount(){
        System.out.print("Nhập id: ");
        int id = in.nextInt();
        checkId(id);
        System.out.print("Nhập username: ");
        account.setUsername(in.next());
        System.out.print("Nhập password: ");
        account.setPassword(in.next());
        accountDAO.update(account , id);
        System.out.println("* Update thành công *");
    }

    public void deleteAccount()
    {
        System.out.print("Nhập id: ");
        int id = in.nextInt();
        checkId(id);
        accountDAO.delete(id);
        System.out.println("* Xóa thành công *");
    }

    public void findAccount()
    {
        System.out.print("Nhập id: ");
        int id = in.nextInt();
        checkId(id);
        System.out.println(accountDAO.getById(id));
    }

    public void checkId(int id){
        for (Account userId : accountList){
            if (userId.getId() == id){
                flag = true;
                break;
            }
        }
        if (!flag){
            System.out.println("<!> Tài khoản không tồn tại <!>");
            return;
        }
    }


}
