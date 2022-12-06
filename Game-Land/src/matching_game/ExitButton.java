package matching_game;

import java.awt.event.*;
import javax.swing.*;

public class ExitButton extends JButton implements ActionListener {
	
	private boolean end = false; 
	
	public ExitButton(String label) {
		super(label);
        addActionListener(this);
	}
	
	public boolean end() {
		return end;
	}
	
    public void actionPerformed(ActionEvent e) {
		end = true;
	}
	
}
