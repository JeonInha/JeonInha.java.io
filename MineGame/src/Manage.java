import java.util.*;

public class Manage {
	private Scanner sc = new Scanner(System.in);
	private Random random = new Random();
	private int mineNum = 10;
	private int x = 9;
	private int y = 9;
	private Mine[][] field = new Mine[x][y];
	// ���� 9, ���� 9, ���� 10�� (12.3%)
	private int[] mineX = new int[mineNum];
	private int[] mineY = new int[mineNum];
	// ������ x, y ��ǥ

	public int getMineNum() {
		return mineNum;
	}

	public void setMineNum(int mineNum) {
		this.mineNum = mineNum;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Mine[][] getField() {
		return field;
	}

	public void setField(Mine[][] field) {
		this.field = field;
	}

	public int[] getMineX() {
		return mineX;
	}

	public void setMineX(int[] mineX) {
		this.mineX = mineX;
	}

	public int[] getMineY() {
		return mineY;
	}

	public void setMineY(int[] mineY) {
		this.mineY = mineY;
	}

	
	////////////////////////////////////////////////
	private void setMineXY() { // ���� 10�� ����
		for (int i = 0; i < mineNum; i++) {
			mineX[i] = (random.nextInt(x));
			mineY[i] = (random.nextInt(y));
			for (int j = 0; j < i; j++) { // �ߺ�����
				if (mineX[i] == mineX[j] && mineY[i] == mineY[j]) {
					i--;
				}
			}
		}
	}

	private void countArroundMineNum(int a, int b) { // �ֺ� ���� ���� ����
		int count = 0;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				try {
					if (field[i + a][j + b].isMine()) {
						count++;
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					// try-catch�� ������ �Ѵ� �ε����� ����ó��
				}
			}
		}
		field[a][b].setArroundMineNum(count);
	}

	private void reset() { // �ʵ� �ʱ�ȭ
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				field[i][j] = new Mine(false, 0, 0);
			}
		}
	}

	void setMineinField() { // �ʵ忡 ���� �ɱ�
		reset();
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				for (int k = 0; k < mineNum; k++) {
					if (i == mineY[k] && j == mineX[k])
						field[i][j].setMine(true);
				}
			}
		}
	}

	void setArroundMineNuminField() { // �ʵ忡 �ֺ� ���� ���� �ɱ�
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				countArroundMineNum(i, j);
			}
		}
	}

	private void printField() { // �ʵ� ���
		System.out.println("-------------------------------------");
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (field[i][j].isMine() && field[i][j].getCellState() == 3) { // ���ڸ� ���� �� ĭ ���ڷ� ǥ��
					System.out.print("| �� ");
					continue;
				}
				if (field[i][j].getCellState() == 0) { // �� ���¿� ���� ǥ��
					System.out.print("|   "); // �� �� ĭ
				} else if (field[i][j].getCellState() == 1) {
					System.out.print("| ? "); // ����ǥ �޸�
				} else if (field[i][j].getCellState() == 2) {
					System.out.print("| �� "); // ���� ǥ��
				} else if (field[i][j].getCellState() == 3) { // ĭ ����
					System.out.printf("| %d ", field[i][j].getArroundMineNum());
				}

			}
			System.out.printf("|  %d \n", i + 1);
			System.out.println("-------------------------------------");
		}
		System.out.println("  1   2   3   4   5   6   7   8   9 ");
	}
	
	public void TestMineXY() {
		
		for (int i = 0; i < 9; i++) {
			mineX[8]=i;
			mineY[8]=i;
		}
		mineX[9]=0;
		mineY[9]=1;
		
		//mineX {0, 1, 2, 3, 4, 5, 6, 7,  8, 0}
		//mineY {0, 1, 2, 3, 4, 5, 6, 7,  8, 1}
	}

	public void manage() {
//		setMineXY(); // ���� ����
		TestMineXY(); // �׽�Ʈ����
		setMineinField(); // ���� �ɱ�
		setArroundMineNuminField(); // ��ó�� ���� ���� �ɱ�

		System.out.println("===============���� ã��===============");
		System.out.println("===============���� ����===============");

		while (true) { // �Ʒ������� ������ �ݺ���
			printField(); // �ʵ� ���
			System.out.println();
			System.out.println("1: �޸�\n2: ã�� ���� ǥ��\n3.ĭ ����");
			int select = sc.nextInt();
			if (select > 3 || select < 1) {
				System.out.println("�߸��� �Է�");
				continue;
			}
			System.out.print("������ �ϴ� ĭ ��ȣ �Է�(���� / ����): "); // ����ĭ �Է¹ޱ�
			try {
				int column = sc.nextInt() - 1;
				int row = sc.nextInt() - 1;

				if (select == 1) {
					field[column][row].setCellState(1);
				} else if (select == 2) {
					field[column][row].setCellState(2);
				} else if (select == 3) {
					field[column][row].setCellState(3);
				}

				/////////////// ���� ����� ���� ����//////////////////
				if (field[column][row].getCellState() == 3 && field[column][row].isMine()) {
					System.out.println("!!BANG!!");
					for (int i = 0; i < y; i++) {
						for (int j = 0; j < x; j++) {
							if (field[i][j].isMine())
								field[i][j].setCellState(3);
						}
					}
					printField();
					return;
				}

				////////////// 0�϶��� ����///////////////////

				if (field[column][row].getCellState() == 3
						&& field[column][row].getArroundMineNum() == 0) {
					for (int i = -1; i < 2; i++) {
						for (int j = -1; j < 2; j++) {
							try {
								field[i+column][j+row].setCellState(3);
							} catch (ArrayIndexOutOfBoundsException e) {
								// try-catch�� ������ �Ѵ� �ε����� ����ó��
							}
						}
					}
				}

				///////////////////// �¸� ����////////////////////////
				int resultCount = 0;
				for (int i = 0; i < mineNum; i++) {
					if (field[mineY[i]][mineX[i]].isMine() && field[mineY[i]][mineX[i]].getCellState() == 2)
						resultCount++;
				}
				if (resultCount == mineNum) {
					printField();
					System.out.println("=====================================");
					System.out.println("=====================================");
					System.out.println("=================�¸�!================");
					System.out.println("=====================================");
					System.out.println("=====================================");
					return;
				}
			} catch (Exception e) { // �Է� ���� ĳġ
				System.out.println("�߸��� �Է�");
			}
		}
	}
}