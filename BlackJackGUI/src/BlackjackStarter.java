import gui.userInfo.GameLauncherGUI;
import gui.userInfo.UserInfo;

public class BlackjackStarter {

	private UserInfo user;
	private GameLauncherGUI launcher;
	
	
	public BlackjackStarter(UserInfo u, GameLauncherGUI l) {
		user = u;
		launcher = l;
		new BlackjackFrame(user,this).manageBlackjack();
	}
	
	public void returncoin(int earnCoin) {
		if(user.gameCoins + earnCoin > user.blackjeckChips)
			user.blackjeckChips += (user.gameCoins + earnCoin);
		launcher.set_visible();
		launcher.gui_update();
		
	}

	

}
