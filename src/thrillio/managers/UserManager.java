package thrillio.managers;

import thrillio.dao.UserDao;
import thrillio.entities.User;

public class UserManager {
	private static UserManager instance = new UserManager();
	private static UserDao dao = new UserDao();

	private UserManager() {
	};

	public static UserManager getInstance() {
		return instance;
	}

	public User createUser(long id, String email, String password, String firstName, String lastName, String userType,
			int gender) {
		User user = new User();

		user.setId(id);
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUserType(userType);
		user.setGender(gender);

		return user;
	}
	
	public User[] getUser() {
		return dao.getUser();
	}
}
