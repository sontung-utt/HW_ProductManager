package view;

import input.Input;

public class MainMenu {
    MenuProduct menuProduct = new MenuProduct();
    MenuBrand menuBrand = new MenuBrand();
    MenuCategory menuCategory = new MenuCategory();
     public void showMainMenu() {
         int choice;
         do {
             System.out.println("=========Trang chủ==========");
             System.out.println("1. Quản lý sản phẩm");
             System.out.println("2. Quản lý loại sản phẩm");
             System.out.println("3. Quản lý thương hiệu");
             System.out.println("0. Thoát chương trình");
             System.out.print("Nhập lựa chọn: ");
             choice = Input.inputInteger();
             switch (choice) {
                 case 1:
                     menuProduct.showMenuProduct();
                     break;
                 case 2:
                     menuCategory.showMenuCategory();
                     break;
                 case 3:
                     menuBrand.showMenuBrand();
                     break;
                 case 0:
                     System.out.println("Thoát chương trình!");
                     break;
                 default:
                     System.out.println("Không có lựa chọn phù hợp! Yêu cầu nhập lại.");
                     break;
             }
         } while(choice!=0);
     }
}
