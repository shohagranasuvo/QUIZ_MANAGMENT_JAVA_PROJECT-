package interfaces;
import entities.*;
import java.lang.*;
import java.util.*;

public interface IUserRepo
{
	public void addUser(User u);
	public void updateUser(User u);
	public void deleteUser(String id);
	public User searchUser(String id);
	 public List<User> getAllUsers();
}