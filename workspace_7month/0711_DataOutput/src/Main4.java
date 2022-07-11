import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main4 {

	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File(".\\data_pc\\s1.ser")));
			
			oos.writeObject(new Student("�밨����Ű", 8, 3.0));
			// �׳� �����ϸ� ������: ����ȭ�� �Ұ����ؼ�.
			// ����ȭ: ����� �������� ��ũ���������ϵ��� �ѱ����� ���ڰ� ����
			// �ذ���: Ŭ�������� Serializable�� implements �ϱ�
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (oos!=null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//////////////////////////////////////////////////
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(".\\data_pc\\s1.ser"));
			
			Student s = (Student) ois.readObject();
			// �ٿ�ĳ���� �ʼ�
			System.out.println(s);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ois !=null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		
		
	}
}
