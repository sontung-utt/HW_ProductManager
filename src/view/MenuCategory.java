package view;

import input.Input;
import manager.CategoryManager;
import model.Category;

import java.util.List;

public class MenuCategory {
    CategoryManager categoryManager = new CategoryManager();
    public void showMenuCategory() {
        int choice;
        do {
            System.out.println("========Quản lý loại sản phẩm========");
            System.out.println("1. Thêm mới loại sản phẩm");
            System.out.println("2. Sửa thông tin loại sản phẩm");
            System.out.println("3. Xóa loại sản phẩm");
            System.out.println("4. Hiển thị danh sách loại sản phẩm");
            System.out.println("0. Thoát chương trình quản lý loại sản phẩm");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch(choice) {
                case 1:
                    showAddCategory();
                    break;
                case 2:
                    showEditCategory();
                    break;
                case 3:
                    showRemoveCategory();
                    break;
                case 4:
                    showAllCategory();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý loại sản phẩm!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp! Yêu cầu nhập lại.");
                    break;
            }
        } while (choice!=0);
    }

    private void showAddCategory(){
        System.out.println("=====Thêm mới loại sản phầm=====");
        System.out.print("Nhập tên loại sản phẩm: ");
        String name = Input.inputString();
        Category category = new Category(name);
        categoryManager.add(category);
        System.out.println("Thêm loại sản phẩm thành công!");
    }

    private void showEditCategory() {
        System.out.println("=====Sửa thông tin loại sản phẩm=====");
        System.out.print("Nhập mã loại sản phẩm muốn sửa: ");
        int idEdit = Input.inputInteger();
        if(categoryManager.findIndexById(idEdit)!=-1){
            System.out.print("Nhập tên loại sản phẩm: ");
            String name = Input.inputString();
            Category category = new Category(idEdit, name);
            categoryManager.update(idEdit, category);
            System.out.println("Sửa thông tin loại sản phẩm thành công!");
        } else {
            System.out.println("Không tìm thấy mã loại sản phẩm!");
        }
    }

    private void showRemoveCategory() {
        System.out.println("=====Xóa loại sản phẩm=====");
        System.out.print("Nhập mã loại sản phẩm muốn xóa: ");
        int idRemove = Input.inputInteger();
        if(categoryManager.findIndexById(idRemove)!=-1){
            categoryManager.remove(idRemove);
            System.out.println("Xóa loại sản phẩm thành công!");
        } else {
            System.out.println("Không tìm thấy mã loại sản phẩm!");
        }
    }

    private void showAllCategory() {
        System.out.println("=====Danh sách loại sản phẩm=====");
        List<Category> categoryList = categoryManager.getAll();
        for (Category category : categoryList) {
            System.out.println(category);
        }
    }
}
