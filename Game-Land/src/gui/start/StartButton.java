
package gui.start;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.userInfo.UserInfoGUI;

public class StartButton extends JButton implements ActionListener {
	
	// 필드 변수 정의
    private StartGUI start_gui;
	
	// 생성 메소드
	public StartButton(String btn_text, StartGUI gui) {
        super(btn_text);
		start_gui = gui;
		addActionListener(this);
	}
	
	
	// Start 버튼 클릭 시 ActionListener 처리
	public void actionPerformed(ActionEvent e) {

        // StartGUI 창 닫기
        start_gui.startGUI_unVisible();
        
        // UserInfoGUI로 전환
        new UserInfoGUI();

		

	}



}
