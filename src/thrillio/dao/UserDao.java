package thrillio.dao;

import thrillio.DataStore;
import thrillio.entities.User;

public class UserDao {
	public User[] getUser() {
		return DataStore.getUser();
	}
}
