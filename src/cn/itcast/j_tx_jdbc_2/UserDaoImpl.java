package cn.itcast.j_tx_jdbc_2;

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
	public void delete(Integer id) {
		String sql = "delete from t_user where id=?";
		jdbcTemplate.update(sql, new Object[] { id });
	}

	@Override
	public void update(User user) {
		String sql = "update t_user set name=? where id=?";
		jdbcTemplate.update(sql, new Object[] { user.getName(), user.getId() });
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

	@Override
	public List<User> findAll() {
		// SQL���
		String sql = "select id,name from t_user";

		// ִ�в�ѯ
		List<User> list = jdbcTemplate.query(sql, new RowMapper() {
			// ����һ������
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// ��ȡ
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				// ��װ������
				User user = new User();
				user.setId(id);
				user.setName(name);
				return user;
			}
		});

		return list;
	}

	@Override
	public int getCount() {
		String sql = "select count(*) from t_user";
		return jdbcTemplate.queryForInt(sql);
	}

}
