package matching_game;

import java.awt.Color;
import java.awt.event.*;
import java.util.EventListener;

import javax.swing.*;

public class PieceButton extends JButton implements ActionListener{
	
	private Color color;
    private boolean revealed, reveal;
    private static int open_piece_count;
    private BoardFrame frame;

    public PieceButton(Color c, BoardFrame b) {
        color = c;
        frame= b;
        System.out.println("this");
        addActionListener(this);
    }
    
    public Color color() {
    	return color;
    }

    public void setRevealFalse() {
    	reveal = false;
    	this.setBackground(Color.white);
    	
    }
    public void setRevealTrue() {
    	System.out.println(color);
    	reveal = true;
    	this.setText("11");
    	setBackground(color);
    }
    public boolean reveal() {
    	return reveal;
    }
    
    public void setRevealed() {
    	revealed = true;
    }
    public boolean revealed() { 
        return revealed; 
    }
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(open_piece_count >= 2) {
			open_piece_count= 0;
			
		}
		else if(revealed == false) {
			setRevealTrue();
			open_piece_count++;
			frame.update();
		}
	}
}
