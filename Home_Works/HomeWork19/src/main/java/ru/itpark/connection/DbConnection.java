package ru.itpark.connection;

public interface DbConnection<T> {
    T find(int id);
}
