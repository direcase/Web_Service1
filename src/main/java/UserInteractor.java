public class UserInteractor {
    private IEntityRepository userRepo;

    public UserInteractor(){
        userRepo= new UserRepository();
    }

    public User getUserByID(long id){
        LinkedList<User> users=(LinkedList<User>) userRepo.query(
                "SELECT * FROM  users where id= "+id);
        return (users.isEmpty()? null:users.get(0));
    }

    public void addUser(String name,String surname,String username,String password){
        User user= new User(name,surname,username,password);
        userRepo.add(user);
    }

    public void updateUser(String name,String surname,String username,String password){
        User user= new User(name,surname,username,password);
        userRepo.update(user);
    }

    public void removeUser(String name,String surname,String username,String password){
        User user= new User(name,surname,username,password);
        userRepo.remove(user);
    }
}
