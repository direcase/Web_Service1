import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreRepository implements IDBRepository {
    public PostgreRepository() {
        super();
    }
    @Override
    public Connection getConnection(){
        try{
            String connStr="jdbc:postgresql://localhost:5432";
            Connection conn= DriverManager.getConnection(connStr);
            return conn;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
