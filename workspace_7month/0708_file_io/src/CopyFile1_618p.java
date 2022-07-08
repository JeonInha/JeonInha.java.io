import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile1_618p {
	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
		// ���� ������ byte ������ �д� ��ü
		FileOutputStream out = null;
		// ���� ������ byte ������ ����ϴ� ��ü
		
		try {
			in = new FileInputStream("input.txt");
			out = new FileOutputStream("output.txt");
			int c;
			
			// �ϳ��� �о���µ� ���� -1 //
			while ((c=in.read())!= -1) {
				out.write(c);
				System.out.print(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out!=null) {
				out.close();
			}
		}

	}

}
