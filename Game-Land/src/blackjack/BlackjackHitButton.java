package blackjack;

import java.awt.event.*;
import javax.swing.*;

public class BlackjackHitButton extends JButton implements ActionListener{
	
	private BlackjackFrame frame;
	private CardPlayer player;
	public BlackjackHitButton(BlackjackFrame f, CardPlayer p) {
		super("Hit");
		frame = f;
		player = p;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(frame.nowTurn() || player.countCard() <= 11)
			frame.dealFreshOneTo(player);
		else
			this.setEnabled(false);
		
	}
}
