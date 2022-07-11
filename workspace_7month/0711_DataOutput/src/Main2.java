import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main2 {

	public static void main(String[] args) {
		DataOutputStream dos = null;
		// �������� ���¸� �پ��ϰ� ������Ҽ�����.

		try {
			dos = new DataOutputStream(new FileOutputStream(".\\practice_txt\\mydata.dat"));
			dos.writeInt(50);
			dos.writeDouble(123.123);
			dos.writeUTF("���ڿ�");
			dos.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {

					dos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(".\\practice_txt\\mydata.dat"));
			int valueInt = dis.readInt();
			double valueDouble = dis.readDouble();
			String valueString = dis.readUTF();
			
			System.out.println(valueInt);
			System.out.println(valueDouble);
			System.out.println(valueString);
			
			dis.readBoolean();
			
		} catch (EOFException e) {
			System.out.println("���� �� �о���");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dis!=null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		
	}
}
