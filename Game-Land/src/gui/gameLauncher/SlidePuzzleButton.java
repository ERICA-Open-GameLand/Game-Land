package gui.gameLauncher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import SlidePuzzleGame.PuzzleStarter;
import gui.over.GameOverGUI;
import gui.userInfo.UserInfo;
import gui.userInfo.UserInfoGUI;

public class SlidePuzzleButton extends JButton implements ActionListener {
	
	// 필드 변수 정의
    private UserInfo userInfo;
    private GameLauncherGUI game_launcher_gui;
	
	// 생성 메소드
	public SlidePuzzleButton(String btn_text, UserInfo u, GameLauncherGUI g) {
        super(btn_text);
		userInfo = u;
        game_launcher_gui = g;
        
		addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {

        if(userInfo.gameCoins == 0){
            game_launcher_gui.gui_unVisible();
            new GameOverGUI();
        }
        else{
            /*
             * TO DO
             * slidePuzzleGame 게임 객체로 전환
             */
             game_launcher_gui.gui_unVisible();
             userInfo.gameCoins = userInfo.gameCoins - 1;
             new PuzzleStarter().slidePuzzleGameStart(userInfo,game_launcher_gui);
        }


		

	}



}
