package cn.itcast.j_tx_jdbc_3;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LogDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void logToDb(String message) {
		String sql = "insert into t_log(message) values(?)";
		jdbcTemplate.update(sql, new Object[] { message });
	}
}
