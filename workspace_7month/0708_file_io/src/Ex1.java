import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class Ex1 {

	public static void main(String[] args) {
		// TODO
		// 1.
		// ���� ������ ���� ����
		// persons.txt
		// ������ ������ �� �پ� �о
		// �ܼ� ���

		// 2. ��� ��� ���� ���ؼ� ���

		File p = new File(".\\persons.txt");
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(p));
			String line;
			line = br.readLine();
			int ageplus = 0;
			while (line!=null) {
				System.out.println(line);
				int index = line.indexOf(',');
				String strAge = line.substring(index+1);
				Integer age = Integer.valueOf(strAge);
				System.out.println(age);
				ageplus +=age;
				line = br.readLine();
			}
			System.out.println(ageplus/3);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
