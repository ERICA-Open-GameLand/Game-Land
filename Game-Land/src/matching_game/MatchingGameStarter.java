package matching_game;

import java.util.Optional;

import gui.gameLauncher.GameLauncherGUI;
import gui.userInfo.UserInfo;

public class MatchingGameStarter {
	private UserInfo user_info;
	private BoardFrame frame;
	private GameLauncherGUI gui;
//	// test
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new BoardFrame(0, new MatchingGameStarter());
//	}
	
	
	// matching game starter에 UserInfo 넘겨 줄 것!
	public void startMatchingGame(UserInfo us,GameLauncherGUI g) {
		user_info = us;
		gui = g;
		int time = Long.valueOf(Optional.ofNullable(user_info.matchingGameTime).orElse((int) 0L)).intValue();
		frame = new BoardFrame(time, this);
	}
	public void setTime(int i) {
		user_info.matchingGameTime = i;
		frame.setVisible(false);
		gui.setVisible(true);
		gui.gui_update();
	}

}
