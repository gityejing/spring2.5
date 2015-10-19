package cn.itcast.j_tx_jdbc_3;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService extends BaseService {

	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private UserDao userDao;
	@Resource
	private LogDao logDao;

	@Transactional(readOnly = false, isolation = Isolation.DEFAULT)
	public void saveTwoUsers() {
		// �����һ��
		User user = new User();
		user.setName("test1");
		userDao.save(user);
		logDao.logToDb("������һ��User�ļ�¼11");
		// this.logToDb("������һ��User�ļ�¼11");

		 int a = 1 / 0; // ���л����쳣

		// ����ڶ���
		User user2 = new User();
		user2.setName("test2");
		userDao.save(user2);
		// logDao.logToDb("������һ��User�ļ�¼22");
		this.logToDb("������һ��User�ļ�¼11");
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void logToDb(String message) {
		String sql = "insert into t_log(message) values(?)";
		jdbcTemplate.update(sql, new Object[] { message });
	}
}
