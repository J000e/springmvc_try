package com.acme.tutorial.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

import com.acme.tutorial.model.Circle;

@Component
public class JdbcDaoImpl {
	
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	/*
	public Circle getCircle(int circleId) {
		Circle circle = null;
		
		Connection conn = null;
		try {
			String driver = "org.apache.derby.jdbc.ClientDriver";
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db;create=true");
			
			conn = dataSource.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("select * from circle where id = ?");
			ps.setInt(1, circleId);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				circle = new Circle(circleId, rs.getString("name"));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
*/
	
	public Circle getCircle(int circleId) {
		String sql = "select * from circle where id = ?";
		Circle circle = jdbcTemplate.queryForObject(sql, new Object[] {circleId}, new CircleMapper());
		
		return circle;
	}
	
	public int getCircleCount() {
		String sql = "select count(*) from circle";
		
		return jdbcTemplate.queryForInt(sql);
	}
	
	public String getCircleName(int circleId) {
		String sql = "select name from circle where id = ?";
		String circleName = jdbcTemplate.queryForObject(sql, new Object[] {circleId}, String.class);
		
		return circleName;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public List<Circle> getAllCircle() {
		String sql = "select * from circle";
		List<Circle> circles = jdbcTemplate.query(sql, new CircleMapper());
		
		return circles;
	}
	
	public void insertCircle(Circle circle) {
		String sql = "insert into circle (id, name) values (:id, :name)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", circle.getId())
				.addValue("name", circle.getName());
		
		namedParameterJdbcTemplate.update(sql, namedParameters);
	}
	
	public void updateCircle(int circleId, String newName) {
		String sql = "update circle set name = ? where id = ?";
		jdbcTemplate.update(sql, new Object[] {newName, circleId});
	}
	
	private static final class CircleMapper implements RowMapper<Circle> {

		@Override
		public Circle mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
			Circle circle = new Circle(resultSet.getInt("id"), resultSet.getString("name"));
			
			return circle;
		}
		
	}
	
}
