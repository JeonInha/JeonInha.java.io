import java.awt.*;
import javax.swing.JButton;

class ColorButton extends JButton {
	Color fontColor = Design.SBlack;
	Color bgColor = Design.LBeige;
	Color borderColor = Design.LBeige;

	public ColorButton(String text) {
		super(text);
	}

	// �׵θ��� ���°�!
	public ColorButton(String text, Color bgColor, Color fontColor) {
		super(text);
		this.bgColor = bgColor;
		this.fontColor = fontColor;
		this.borderColor = bgColor;
	}

	// �׵θ��� �ִ°�!
	public ColorButton(String text, Color bgColor, Color fontColor, Color borderColor) {
		super(text);
		this.bgColor = bgColor;
		this.fontColor = fontColor;
		this.borderColor = borderColor;
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// ��ư ���� ����
		int width = getWidth();
		// ��ư ���� ����
		int height = getHeight();

		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (getModel().isEnabled()) { // Ȱ��ȭ�Ǿ�����
			graphics.setColor(bgColor);

		} else if (!(getModel().isEnabled())) { // ��Ȱ��ȭ �Ǿ�����
			graphics.setColor(Color.gray);
			// ���콺 �÷��� ��
		}
		if (getModel().isRollover()) {
			graphics.setColor(bgColor.darker());
		}
		// ��ư ���� ĥ��
		graphics.fillRect(0, 0, width, height);

		// ���ڰ� �׷����� ������ ũ�� ����
		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

		// �ؽ�Ʈ ��ġ: ����, ����
		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

		// �׵θ� �׸��� �޼ҵ�
		if (getModel().isEnabled())
			graphics.setColor(borderColor);
		else
			graphics.setColor(Color.gray.darker());
		graphics.drawRect(0, 0, width - 1, height - 1);

		// ���� �׸��� �޼ҵ�
		if (getModel().isEnabled())
			graphics.setColor(fontColor);
		else
			graphics.setColor(Color.DARK_GRAY);
		
		graphics.setFont(Design.MSFont);
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();

		super.paintComponent(g);
	}
}
