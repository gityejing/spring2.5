package cn.itcast.i_aop3_anno;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	public void deleteUser() {
		System.out.println("== É¾³ýUser ==");
	}

	public void queryUsers() {
		System.out.println("== ²éÑ¯User ==");
	}

	public void saveUser(User user) {
		System.out.println(user);
	}
}
