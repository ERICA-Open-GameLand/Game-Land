package gui.myPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.gameLauncher.GameLauncherGUI;
import gui.userInfo.UserInfo;
import gui.userInfo.UserInfoGUI;

public class MypageCheckButton extends JButton implements ActionListener {
	
	// 필드 변수 정의
    private GameLauncherGUI game_launcher_gui;
    private MypageGUI mypage_gui;
	
	// 생성 메소드
	public MypageCheckButton(String btn_text, GameLauncherGUI g, MypageGUI mg) {
        super(btn_text);
        game_launcher_gui = g;
        mypage_gui = mg;
        
		addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {

        mypage_gui.setVisible(false);
        game_launcher_gui.setVisible(true);


		

	}



}

