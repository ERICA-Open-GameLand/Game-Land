package SlidePuzzleGame;

import SlidePuzzleGame.GameTimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PuzzleButton extends JButton implements ActionListener {

    private SlidePuzzleBoard board;
    private PuzzleFrame frame;

    private GameTimer timer;

    public PuzzleButton(SlidePuzzleBoard b, PuzzleFrame f) {
        super.setBackground(new Color(232,228,217));
        board = b;
        frame = f;
        addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        if (board.on()) {
            String s = getText();
            if (!s.equals("") && board.move(Integer.parseInt(s))) {
                frame.update();
                if (board.gameOver()) {
                    frame.sTimer.stop();
                    frame.finish();
                }
            }
        }
    }
}
