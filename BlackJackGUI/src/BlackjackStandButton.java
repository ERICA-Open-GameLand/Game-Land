import java.awt.event.*;
import javax.swing.*;

public class BlackjackStandButton extends JButton implements ActionListener{
	
	private BlackjackFrame frame;
	private CardPlayer player;
	
	public BlackjackStandButton(BlackjackFrame f, CardPlayer p) {
		super("Stand");
		frame = f;
		player = p;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		frame.yourTurn();
		frame.dealFreshOneTo(player);
		this.setEnabled(false);
	}
}

