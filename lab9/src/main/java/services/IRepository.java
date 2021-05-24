package services;

import java.util.List;

public interface IRepository<T> {

    List<T> getAll();

    T getById(int id);

    Boolean add(T comp);
}
