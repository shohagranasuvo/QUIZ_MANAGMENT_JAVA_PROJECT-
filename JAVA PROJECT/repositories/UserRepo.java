package repositories;
import entities.User;
import interfaces.*;
import java.lang.*;
import java.util.*;


public class UserRepo implements IUserRepo {

    private String file = "repositories/data/users.txt";
    private FileIO fio = new FileIO();

    public void addUser(User user) {
        List<User> users = getAllUsers(); 
        users.add(user);
        saveUsers(users);
    }

    public void updateUser(User user) {
        List<User> users = getAllUsers();

        boolean found = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getID().equals(user.getID())) {
                users.set(i, user); 
                found = true;
                break;
            }
        }

        if (found) {
            saveUsers(users);
        } else {
            System.out.println("User not found");
        }
    }

    public void deleteUser(String id) {
        List<User> users = getAllUsers();
        boolean userFound = users.removeIf(user -> user.getID().equals(id)); // Deleting by ID
    
        if (userFound) {
            saveUsers(users);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found with ID: " + id);
        }
    }
    

    public List<User> getAllUsers() {
        List<String> data = fio.readFile(file);
        List<User> users = new ArrayList<>();

        for (String line : data) {
            try {
                User user = new User().formUser(line);
                users.add(user);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid user data format: " + line);
            }
        }
        return users;
    }

    private void saveUsers(List<User> users) {
        List<String> data = new ArrayList<>();
        for (User user : users) {
            data.add(user.toString());
        }
        fio.writeFile(file, data);
    }

    public User searchUser(String userName) {
        for (User user : getAllUsers()) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

  
    
}
