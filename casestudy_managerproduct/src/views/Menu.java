package views;

import controller.MaterialManager;
import model.Iphone;
import model.Phone;
import model.Samsung;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public MaterialManager materialManager = new MaterialManager();
    Scanner scanner = new Scanner(System.in);
    public void showMenu() {
        System.out.println(
                """
                         ______________________________________________________
                        |********MENU *****************************************|
                        |  1. Hiển thị sản phẩm                                |
                        |  2. Thêm sản phẩm                                    |
                        |  3. Sửa sản phẩm                                     |
                        |  4. Xóa sản phẩm                                     |
                        |  5. Tìm kiếm sản phẩm                                |
                        |  0. Thoát khỏi chương trình                          |
                         ______________________________________________________""");

    }
//    Thêm sản phẩm.
    public void addPhone() throws IOException {

        System.out.println("""
                Chon 1 để thêm Samsung
                Chọn 2 để thêm Iphon
                Chọn 0 thoát
                """);
        int k = 0;
        while (true) {
            try {
                k = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập lại.");
            }

        }
        switch (k) {
            case 1:
                addSamsung();
                menuW();
            case 2:
                addIphon();
                menuW();
            case 3: menuW();
        }


    }
    public void addSamsung(){
        System.out.println("Nhập mã sản phẩm Samsung : ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm Samsung : ");
        String name = scanner.nextLine();
        System.out.println("Nhập hãng sản xuất Samsung :");
        String trademark = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm Samsung :");
        double price = checkDouble();
        System.out.println("Nhập số lượng sản phẩm Samsung :");
        int quantity = checkInt();
        Phone s = new Samsung(id,name,trademark,price, quantity);
        try {
            materialManager.addNewMaterial(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addIphon () {
        System.out.println("Nhập mã sản phẩm iphone : ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm iphone : ");
        String name = scanner.nextLine();
        System.out.println("Nhập hãng sản xuất iphone :");
        String trademark = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm iphone :");
        double price = checkDouble();
        System.out.println("Nhập số lượng sản phẩm iphone :");
        int quantity = checkInt();
        Phone i = new Iphone(id, name, trademark, price, quantity);
        try {
            materialManager.addNewMaterial(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//    Xóa sản phẩm theo id.
    public void deleteProduct () {
        System.out.println("Mời bạn nhập mã ID sản phẩm cần xóa");
        String string = scanner.nextLine();
        try {
            materialManager.deleteProductByID(string);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//    Tìm kiếm sản phẩm theo id.
    public void findProductMN(){
        System.out.println("Nhập mã sản phẩm bạn tìm");
        String string = scanner.nextLine();
        try {
            materialManager.findProduct(string);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//    Sửa sản phẩm theo id.
    public void editPhone () throws IOException {
    System.out.println("""
                Chon 1 để sửa Samsung.
                Chọn 2 để sửa Iphon.
                Chọn 0 để thoát.
                """);
    int a = Integer.parseInt(scanner.nextLine());
    switch (a){
        case 1: editSamsung(); break;
        case 2:
            try {
                editIphon();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            break;
    }
    }
    public void editIphon () throws IOException {
        System.out.println("Nhập mã sản phẩm cần sửa iphone : ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm iphone : ");
        String name = scanner.nextLine();
        System.out.println("Nhập hãng sản xuất iphone :");
        String trademark = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm iphone :");
        double price = checkDouble();
        System.out.println("Nhập số lượng sản phẩm iphone :");
        int quantity = checkInt();
        Phone i = new Iphone(id, name, trademark, price, quantity);
        materialManager.editProduct(id,i);
    }

    public void editSamsung () throws IOException {
        System.out.println("Nhập mã sản phẩm cần sửa samsung : ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm samsung : ");
        String name = scanner.nextLine();
        System.out.println("Nhập hãng sản xuất samsung :");
        String trademark = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm samsung :");
        double price = checkDouble();
        System.out.println("Nhập số lượng sản phẩm samsung :");
        int quantity = checkInt();
        Phone i = new Iphone(id, name, trademark, price, quantity);
        materialManager.editProduct(id,i);
    }
    public void logIn() {
        System.out.println("Mời bạn nhập tên tk");
        String ui = scanner.nextLine();
        System.out.println("Mời bạn nhập pass");
        String pass = scanner.nextLine();
        if (ui.matches("admin")& pass.matches("123")){
            showMenu();
            try {
                menuW();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }else {
            System.out.println("Mời bạn nhập lại");
            logIn();
        }
    }
    public void menuW() throws IOException {
        int a = 0;
        while (true){
            try {
                showMenu();
                System.out.println("MỜI BẠN CHON SỐ ĐỂ CHỌN CHỨC NĂNG");
                a = Integer.parseInt(scanner.nextLine());
                if (a >= 0 && a <= 5){
                    break;}
            }catch (Exception e){
                System.out.println("Vui lòng nhập lại");
            }
        }
        switch (a) {
            case 1:
                materialManager.showMaterial();
                menuW();
            case 2:
                addPhone();
                menuW();
            case 3:
                editPhone();
                menuW();
            case 4:
                deleteProduct();
                menuW();
            case 5:
                findProductMN();
                menuW();
            case 0:
                System.out.println("[ Bạn đã thoát khỏi chương trình. ]");
                break;
        }
    }

    public Double checkDouble(){
        while (true){
            try {
                return Double.parseDouble(scanner.nextLine());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    public int checkInt(){
        while (true){
            try {
                return Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }



}
