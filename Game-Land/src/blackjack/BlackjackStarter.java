package blackjack;

import gui.gameLauncher.GameLauncherGUI;
import gui.userInfo.UserInfo;

public class BlackjackStarter {

	private UserInfo user;
	private GameLauncherGUI launcher;


	public void blackjackstart(UserInfo u, GameLauncherGUI l) {
		user = u;
		launcher = l;
		new BlackjackFrame(user,this).manageBlackjack();
	}
	public void returncoin(int earnCoin, BlackjackFrame f) {
		if((user.gameCoins + earnCoin )> user.blackjeckChips) {
			int earn = user.gameCoins + earnCoin;
			user.blackjeckChips = earn;
			user.gameCoins = user.gameCoins + earnCoin;
		}
		f.setVisible(false);
		launcher.setVisible(true);
		launcher.gui_update();

	}
}