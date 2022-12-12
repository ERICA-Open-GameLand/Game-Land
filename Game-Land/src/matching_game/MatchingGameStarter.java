package matching_game;

import java.util.Optional;

import gui.userInfo.UserInfo;

public class MatchingGameStarter {
	private UserInfo user_info;
//	// test
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new BoardFrame(0, new MatchingGameStarter());
//	}
	
	
	// matching game starter에 UserInfo 넘겨 줄 것!
	public void startMatchingGame(UserInfo us) {
		user_info = us;
		new BoardFrame(Long.valueOf(Optional.ofNullable(user_info.matchingGameTime).orElse(0L)).intValue(), this);
	}
	public void setTime(int i) {
		user_info.matchingGameTime = i;
	}

}
