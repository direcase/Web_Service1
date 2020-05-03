import java.util.HashSet;

public class User {
    private int id;
    private int id_gen=0;
    private String name;
    private String surname;
    private String username;
    private String password;

    public User( String name, String surname,String Username){
        generateId();
        setName(name);
        setSurname(surname);
        setUsername(username);
    }

    public void generateId (){
        id=id_gen++;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setSurname(String surname){
        this.surname=surname;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
