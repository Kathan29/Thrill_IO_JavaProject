package thrill.io.managers;

import thrill.io.entities.User;

public class UserManager {
	public static UserManager instance = new UserManager();

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
}
