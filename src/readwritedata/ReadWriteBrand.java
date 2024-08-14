package readwritedata;

import model.Brand;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteBrand {
    File file = new File("data/brand.csv");

    public void writeBrand(List<Brand> brandList) {
        try{
            String data = "";
            for (Brand brand:brandList){
                data += brand.getId() + "," + brand.getName() + "\n";
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public List<Brand> readBrand(){
        List<Brand> listBrand = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine())!=null){
                String[] data = line.split(",");
                Brand brand = new Brand(Integer.parseInt(data[0]),data[1]);
                listBrand.add(brand);
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return listBrand;
    }
}
