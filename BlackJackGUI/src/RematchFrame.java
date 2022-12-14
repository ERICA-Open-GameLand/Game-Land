import javax.swing.*;
import java.awt.*;

public class RematchFrame extends JFrame{

	private BlackjackFrame frame;
	
	public RematchFrame(BlackjackFrame f,String n) {
		frame = f;
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		JPanel p1 = new JPanel(new FlowLayout());
		p1.add(new RematchYesButton(this));
		p1.add(new RematchNoButton(this));
		
		cp.add(p1);
		setTitle(n);
        setSize(200,100);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void reset() {
		frame.resetBlackjack();
		this.setVisible(false);
	}
	
	public void exitProcedure() {
		frame.exitProcedure();
		this.dispose();
	}
}
