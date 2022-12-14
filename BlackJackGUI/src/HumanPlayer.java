import javax.swing.*;

public class HumanPlayer extends CardPlayer{
	
	private String name; 
	private int chips;
	
	public HumanPlayer(int max_cards,String n) {
        super(max_cards);
        name = n;
	}
	
	public void youWin() {
		System.out.println(name + " 승리");
		chips += 1;
	}
	
	public void youWinBlackjack() {
		System.out.println(name + " 승리");
		chips += 2;
	}
	
	public void youLose() {
		System.out.println("딜러 승리");
		chips -= 1;
	}
	
	public void youDraw() {
		System.out.println("비김");
	}
	
	public int chips() {
		return chips;
	}
	
	
	

}
