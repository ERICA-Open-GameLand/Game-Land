package gui.userInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import gui.gameLauncher.GameLauncherGUI;
import gui.userInfo.UserInfoGUI;

public class UserInfoButton extends JButton implements ActionListener {
	
	// 필드 변수 정의
    private UserInfoGUI userInfo_gui;
	
	// 생성 메소드
	public UserInfoButton(String btn_text, UserInfoGUI gui) {
        super(btn_text);

        userInfo_gui = gui;
		addActionListener(this);
	}
	
	
	// 확인 버튼 클릭 시 ActionListener 처리
	public void actionPerformed(ActionEvent e) {

        // 확인 버튼 클릭 시 Frame 텍스트 필드 가져오기

        
        /*
         * 유저 이름
         */
        String userName = userInfo_gui.userInfo_textField[0].getText();

        /*
         * 유저 나이
         */
        String userAge = userInfo_gui.userInfo_textField[1].getText();


        // UserInfo 객체 생성
        UserInfo userInfo = new UserInfo(userName, userAge);

        // 디버깅 코드
        System.out.println(userInfo.getUserName() +" " + userInfo.getUserAge());

        // userInfo GUI 가리기
        userInfo_gui.gui_unVisible();

        // GameLauncherGUI 페이지로 전환
        try {
            new GameLauncherGUI(userInfo);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }






		

	}



}
