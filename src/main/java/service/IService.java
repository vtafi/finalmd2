package service;

import entity.Mobile;

import java.util.List;

public interface IService <T extends Mobile> {
    List<T> getAll();
    List<T> save(T t);
    void remove(int id);
    List<T> findByName(String name);
    T findByID(int id);

}
