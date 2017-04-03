package com.rest.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	
	public List<User> getAllUsers(){
		
		List<User> userList = null;
		try{
			File file = new File("user.dat");
			if(!file.exists()){
				User newUser = new User(1, "User1", "Engineer");
				userList = new ArrayList();
				userList.add(newUser);
				
			}
			else{
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream obs = new ObjectInputStream(fis);
				userList = (List)obs.readObject();
				obs.close();
			}
		}
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public User getUser(int id){
		
		List<User> users = getAllUsers();
		for(User user : users){
			if(id == user.getId()){
				return user;
			}
		}
		return null;	
	}
	
	public int addUser(User pUser){
		List<User> users = getAllUsers();
		boolean userExists = false;
		for(User user : users){
			if(pUser.getId() == user.getId()){
				userExists = true;
				break;
			}
			if(!userExists){
				users.add(pUser);
				saveUserList(users);
				return 1;
			}
		}
		return 0;
	}
	
	public int updateUser(User pUser){
		List<User> users = getAllUsers();
		for(User user : users){
			if(pUser.getId() == user.getId()){
				int index = users.indexOf(user);
				users.set(index, pUser);
				saveUserList(users);
				return 1;
			}
		}
		return 0;
	}
	
	public int deleteUser(User pUser){
		List<User> users = getAllUsers();
		for(User user : users){
			if(pUser.getId() == user.getId()){
				int index = users.indexOf(user);
				users.remove(index);
				saveUserList(users);
				return 1;
			}
		}
		return 0;
	}
	
	public void saveUserList(List<User> userList){
		
			File file = new File("user.dat");

			FileOutputStream fos;
			try {
				fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(userList);
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
