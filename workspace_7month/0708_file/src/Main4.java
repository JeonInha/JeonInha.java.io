import java.io.File;
import java.io.IOException;

public class Main4 {

	public static void main(String[] args) {
		File fileKor = new File("d:\\dlsgk_practice\\�ѱ��̸�.txt");

		try {
			System.out.println("������?  " + fileKor.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		fileKor.renameTo(new File("d:\\dlsgk_practice\\newName.txt"));
		// �� �ȹٲ��� ...?
		// �����̸����θ� �ٲ .......?
		
		File mytext = new File("d:\\dlsgk_practice\\mytext.txt");
		mytext.delete();

	
	}

}
