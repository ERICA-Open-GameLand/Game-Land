package matching_game;

import java.awt.*;
import java.util.Random;

public class GameBoard {
	private PieceButton[][] square;
	private BoardFrame frame;
	
    public PieceButton[][] square() { 
    	for(int i = 0 ; i < 4; i++) {
    		for(int j = 0; j < 4; j++) {
    			System.out.println(square[i][j].color());
    		}
    	}
        return square; 
    }
    
    public GameBoard(BoardFrame f) {
    	frame = f;
        square = new PieceButton[4][4];
        Color[] colors = {Color.BLUE, Color.CYAN, Color.PINK, Color.RED, 
                          Color.GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE};
        Color[] twins = new Color[16];
        for(int i = 0; i< 8; i++) {
        	for(int j = 0; j < 2; j++) {
        		twins[i*2+j] = colors[i];
        	}
        }
        makeSquare(shuffle(twins));
    }
    
    
    
    private void makeSquare(Color[] piece_color) {
        // to be filled...
    	int now_piece = 0;
    	
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				square[i][j] = new PieceButton(piece_color[now_piece++], frame);
			}
		}
    }
    
    private Color[] shuffle(Color[] twins) {
        int index;
        Color temp;
        Random random = new Random();
        for (int i = twins.length - 1; i > 0; i--) {
            index = random.nextInt(i+1);
            temp = twins[index];
            twins[index] = twins[i];
            twins[i] = temp;
            System.out.println(twins[i]);
        }
        return twins;
    }
    
}
