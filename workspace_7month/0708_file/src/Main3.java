import java.io.File;
import java.io.IOException;

public class Main3 {

	public static void main(String[] args) {
		File file = new File("d:\\dlsgk_practice\\test");
		System.out.println("�ִ�?  "+file.isDirectory());
		System.out.println("����? "+file.isDirectory());
		System.out.println("����? "+file.isFile());
		
		boolean result = file.mkdir();
		System.out.println("������?: "+result);
		
		//D ����̺꿡 filetest����(���丮) �ȿ� abc ������ �����غ�����
		
		File abc = new File("d:\\dlsgk_practice\\test\\abc");
		abc.mkdir();
		
		
		File def = new File(abc.getParent()+"\\def");
		def.mkdir();
		
		System.out.println();
		File textFile = new File("d:\\dlsgk_practice\\mytext.txt");
		try {
			boolean result2 = textFile.createNewFile();
			System.out.println("������?  "+result2);
			System.out.println("�̹� ����?  "+textFile.isFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
