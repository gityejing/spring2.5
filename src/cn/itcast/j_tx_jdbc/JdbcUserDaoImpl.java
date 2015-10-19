package cn.itcast.j_tx_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository("jdbcUserDao")
public class JdbcUserDaoImpl implements UserDao {

	@Resource
	private DataSource dataSource;

	@Override
	public void save(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into t_user(name) values (?)";
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setObject(1, user.getName());
			ps.execute(); // ÷¥––
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public User get(Integer id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select id,name from t_user where id=?";
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setObject(1, id);
			rs = ps.executeQuery(); // ÷¥––≤È—Ø

			while (rs.next()) {
				Integer myId = rs.getInt("id");
				String myName = rs.getString("name");

				User user = new User();
				user.setId(myId);
				user.setName(myName);
				return user;
			}
			
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
