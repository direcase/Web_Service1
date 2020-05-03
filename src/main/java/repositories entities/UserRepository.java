package repositories

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;entities;

public class UserRepository implements IEntityRepository<User>{
    private IDBRepository dbrepo;

    public UserRepository(){
        dbrepo=new PostgreRepository();
    }

    @Override
    public void add(User entity){
        try{
            Statement stmt= dbrepo.getConnection().createStatement;
            String sql="INSERT INTO users(name, surname,username,password)" +
                    "VALUES("+ etity.getName()+"','"+entity.getSurname()+
                    "','"+entity.getUsername()+"','"+entity.getPassword();
            stmt.execute(sql);
        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (Exception ex){
            ex.fillInStackTrace();
        }
    }

    @Override
    public void update(User entity){
        try{
            Statement stmt=dbrepo.getConnection().createStatement;
            String sql="UPDATE users SET name=" +entity.getName()+"','"
                    + "surname" =entity.getSurname()+"','" +
                    "username" = entity.getUsername() + "','"+
                    "password"=entity.getPassword()+
                    "WHERE id" = entity.getID();
            stmt.execute(sql);
        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (Exception ex){
            ex.fillInStackTrace();
        }
    }

    @Override
    public void remove(User entity){
        try{
            Statement stmt=dbrepo.getConnection().createStatement;
            String sql="DELETE FROM users " +
                    "WHERE id" = entity.getID();
            stmt.execute(sql);
        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (Exception ex){
            ex.fillInStackTrace();
        }
    }

    @Override
    public Iterable<User> query(String sql){
        try{
            Statement stmt=dbrepo.getConnection().createStatement;
            ResultSetrs=stmt.executeQuery(sql);
            LinkedList<User> users= new LinkedList<>();
            while(rs.next()){
                User user=new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("username"),
                        rs.getString("password")
                );
                user.add(user);
                user.update(user);
                user.remove(user);
            }
        }
    }

}