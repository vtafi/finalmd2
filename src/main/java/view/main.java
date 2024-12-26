package view;

import controller.MobileCHController;
import controller.MobileXTController;
import entity.MobileCH;
import entity.MobileXT;

import java.util.List;
import java.util.Scanner;

public class main {
    private static int id = 1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Chương trình quản lý điện thoại");
            System.out.println("1.Thêm mới điện thoại");
            System.out.println("2.Xóa điện thoại");
            System.out.println("3.Xem danh sách điện thoại");
            System.out.println("4.Tìm kiếm điện thoại");
            System.out.println("5.Thoát");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    menuDienThoai();
                    break;
                case 2:
                    break;
                case 3:
                    displayMobile();
                    break;
                case 4:
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Nhập sai vui lòng nhập lại");
            }
        }
    }
    public static void menuDienThoai(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Điện thoại của bạn là xách tay hay chính hãng.");
            System.out.println("1.Xách tay");
            System.out.println("2.Chính hãng");
            System.out.println("3.Trở lại");
            System.out.println("4.Mời bạn nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    menuMobileXT();
                    break;
                case 2:
                    menuMobileCH();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ vui lòng nhập lại.");
            }
        }
    }
    public static void menuMobileCH(){
        MobileCHController mobileCHController = new MobileCHController();
        Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập vào tên điện thoại: ");
            String name = scanner.nextLine();
            System.out.println("Nhập vào giá điện thoại: ");
            int price = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập vào số lượng điện thoại: ");
            int number = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập tên nhà sản xuất: ");
            String nameProduct = scanner.nextLine();
            System.out.println("Nhập vào thời gian bảo hành: ");
            int dateBH = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập phạm vi bảo hành: ");
            String pvBH = scanner.nextLine();
            MobileCH mobileCH = new MobileCH(id,name,price,number,nameProduct,dateBH,pvBH);
            mobileCHController.save(mobileCH);
            System.out.println("Đã thêm mới với id : "+ id);
            id++;
    }
    public static void menuMobileXT(){
        MobileXTController mobileXTController = new MobileXTController();
        Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập vào tên điện thoại: ");
            String name = scanner.nextLine();
            System.out.println("Nhập vào giá điện thoại: ");
            int price = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập vào số lượng điện thoại: ");
            int number = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập tên nhà sản xuất: ");
            String nameProduct = scanner.nextLine();
            System.out.println("Nhập quốc gia sản xuất: ");
            String country = scanner.nextLine();
            System.out.println("Nhập trạng thái của máy: ");
            String status = scanner.nextLine();
            MobileXT mobileXT = new MobileXT(id,name,price,number,nameProduct,country,status);
            mobileXTController.save(mobileXT);
            System.out.println("Đã thêm mới với id : "+ id);
            id++;
    }
    public static void displayMobile(){
        MobileCHController mobileCHController = new MobileCHController();
        MobileXTController mobileXTController = new MobileXTController();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Bạn muốn xem danh sách điện thoại nào ?");
            System.out.println("1. Xách tay");
            System.out.println("2. Chính hãng");
            System.out.println("3. Quay lại");
            System.out.println("Mời bạn nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            List<MobileCH> mobileCHs;
            List<MobileXT> mobileXTs;
            switch (choice){
                case 1:
                    mobileXTs =mobileXTController.getAll();
                    for (MobileXT mobileXT : mobileXTs){
                        System.out.println(mobileXT);
                    }
                    break;
                case 2:
                    mobileCHs = mobileCHController.getAll();
                    for (MobileCH mobileCH : mobileCHs){
                        System.out.println(mobileCH);
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Nhap sai. Vui long nhap lai");
            }
        }
    }
    public static void removeMobile(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Bạn muốn xóa máy chính hãng hay xách tay");
            System.out.println("1.Xách tay");
            System.out.println("2.Chính hãng");
            System.out.println("3.Quay lại");
            System.out.println("Mời bạn nhập lựa chọn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
            }

        }
    }
}
