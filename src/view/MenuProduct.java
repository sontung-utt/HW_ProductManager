package view;

import input.Input;
import manager.BrandManager;
import manager.CategoryManager;
import manager.ProductManager;
import model.Product;
import model.Brand;
import model.Category;

import java.util.List;

public class MenuProduct {

    ProductManager productManager = new ProductManager();
    CategoryManager categoryManager = new CategoryManager();
    BrandManager brandManager = new BrandManager();
    public void showMenuProduct() {
        int choice;
        do {
            System.out.println("========Quản lý sản phẩm========");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("0. Thoát chương trình quản lý sản phẩm");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch(choice) {
                case 1:
                    showAddProduct();
                    break;
                case 2:
                    showEditProduct();
                    break;
                case 3:
                    showRemoveProduct();
                    break;
                case 4:
                    showAllProduct();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý sản phẩm!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp! Yêu cầu nhập lại.");
                    break;
            }
        } while (choice!=0);
    }

    private int getIdCategory(int index) {
        List<Category> categoryList = categoryManager.getAll();
        Category category = categoryList.get(index);
        return category.getId();
    }

    private int getIdBrand(int index) {
        List<Brand> brandList = brandManager.getAll();
        Brand brand = brandList.get(index);
        return brand.getId();
    }

    private void showAddProduct(){
        System.out.println("=====Thêm mới sản phẩm=====");
        System.out.println("Danh sách loại sản phẩm");
        List<Category> categoryList = categoryManager.getAll();
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.println((i + 1) + ". " + categoryList.get(i).getName());
        }
        int indexCategory, idCategory;
        do {
            System.out.print("Chọn loại sản phẩm: ");
            int choiceCategory = Input.inputInteger();
            indexCategory = choiceCategory - 1;
            if (indexCategory >= categoryList.size()){
                System.out.println("Không tồn tại loại sản phẩm! Yêu cầu nhập lại.");
            }
        } while (indexCategory >= categoryList.size());
        idCategory = getIdCategory(indexCategory);
        System.out.println("Danh sách thương hiệu");
        List<Brand> brandList = brandManager.getAll();
        for (int i = 0; i < brandList.size(); i++) {
            System.out.println((i + 1) + ". " + brandList.get(i).getName());
        }
        int indexBrand, idBrand;
        do {
            System.out.print("Chọn loại thương hiệu: ");
            int choiceBrand = Input.inputInteger();
            indexBrand = choiceBrand - 1;
            if (indexBrand >= brandList.size()){
                System.out.println("Không tồn tại thương hiệu! Yêu cầu nhập lại.");
            }
        } while (indexBrand >= brandList.size());
        idBrand = getIdBrand(indexBrand);
        System.out.print("Nhập tên sản phẩm: ");
        String name = Input.inputString();
        System.out.print("Nhập giá sản phẩm: ");
        double price = Input.inputDouble();
        Product product = new Product(idCategory, idBrand, name, price);
        productManager.add(product);
        System.out.println("Thêm sản phẩm thành công!");
    }

    private void showEditProduct() {
        System.out.println("=====Sửa thông tin sản phẩm=====");
        System.out.print("Nhập mã sản phẩm muốn sửa: ");
        int idEdit = Input.inputInteger();
        if (productManager.findIndexById(idEdit) != -1){
            System.out.println("Danh sách loại sản phẩm");
            List<Category> categoryList = categoryManager.getAll();
            for (int i = 0; i < categoryList.size(); i++) {
                System.out.println((i + 1) + ". " + categoryList.get(i).getName());
            }
            int indexCategory, idCategory;
            do {
                System.out.print("Chọn loại sản phẩm: ");
                int choiceCategory = Input.inputInteger();
                indexCategory = choiceCategory - 1;
                if (indexCategory >= categoryList.size()){
                    System.out.println("Không tồn tại loại sản phẩm! Yêu cầu nhập lại.");
                }
            } while (indexCategory >= categoryList.size());
            idCategory = getIdCategory(indexCategory);
            System.out.println("Danh sách thương hiệu");
            List<Brand> brandList = brandManager.getAll();
            for (int i = 0; i < brandList.size(); i++) {
                System.out.println((i + 1) + ". " + brandList.get(i).getName());
            }
            int indexBrand, idBrand;
            do {
                System.out.print("Chọn loại thương hiệu: ");
                int choiceBrand = Input.inputInteger();
                indexBrand = choiceBrand - 1;
                if (indexBrand >= brandList.size()){
                    System.out.println("Không tồn tại thương hiệu! Yêu cầu nhập lại.");
                }
            } while (indexBrand >= brandList.size());
            idBrand = getIdBrand(indexBrand);
            System.out.print("Nhập tên sản phẩm: ");
            String name = Input.inputString();
            System.out.print("Nhập giá sản phẩm: ");
            double price = Input.inputDouble();
            Product product = new Product(idEdit,idCategory,idBrand,name,price);
            productManager.update(idEdit,product);
            System.out.println("Sửa thông tin sản phẩm thành công!");
        } else {
            System.out.println("Không tìm thấy mã sản phẩm!");
        }
    }

    private void showRemoveProduct() {
        System.out.println("=====Xóa sản phẩm=====");
        System.out.print("Nhập mã sản phẩm muốn xóa: ");
        int idUpdate = Input.inputInteger();
        if (productManager.findIndexById(idUpdate) != -1){
            productManager.remove(idUpdate);
            System.out.println("Xóa sản phẩm thành công!");
        } else {
            System.out.println("Không tìm thấy mã sản phẩm!");
        }
    }

    private void showAllProduct() {
        System.out.println("=====Danh sách sản phẩm=====");
        List<Product> productList = productManager.getAll();
        for (Product product : productList) {
            Category category = categoryManager.findCategoryById(product.getIdCategory());
            Brand brand = brandManager.findBrandById(product.getIdBrand());
            System.out.println(product + "\n Loại sản phẩm: " + category.getName() + "\n Tên thương hiệu: " + brand.getName());
        }
    }
}
