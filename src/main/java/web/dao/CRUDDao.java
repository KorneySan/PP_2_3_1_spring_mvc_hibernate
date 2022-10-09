package web.dao;

import java.util.List;

public interface CRUDDao<T> {
    void create(T t);
    T show(long id);
    List<T> getList();
    void update(long id, T t);
    void delete(long id);
    void delete(T t);
    List<T> find(T t);
}
