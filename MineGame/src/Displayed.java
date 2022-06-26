import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.*;

public class Displayed extends JFrame {
	private Random random = new Random();
	private int mineNum = 10;
	private int x = 9;
	private int y = 9;
	private Mine[][] field = new Mine[x][y];
	// ���� 9, ���� 9, ���� 10�� (12.3%)
	private int[] mineX = new int[mineNum];
	private int[] mineY = new int[mineNum];
	// ������ x, y ��ǥ

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

	private void setMineinField() { // �ʵ忡 ���� �ɱ�
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

	private void setArroundMineNuminField() { // �ʵ忡 �ֺ� ���� ���� �ɱ�
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				countArroundMineNum(i, j);
			}
		}
	}

	private void TestMineXY() {

		for (int i = 0; i < 9; i++) {
			mineX[8] = i;
			mineY[8] = i;
		}
		mineX[9] = 0;
		mineY[9] = 1;

		// mineX {0, 1, 2, 3, 4, 5, 6, 7, 8, 0}
		// mineY {0, 1, 2, 3, 4, 5, 6, 7, 8, 1}
	}

	private String cellStateToBLabel(Mine a) {
		if (a.getCellState() == 0)
			return " ";
		else if (a.getCellState() == 1)
			return "?";
		else if (a.getCellState() == 2)
			return "��";
		else if (a.getCellState() == 3)
			return Integer.toString(a.getArroundMineNum());
		else
			return null;

	}

//				if (field[i][j].getCellState() == 0) { // �� ���¿� ���� ǥ��
//					System.out.print("|   "); // �� �� ĭ
//				} else if (field[i][j].getCellState() == 1) {
//					System.out.print("| ? "); // ����ǥ �޸�
//				} else if (field[i][j].getCellState() == 2) {
//					System.out.print("| �� "); // ���� ǥ��
//				} else if (field[i][j].getCellState() == 3) { // ĭ ����
//					System.out.printf("| %d ", field[i][j].getArroundMineNum());
//				}

	Displayed() {

		setMineXY(); // ���� ����
//		TestMineXY(); // �׽�Ʈ����
		setMineinField(); // ���� �ɱ�
		setArroundMineNuminField(); // ��ó�� ���� ���� �ɱ�

		JPanel pnl = new JPanel(); // ��ü ����
		JPanel fieldBtns = new JPanel(); // ���� �ʵ�
		JPanel top = new JPanel(); // top ����: ���߿� �߰�
		BoxLayout pnlBox = new BoxLayout(pnl, BoxLayout.Y_AXIS); // top�̶� �����ʵ� ���η� �ױ�

		//////////////////////////
		pnl.setLayout(pnlBox);

		pnl.add(top);
		pnl.add(fieldBtns);

		add(pnl);
		////////////////////////
		// top ��Ʈ
		JRadioButton open = new JRadioButton("ĭ ����");
		JRadioButton check = new JRadioButton("���� üũ");
		JRadioButton memo = new JRadioButton("�޸�(? ǥ��)");
		ButtonGroup stateBtn = new ButtonGroup();
		JLabel winlose = new JLabel("����ã�� ���� ����");

		stateBtn.add(open);
		stateBtn.add(check);
		stateBtn.add(memo);

		top.add(open);
		top.add(check);
		top.add(memo);
		top.add(winlose);

		open.setSelected(true); // open ��ư �̸� �������ֵ���

		// ���ڿ� ��ư�� ������ �� ����
		Map<Mine, JButton> mineBtn = new HashMap<Mine, JButton>();

		///////////////////////// ���� ��ư �׼�
		ActionListener mineBtnAct = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JButton btn = (JButton) e.getSource();

				for (Entry<Mine, JButton> entry : mineBtn.entrySet()) { // ��Ʈ�� ����ؼ� ��ü�� ����
					if (entry.getValue().equals(e.getSource())) {
						Mine mine = entry.getKey();

						if (open.isSelected()) {// ����ĭ�� �� ��Ȳ ���� ��ȭ��Ű�� (������ư���� if�� ����)
							mine.setCellState(3);
							btn.setEnabled(false); // ���õ� ��ư ��Ȱ��ȭ
						} else if (check.isSelected()) {
							mine.setCellState(2);
						} else if (memo.isSelected()) {
							mine.setCellState(1);
						}

						btn.setText(cellStateToBLabel(mine)); // �� ��Ȳ ���
						winlose.setText("����ã�� ������");

						if (mine.isMine()&&mine.getCellState()==3) { // ���� ����� ��
							for (int i = 0; i < mineNum; i++) {
								Mine minecell = field[mineY[i]][mineX[i]];
									mineBtn.get(minecell).setText("��");
									mineBtn.get(minecell).setEnabled(true);
									mineBtn.get(minecell).setBackground(Color.red);
									
							}
							winlose.setText("�й� �� ��");
						}
						
						///// �¸� ����
						int resultCount = 0;
						for (int i = 0; i < mineNum; i++) {
							if (field[mineY[i]][mineX[i]].isMine() && field[mineY[i]][mineX[i]].getCellState() == 2)
								resultCount++;
						}
						if (resultCount == mineNum) {
							winlose.setText("�¸�!!!!");
						}
					}
				}
			}
		};

		//////////////////////////////////////

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				mineBtn.put(field[i][j], new JButton());
				fieldBtns.add(mineBtn.get(field[i][j]));
				mineBtn.get(field[i][j]).addActionListener(mineBtnAct);
			}
		}

		GridLayout grid = new GridLayout(x, y);
		fieldBtns.setLayout(grid);

		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}