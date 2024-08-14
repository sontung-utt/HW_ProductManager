package view;

import input.Input;
import manager.BrandManager;
import model.Brand;

import java.util.List;

public class MenuBrand {
    BrandManager brandManager = new BrandManager();
    public void showMenuBrand() {
        int choice;
        do {
            System.out.println("========Quản lý thương hiệu========");
            System.out.println("1. Thêm mới thương hiệu");
            System.out.println("2. Sửa thông tin thương hiệu");
            System.out.println("3. Xóa thương hiệu");
            System.out.println("4. Hiển thị danh sách thương hiệu");
            System.out.println("0. Thoát chương trình quản lý thương hiệu");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch(choice) {
                case 1:
                    showAddBrand();
                    break;
                case 2:
                    showEditBrand();
                    break;
                case 3:
                    showRemoveBrand();
                    break;
                case 4:
                    showAllBrand();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý thương hiệu!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp! Yêu cầu nhập lại.");
                    break;
            }
        } while (choice!=0);
    }

    private void showAddBrand() {
        System.out.println("=====Thêm mới thương hiệu=====");
        System.out.print("Nhập tên thương hiệu: ");
        String name = Input.inputString();
        Brand brand = new Brand(name);
        brandManager.add(brand);
        System.out.println("Thêm thương hiệu thành công!");
    }

    private void showEditBrand() {
        System.out.println("=====Sửa thông tin thương hiệu=====");
        System.out.print("Nhập mã thương hiệu muốn sửa: ");
        int idEdit = Input.inputInteger();
        if (brandManager.findIndexById(idEdit)!=-1) {
            System.out.print("Nhập tên thương hiệu: ");
            String name = Input.inputString();
            Brand brand = new Brand(idEdit,name);
            brandManager.update(idEdit,brand);
            System.out.println("Sửa thông tin thương hiệu thành công!");
        } else {
            System.out.println("Không tìm thấy mã thương hiệu!");
        }
    }

    private void showRemoveBrand() {
        System.out.println("=====Xóa thương hiệu=====");
        System.out.print("Nhập mã thương hiệu muốn xóa: ");
        int idRemove = Input.inputInteger();
        if (brandManager.findIndexById(idRemove)!=-1){
            brandManager.remove(idRemove);
            System.out.println("Xóa thương hiệu thành công!");
        } else {
            System.out.println("Không tìm thấy mã thương hiệu!");
        }
    }

    private void showAllBrand() {
        System.out.println("=====Danh sách thương hiệu=====");
        List<Brand> brandList = brandManager.getAll();
        for (Brand brand : brandList) {
            System.out.println(brand);
        }
    }
}
