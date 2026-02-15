package thrill.io.dao;

import thrill.io.DataStore;
import thrill.io.entities.User;

public class UserDao {
	public User[] getUser() {
		return DataStore.getUser();
	}
}
