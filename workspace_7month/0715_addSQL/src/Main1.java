import java.sql.*;

public class Main1 {
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root", "root");
			
			// table A: �÷� B varchar(10) pk. ���� ��.
			
			String query = "create table a (b varChar(10) primary key);";
			// sql��� ���ڿ�
			stmt = conn.createStatement();
			// ����� �������ִ� ��ü.
			// stmt.executeUpdate(query);
			// ����� ����!
			// executeUpdate: �����۾��� �� �� ���� �޼ҵ�: �߰�, ����, ����, ����
			String query2 = "drop table a;";
			stmt.executeUpdate(query2);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// ���߿� �� ��ü�� ���� ���� ����. stack ����. ���Լ���
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
