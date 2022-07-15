import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import ko.co.greenart.dbutil.DBUtil;

class Books {
	String allPrintQuary() {
		return "select * from books;";
	}
	
	String searchQuary(String input) {
		return "select * from books where bookid = '"+input+"' or title like '%"+input+"%' order by bookid;";
	}
	
	String deleteQuary(int id) {
		return "delete from books where bookid = "+id+";";
	}
	
	String insertQuary(String title, int price) {
		return String.format("insert into books (title, price) values ('%s', %d);", title, price);
	}
	
	String updateQuary(String title, int price, int id) {
		return String.format("update books set title = '%s', price = %d where bookid = %d;", title, price, id);
	}
	
	void readBookDB(String quary) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(quary);
			
			while (rs.next()) {
				int id = rs.getInt("bookid");
				String title = rs.getString("title");
				int price = rs.getInt("price");
				System.out.printf("[id: %d | %s, %d��]\n", id, title, price);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}
	
	// ������ ���忡�� ������ �� ����� ����ϸ� ���� �� ����. int�� �ҿ� ������.
	void commandBookDB(String query) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}
}

class ManageSys {
	Books books = new Books();
	
	ManageSys() {
		run();
	}
	
	private String scanString() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		return s;
	}
	
	private int scanInt() {
		int num = 0;
		boolean a = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				num = sc.nextInt();
				a = false;
			} catch (Exception e) {
				System.out.println("���ڸ� �Է��ϼ���.");
			}
		} while (a);
		sc.close();
		return num;
	}

	private void run() {

		System.out.println("====================");
		System.out.println("====���������ý���");
		System.out.println("====================");

		int num = 0;
		while (true) {
			System.out.println("====================");
			System.out.println("1. ��ü ��� ���");
			System.out.println("2. ���� �˻�");
			System.out.println("3. ���� �߰�");
			System.out.println("4. ���� ����");
			System.out.println("5. ���� ����");
			System.out.println();
			System.out.println("9. ���α׷� ����");
			System.out.println("--------------------");
			System.out.print("�Է�: ");
			num = scanInt();
			System.out.println("====================");
			
			if (num == 1) {
				System.out.println("1. ��ü ��� ���");
				// ����ϰ� �ϰ� ������ �̰� �����ϴ� �޼ҵ带 ���� ����ϰ� �غ���.
				books.readBookDB(books.allPrintQuary());
				
			} else if (num == 2) {
				System.out.println("2. ���� �˻�");
				System.out.print("id �Ǵ� å ���� �˻�: ");
				String input = scanString();
				books.readBookDB(books.searchQuary(input));
				
			} else if (num == 3) {
				System.out.println("3. ���� �߰�");
				System.out.print("å ���� �Է�: ");
				String title = scanString();
				System.out.print("å ���� �Է�: ");
				int price = scanInt();
				books.commandBookDB(books.insertQuary(title, price));
				System.out.println("�Է� �Ϸ�Ǿ����ϴ�. id: ");

			} else if (num == 4) {
				System.out.println("4. ���� ����");
				System.out.print("������ ������ id �Է�: ");
				int id = scanInt();
				books.commandBookDB(books.deleteQuary(id));
				
			} else if (num == 5) {
				System.out.println("5. ���� ����");
				System.out.print("������ ������ id �Է�: ");
				int id = scanInt();
				System.out.print("������ ������ ���� �Է�: ");
				String title = scanString();
				System.out.print("������ ������ ���� �Է�: ");
				int price = scanInt();
				books.commandBookDB(books.updateQuary(title, price, id));

			} else if (num == 9) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
				
			} else {
				System.out.println("�߸��� �Է�");
			}
		}

	}
}

public class Ex1_MyDB_books {
	public static void main(String[] args) {
		new ManageSys();
	}
}
