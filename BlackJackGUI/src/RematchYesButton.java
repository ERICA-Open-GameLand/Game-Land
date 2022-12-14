import java.awt.event.*;
import javax.swing.*;

public class RematchYesButton extends JButton implements ActionListener{

	private RematchFrame frame;
	
	public RematchYesButton(RematchFrame f) {
		super("Rematch?");
		frame = f;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		frame.reset();
		frame.setVisible(false);
	}
}

