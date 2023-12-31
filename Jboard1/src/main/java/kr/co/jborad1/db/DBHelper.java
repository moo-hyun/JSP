package kr.co.jborad1.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

public class DBHelper {
	
	protected Connection conn = null;
	protected PreparedStatement psmt = null;
	protected Statement stmt = null;
	protected ResultSet rs = null;
	
	public Connection getConnection() {
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/Jboard");
			conn = ds.getConnection();
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return conn;
	}
	public void Close() throws SQLException {
		
		if(rs !=null) {
			rs.close();
		}
		
		if(stmt !=null) {
			stmt.close();
		}
		
		if(psmt !=null) {
			psmt.close();
		}
		
		if(conn !=null) {
			conn.close();
		}
		
	}
	
		
	
	
	
	
	

}
