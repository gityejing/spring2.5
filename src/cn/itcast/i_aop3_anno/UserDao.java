package cn.itcast.i_aop3_anno;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	public void deleteUser() {
		System.out.println("== ɾ��User ==");
	}

	public void queryUsers() {
		System.out.println("== ��ѯUser ==");
	}

	public void saveUser(User user) {
		System.out.println(user);
	}
}
