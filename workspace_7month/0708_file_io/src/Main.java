import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		File diaryf = new File("d:\\dlsgk_practice\\test.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(diaryf);
			while (sc.hasNext()) {
			sc.nextLine();
			}
			// ��ĳ�ʷ� ������ ����

		} catch (FileNotFoundException e) {
			System.out.println("���� �����~~");
		} finally {
			if (sc!=null) {
				sc.close();
			}
		}
	}

}
