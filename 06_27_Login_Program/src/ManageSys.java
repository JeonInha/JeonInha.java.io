import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class ManageSys extends JFrame {
	Map<String, String> account = new HashMap<>();	// 
	Login login = new Login();
	SignUp signUp = new SignUp();
	
	public void putData() {
		account.put("qwer", "qwer");
	}

	ManageSys() {
		putData();
		CardLayout layout = new CardLayout();
		// 개발자의 의도대로 조종할 수 있는 탭메뉴
		JPanel center = new JPanel(layout);
		// 카드보드 레이아웃을 가진 패널 생성

		JPanel log = login.LoginSwing();	// 로그인 패널
		JPanel su = signUp.SignUpSwing();	// 가입 패널

		center.add(log);
		center.add(su);

		add(center);

		/// next로 카드레이아웃 순환하는 액션리스너
		ActionListener nextAct = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.next(center);
				if (getTitle().equals("login")) {
					setTitle("sign up");
				} else {
					setTitle("login");
				}
			}
		};

		// 가입 액션리스너
		ActionListener signUpAct = new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (account.containsKey(signUp.getIdInput().getText())) {
					signUp.getSignUpsysM().setText("이미 있는 아이디입니다.");
				} else if (!(signUp.getPwInput().getText().equals(signUp.getPwCheck().getText()))) {
					signUp.getSignUpsysM().setText("패스워드가 다릅니다.");
				} else {
					account.put(signUp.getIdInput().getText(), signUp.getPwInput().getText());
					signUp.getSignUpsysM().setText("가입 성공");
				}
			}
		};

		// 가입 액션리스너
		ActionListener loginAct = new ActionListener() {	// 로그인 액션리스너
			@Override
			public void actionPerformed(ActionEvent e) {

				if (account.containsKey(login.getIdInput().getText())
						&& account.get(login.getIdInput().getText()).equals(login.getPwInput().getText())) {
					JOptionPane.showMessageDialog(login.getLoginBtn(), "로그인 성공!", "login success",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(login.getLoginBtn(), "아이디 혹은 패스워드를 잘못 입력하였습니다.", "login fail",
							JOptionPane.ERROR_MESSAGE);
				}
				login.getIdInput().setText("");
				login.getPwInput().setText("");
			}
		};

		login.getLoginBtn().addActionListener(loginAct);
		login.getJoinBtn().addActionListener(nextAct);
		signUp.getLoginBtn().addActionListener(nextAct);
		signUp.getSignUpBtn().addActionListener(signUpAct);

		setTitle("login");
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
