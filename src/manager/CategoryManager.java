package manager;

import model.Category;
import readwritedata.ReadWriteCategory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryManager implements IManager<Category>{

    List<Category> categoryList = new ArrayList<>();
    ReadWriteCategory readWriteCategory = new ReadWriteCategory();
    public CategoryManager() {
        this.categoryList = readWriteCategory.readCategory();
    }
    @Override
    public void add(Category category) {
        categoryList.add(category);
        readWriteCategory.writeCategory(categoryList);
    }

    @Override
    public void update(int id, Category category) {
        int index = findIndexById(id);
        categoryList.set(index, category);
        readWriteCategory.writeCategory(categoryList);
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        categoryList.remove(index);
        readWriteCategory.writeCategory(categoryList);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i <categoryList.size(); i++) {
            if (categoryList.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Category> getAll() {
        this.categoryList = this.readWriteCategory.readCategory();
        return this.categoryList;
    }

    public Category findCategoryById(int id) {
        int index = findIndexById(id);
        return categoryList.get(index);
    }
}
