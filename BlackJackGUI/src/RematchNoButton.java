import java.awt.event.*;
import javax.swing.*;

public class RematchNoButton extends JButton implements ActionListener{

	private RematchFrame frame;
	
	public RematchNoButton(RematchFrame f) {
		super("Exit");
		frame = f;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		frame.exitProcedure();
	}
}
