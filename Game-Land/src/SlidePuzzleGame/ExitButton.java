package SlidePuzzleGame;

import gui.gameLauncher.GameLauncherGUI;
import gui.userInfo.UserInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExitButton extends JButton {
    public ExitButton(ImageIcon img, ImageIcon img2) {
        super(img);
        this.setRolloverIcon(img2); //버튼에 마우스가 올라갈 때 이미지 변화
        this.setBorderPainted(false);
        this.setPreferredSize(new Dimension(110, 35));
    }
}


