package gui.gameLauncher;

import javax.swing.JButton;

import gui.myPage.MypageGUI;
import gui.userInfo.UserInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLauncherMypageButton extends JButton implements ActionListener {

    // 필드변수 정의
    private UserInfo userInfo;
    private GameLauncherGUI gameLauncher_gui;

    public GameLauncherMypageButton(String btn_text, UserInfo u, GameLauncherGUI g){
        super(btn_text);

        userInfo = u;
        gameLauncher_gui = g;

        addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        
        gameLauncher_gui.gui_unVisible(); // gui 가리기



        /*
         * TO DO 1. MypageGUI 클래스 구현
         */
        new MypageGUI(userInfo, gameLauncher_gui);
    }
    
}
