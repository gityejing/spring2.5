package cn.itcast.j_tx_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("springUserDao")
public class SpringUserDaoImpl implements UserDao {

	@Resource
	private DataSource dataSource;

	// @Override
	// public void save(User user) {
	// String sql = "insert into t_user(name) values (?)";
	// JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	// jdbcTemplate.update(sql, new Object[] { user.getName() });
	//
	// System.out.println(sql);
	// }

	@Override
	public void save(final User user) {
		final String sql = "insert into t_user(name) values (?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.execute(new ConnectionCallback() {
			public Object doInConnection(Connection conn) throws SQLException, DataAccessException {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setObject(1, user.getName());
				ps.execute();
				ps.close();
				return null;
			}
		});
	}

	@Override
	public User get(Integer id) {
		String sql = "select id,name from t_user where id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		return (User) jdbcTemplate.queryForObject(sql, new Object[] { id }, new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// »ñÈ¡
				Integer myId = rs.getInt("id");
				String myName = rs.getString("name");
				// ·â×°
				User user = new User();
				user.setId(myId);
				user.setName(myName);
				return user;
			}
		});
	}
}
