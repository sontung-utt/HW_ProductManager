package readwritedata;

import model.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteCategory {
    File file = new File ("data/category.csv");

    public void writeCategory(List<Category> categoryList) {
        try {
            String data = "";
            for (Category category : categoryList) {
                data += category.getId() + "," + category.getName() + "\n";
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Category> readCategory() {
        List<Category> listCategory = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine())!= null) {
                String[] data = line.split(",");
                Category category = new Category(Integer.parseInt(data[0]),data[1]);
                listCategory.add(category);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listCategory;
    }
}
