package readwritedata;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteProduct {
    File file = new File("data/product.csv");

    public void writeProduct(List<Product> productList) {
        try {
            String data = "";
            for (Product product : productList) {
                data += product.getId() + "," + product.getIdCategory() +"," + product.getIdBrand() + "," + product.getName() + "," + product.getPrice() + "\n";
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Product> readProduct() {
        List<Product> listProduct = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine())!=null){
                String[] data = line.split(",");
                Product product = new Product(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]),data[3],Double.parseDouble(data[4]));
                listProduct.add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listProduct;
    }
}
