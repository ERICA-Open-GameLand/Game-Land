package matching_game;

public class MatchingGameStarter {
	private int best_time;

//	// test
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new BoardFrame(0, new MatchingGameStarter());
//	}
	
	public void startMatchingGame(int bt) {
		new BoardFrame(bt, this);
	}
	public void setTime(int i) {
		best_time = i;
	}

}
