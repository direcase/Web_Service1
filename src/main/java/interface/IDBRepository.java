package

import java.sql.Connection; interface

interface IDBRepository<T> {
    Connection getConnection();
}