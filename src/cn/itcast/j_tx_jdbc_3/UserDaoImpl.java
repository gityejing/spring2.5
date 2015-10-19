package cn.itcast.j_tx_jdbc_3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// ��ɾ�ģ�insert,delete,update������ʹ��JdbcTemplate��update()����
@Repository("userDao")
@SuppressWarnings("unchecked")
public class UserDaoImpl implements UserDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(User user) {
		String sql = "insert into t_user(name) values(?)";
		jdbcTemplate.update(sql, new Object[] { user.getName() });
	}

	@Override
	public User get(final Integer id) {
		String sql = "select name from t_user where id=?"; // SQL���
		Object[] args = new Object[] { id }; // �����б�

		// ִ�в�ѯ
		List<User> list = jdbcTemplate.query(sql, args, new RowMapper() {
			// ����һ������
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// ��ȡ
				String name = rs.getString("name");
				// ��װ������
				User user = new User();
				user.setId(id);
				user.setName(name);
				return user;
			}
		});

		return list.size() == 0 ? null : list.get(0);
	}

}
