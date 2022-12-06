package matching_game;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class PieceButton extends JButton implements ActionListener{
	
	private Color color;
    private boolean revealed, game_start;
    private int row, col; 
    private static boolean selected;
    private BoardFrame frame;

    public PieceButton(Color c, BoardFrame b, int r, int co) {
        color = c;
        frame= b;
        row =r;
        col = co;
        addActionListener(this);
    }
    
    public Color color() {
    	return color;
    }

    public void hide() {
    	this.setBackground(Color.white);
		setOpaque(true);			
		setBorderPainted(true);
    	
    }
    public void show() {
    	setBackground(color);
		setOpaque(true);			
		setBorderPainted(false);
    }
    public void setRevealed() { 
        revealed = true; 
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!game_start){
			frame.timerStart();
			game_start = true;
		}
		if(!revealed) {			
			show();
			if(selected) { // 두번째 선택된 버튼 
				selected = false;
				
				Timer timer = new Timer(1000, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {						
						frame.compareColor(row, col);
					}
				});
				timer.start(); 
				timer.setRepeats(false);
			}
			else { // 첫번째 선택된 버튼
				selected = true;
				frame.firstColor(row, col);
			}
		}
	}
}
