package gui.gameLauncher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.over.GameOverGUI;
import gui.userInfo.UserInfo;
import gui.userInfo.UserInfoGUI;
import matching_game.MatchingGameStarter;

public class MatchingButton extends JButton implements ActionListener {
	
	// 필드 변수 정의
    private UserInfo userInfo;
    private GameLauncherGUI game_launcher_gui;
	
	// 생성 메소드
	public MatchingButton(String btn_text, UserInfo u, GameLauncherGUI g) {
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
             * MatchingGame 게임 객체로 전환
             */
            
            // 게임 시작 시 코인 하나 소모
            userInfo.gameCoins = userInfo.gameCoins - 1;
            new MatchingGameStarter().startMatchingGame(userInfo, game_launcher_gui);
            game_launcher_gui.gui_unVisible();

        }



		

	}



}
