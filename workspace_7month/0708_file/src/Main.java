import java.io.File;

//07 08 ���� �����

//����: ��ġ�� ������ ������ ����. ����̺��� Ư�� �� PC�� ������ ����� ��������. 
// �̷��� ���ϵ��� �ڹ� ����Ʈ����� �����ϰ��� ��.

public class Main {
// ������
	public static void main(String[] args) {
		File file = new File("d:\\dlsgk_practice\\test.txt");
		// TODO Auto-generated method stub
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.exists());
		
		File f2 = new File("d:\\dlsgk_practice\\fdswaf.txt");
		// ���� ������ ���� �� �ƴ϶� ���� ��ġ�� ����Ű�� ��ü�� ���� ���̱� ������ 
		// ���� ������ �������� ������ ��� ���� �̸��� ��ΰ� ������ (�׷��� exists()��
		// ���翩�θ� Ȯ���ϸ� false�� ����. �����ϱ�.)
		System.out.println();
		System.out.println(f2.getName());
		System.out.println(f2.getPath());
		System.out.println(f2.exists());
		
		File dir = new File("d:\\dlsgk_practice\\���");
		// ���͸��� ����ų �� ����
		System.out.println();
		System.out.println(dir.getName());
		System.out.println(dir.getPath());
		System.out.println(dir.exists());
		System.out.println("dir�� �����ΰ���?  " + dir.isFile());
		System.out.println("dir�� ���丮�ΰ���?  "+ dir.isDirectory());

	}

}
