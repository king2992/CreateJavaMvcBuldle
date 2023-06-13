package createJavaBundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Properties;

public class DB {
	
	public String getJavaDto(String tableName) {
		Config config = new Config();
		String url = config.getDbInfo("db.url").replaceAll("\"", "");
		String id = config.getDbInfo("db.id").replaceAll("\"", "");
		String pw = config.getDbInfo("db.pw").replaceAll("\"", "");
		
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;

		String javaDto = "";
		try {
			Class.forName("org.postgresql.Driver");

			conn = DriverManager.getConnection(url, id, pw);

			statement = conn.createStatement();

			resultSet = statement.executeQuery("select * from func_table_convert_to_java("+"'"+tableName.toLowerCase()+"'"+")");
			while (resultSet.next()) {
				javaDto += resultSet.getString("JAVA_DTO");
			}
			return javaDto;
		} catch (Exception e) {
			System.out.println("DBUtil.getConnection() : " + e.toString());
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (statement != null)
					statement.close();
				if (resultSet != null)
					resultSet.close();
			} catch (SQLException e) {
			}
		}
		return "";
	}
	
	public String getJavaEntity(String tableName) {
		Config config = new Config();
		String url = config.getDbInfo("db.url").replaceAll("\"", "");
		String id = config.getDbInfo("db.id").replaceAll("\"", "");
		String pw = config.getDbInfo("db.pw").replaceAll("\"", "");
		
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;

		String javaEntity = "";
		try {
			Class.forName("org.postgresql.Driver");

			conn = DriverManager.getConnection(url, id, pw);

			statement = conn.createStatement();
			
			resultSet = statement.executeQuery("select * from func_table_convert_to_java("+"'"+tableName.toLowerCase()+"'"+")");

			while (resultSet.next()) {
				javaEntity += resultSet.getString("JAVA_ENTITY");
			}
			return javaEntity;
		} catch (Exception e) {
			System.out.println("DBUtil.getConnection() : " + e.toString());
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (statement != null)
					statement.close();
				if (resultSet != null)
					resultSet.close();
			} catch (SQLException e) {
			}
		}
		return "";
	}
}
