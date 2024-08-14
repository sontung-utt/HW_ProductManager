package model;

public class Product {
    private int id;
    private String name;
    private double price;
    private int idCategory;
    private int idBrand;

    private static int idIncrement = 1;

    public Product(){
    }

    public Product(int idCategory, int idBrand, String name, double price) {
        this.id = idIncrement;
        this.idCategory = idCategory;
        this.idBrand = idBrand;
        this.name = name;
        this.price = price;
        idIncrement++;
    }

    public Product(int id, int idCategory, int idBrand, String name, double price){
        this.id = id;
        this.idCategory = idCategory;
        this.idBrand = idBrand;
        this.name = name;
        this.price = price;
        if (id >= idIncrement) {
            idIncrement = id + 1;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public static int getIdIncrement() {
        return idIncrement;
    }

    public static void setIdIncrement(int idIncrement) {
        Product.idIncrement = idIncrement;
    }

    public String toString() {
        return "=====Sản phẩm=====" +
                "\n Mã sản phẩm: " + id +
                "\n Tên sản phẩm: " + name +
                "\n Giá sản phẩm: " + price;
    }
}
