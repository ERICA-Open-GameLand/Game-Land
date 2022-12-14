package SlidePuzzleGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartButton extends JButton implements ActionListener {

    private SlidePuzzleBoard board;
    private PuzzleFrame frame;

    public StartButton(SlidePuzzleBoard b, PuzzleFrame f, ImageIcon img, ImageIcon img2) {
        super(img);
        this.setRolloverIcon(img2); //버튼에 마우스가 올라갈 때 이미지 변화
        this.setBorderPainted(false);
        this.setPreferredSize(new Dimension(100, 35));
        board = b;
        frame = f;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent a) {
        frame.timerStart();
        board.createPuzzleBoard();
        frame.update();
    }
}


