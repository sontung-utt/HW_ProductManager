package manager;

import java.util.List;

public interface IManager<T> {
    void add(T t);
    void update(int id, T t);
    void remove(int id);
    int findIndexById(int id);
    List<T> getAll();
}
