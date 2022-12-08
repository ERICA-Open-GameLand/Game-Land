package matching_game;

import java.awt.event.*;
import javax.swing.*;

public class ExitButton extends JButton implements ActionListener {
	
	private BoardFrame frame;
	
	public ExitButton(String label, BoardFrame f) {
		super(label);
		frame = f;
        addActionListener(this);
	}
    public void actionPerformed(ActionEvent e) {
    	frame.exitGame();
	}
	
}
