import java.sql.*;

public class Main2 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/world";
		// "jdbc:mysql://localhost:(��Ʈ�ּ�)/���ϴµ����ͺ��̽�";
		String id = "root";
		String pw = "root";
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("����̹� ���� ����");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("�����ͺ��̽� ���� ����");

			///
			// �پ����� �ݰ� �α׾ƿ� ����� ��.

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("����̹��� ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�����ͺ��̽� ���ῡ �����Ͽ����ϴ�.");
		} finally {
			if (conn != null)
				try {
					conn.close();
					System.out.println("���� ����");
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}
}
