package repository;

import java.sql.SQLException;

public interface BaseRepo {
    void findAll();
    void delete(int id) throws SQLException;

}
