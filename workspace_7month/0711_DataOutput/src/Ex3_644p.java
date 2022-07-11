import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import javax.swing.JFrame;

class Account implements Serializable {
	private int num;
	private String name;
	private String tel;
	private String email;

	public Account(int num, String name, String tel, String email) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
		this.email = email;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("%d\t%s\t%s\t%s\t", num, name, tel, email);
	}
}

public class Ex3_644p {
	Map<Integer, Account> ac = new HashMap<>();
	Scanner sc = new Scanner(System.in);
	File save = new File(".\\data_pc\\accountSave.bat");

	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	
	public Ex3_644p() {
		manage();
	}

	public void loadingAccount() {
		try {
			ois = new ObjectInputStream(new FileInputStream(save));
			while (true) {
				Account acc = (Account) ois.readObject();
				ac.put(acc.getNum(), acc);
			}
		} catch (IOException | ClassNotFoundException e) {
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void saveAccount() {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(save));
			
			for (Integer key : ac.keySet()) {
				oos.writeObject(ac.get(key));
			}
			oos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void printAccount() {
		System.out.println("<��ȣ>\t<�̸�>\t<��ȭ��ȣ>\t<�̸���>");
		for (Integer key : ac.keySet()) {
			System.out.println(ac.get(key));
		}
		System.out.println("��� �Ϸ�");
	}
	
	public Account inputOneAccount() {
		
		System.out.print("��ȣ �Է�: ");
		int num = sc.nextInt();
		System.out.print("�̸� �Է�: ");
		String name = sc.next();
		System.out.print("��ȭ��ȣ �Է�: ");
		String tel = sc.next();
		System.out.print("�̸��� �Է�: ");
		String email = sc.next();
		return new Account(num, name, tel, email);
		
	}
	
	public Account findAccount() {
		System.out.print("ã�� ������ ��ȣ�� �Է�: ");
		int input = sc.nextInt();
		Account b = null;
		
		for (Integer key : ac.keySet()) {
			if (key.equals(input)) {
				b = ac.get(key);
			}
		}
		if (ac==null) {
			System.out.println("ã�� ȸ���� ������ �����ϴ�.");
		} 
		return b;
	}
	
	public void manage() {
		System.out.println("�ε��� ...");
		loadingAccount();
		System.out.println("�ε� �Ϸ�");
		System.out.println("==============================");
		System.out.println("=== ����� ���� ���� ���α׷�");
		System.out.println("==============================");
		int num = 0;
		
		while (true) {
			if (num == 1) {
				System.out.println("��ü ��� ���");
				printAccount();
				num=0;
				
			} else if (num == 2) {
				System.out.println("��ȣ�� ã��");
				Account ac = findAccount();
				if (ac!=null) {
					System.out.println("<��ȣ>\t<�̸�>\t<��ȭ��ȣ>\t<�̸���>");
					System.out.println(ac);
				}
				num=0;
				
			} else if (num == 3) {
				System.out.println("����� ���� �Է�");
				Account a = inputOneAccount();
				ac.put(a.getNum(), a);
				System.out.println("�Է� �Ϸ�");
				saveAccount();
				num=0;
				
			} else if (num == 4) {
				System.out.println("����� ���� ����");
				Account a = findAccount();
				if (a !=null) {
					ac.remove(a.getNum());
					Account b = inputOneAccount();
					ac.put(b.getNum(), b);
				}
				saveAccount();
				num=0;
				
			} else if (num == 5) {
				System.out.println("����� ���� ����");
				Account a = findAccount();
				if (a !=null) {
					ac.remove(a.getNum());
					System.out.println("���� �Ϸ�");
				}
				saveAccount();
				num=0;
				
			} else if (num == 9) {
				System.out.println("���α׷��� �����մϴ�");
				return;
				
			} else if (num == 0) {
				System.out.println("==============================");
				System.out.println("1. ��ü ��� ���");
				System.out.println("2. ��ȣ�� ã��");
				System.out.println("3. ����� ���� �Է�");
				System.out.println("4. ����� ���� ����");
				System.out.println("5. ����� ���� ����");
				
				System.out.println("9. ���α׷� ����");
				System.out.println("------------------------------");
				System.out.print("�Է�: ");
				num = sc.nextInt();
				System.out.println("==============================");
			}
		}
	}

	public static void main(String[] args) {
		new Ex3_644p();
	}
}
