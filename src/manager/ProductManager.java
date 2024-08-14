package manager;

import model.Product;
import readwritedata.ReadWriteProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductManager implements IManager<Product>{

    List<Product> productList;
    ReadWriteProduct readWriteProduct = new ReadWriteProduct();
    public ProductManager() {
        this.productList = this.readWriteProduct.readProduct();
    }
    @Override
    public void add(Product product) {
        productList.add(product);
        readWriteProduct.writeProduct(productList);
    }

    @Override
    public void update(int id, Product product) {
        int index = findIndexById(id);
        productList.set(index, product);
        readWriteProduct.writeProduct(productList);
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        productList.remove(index);
        readWriteProduct.writeProduct(productList);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Product> getAll() {
        this.productList = this.readWriteProduct.readProduct();
        return this.productList;
    }
}
