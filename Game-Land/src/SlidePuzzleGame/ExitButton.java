package SlidePuzzleGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExitButton extends JButton implements ActionListener {

    private SlidePuzzleBoard board;

    private GameTimer timer;

    public ExitButton(ImageIcon img, ImageIcon img2) {
        super(img);
        this.setRolloverIcon(img2); //버튼에 마우스가 올라갈 때 이미지 변화
        this.setBorderPainted(false);
        this.setPreferredSize(new Dimension(110, 35));
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent a) {
        System.exit(0);
       /* try {
            if(board.gameOver())
                timer.bestTime();
            else
                JOptionPane.showMessageDialog(null, "게임이 끝나지 않았습니다. \n" +
                        " 게임은 기록되지 않습니다. ");
            System.exit(0);
        }
        catch (Exception e) {
            System.out.println(e.getCause());
            System.exit(0);
        }*/
        //System.out.println(timer.best_time);
    }
}


