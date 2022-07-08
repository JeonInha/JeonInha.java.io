import java.io.File;
import java.io.IOException;


// �����
public class Main2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File(".\\");
		
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.exists());
		
		System.out.println(file.getAbsolutePath());
		try {
		System.out.println(file.getCanonicalPath());
		// ����θ� �����η� ��ȯ
		// AbsolutePath: . ��(���� ���) �츮�� �ؼ�
		// CanonicalPath: . �� �ڵ����� �ؼ�����
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// �θ���
		System.out.println();
		File fileParaent = new File("..\\");
		System.out.println(fileParaent.getAbsolutePath());
		try {
		System.out.println(fileParaent.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// ���� ��ü�� �θ� ����
		System.out.println();
		try {
		File file3 = file.getCanonicalFile().getParentFile();
		// CanonicalPath:: ��θ� ���ڿ��� ��ȯ
		// CanonicalFile:: ���� ��ü�� ��ȯ
		
		System.out.println(file3.getAbsolutePath());
		System.out.println(file3.getCanonicalPath());
		
		System.out.println(fileParaent.equals(file3));	// ���������̴޶�
		System.out.println(fileParaent.compareTo(file3));
		
		System.out.println(fileParaent.getCanonicalFile().equals(file3));
		System.out.println(fileParaent.getCanonicalFile().compareTo(file3));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
