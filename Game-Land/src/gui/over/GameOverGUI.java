package gui.over;


import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameOverGUI extends JFrame {
    

    // 필드 변수 정의


    // 생성 메소드
    public GameOverGUI(){

        Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

        // GameOverGUI - NORTH
        JLabel gameOverTitle = new JLabel("게임 종료", SwingConstants.CENTER);
        gameOverTitle.setFont(new Font("Aharoni 굵게", Font.BOLD, 70));
        cp.add(gameOverTitle, BorderLayout.NORTH);

        // GameOverGUI - CENTER
        JPanel p_gameOver_DesText = new JPanel(new FlowLayout());
        JLabel gameOverDescription = new JLabel("<html><body><center>코인을 모두 사용했네요..<br>다음번에 다시 도전해주세요.</center></body></html>", SwingConstants.CENTER);
        gameOverDescription.setFont(new Font("Aharoni 굵게", Font.BOLD, 40));
        p_gameOver_DesText.add(gameOverDescription);

        // 게임 종료 설명 텍스트 패널에 마진 주기
        p_gameOver_DesText.setBorder(BorderFactory.createEmptyBorder(70,0,0,0));
        cp.add(p_gameOver_DesText, BorderLayout.CENTER);

        // GameOverGUI - SOUTH
        JPanel p_gameOver_btn = new JPanel(new FlowLayout());
        JButton gameOver_btn = new JButton("게임런처 종료");

        // 버튼 색상 설정
        gameOver_btn.setBackground(Color.red);
        gameOver_btn.setOpaque(true);
        gameOver_btn.setBorderPainted(false);
        
        gameOver_btn.setFont(new Font("Aharoni 굵게", Font.BOLD, 20)); // 버튼 폰트 설정
        gameOver_btn.setSize(50, 50); // 버튼 텍스트 크기 설정
        gameOver_btn.setPreferredSize(new Dimension(200, 70)); // 버튼 크기 설정
        
        ActionListener listener = new ActionListener(){

            public void actionPerformed(ActionEvent e){

                // 시스템 종료
                System.exit(0);
            }
        };

        // btn 액션 리스너 객체추가
        gameOver_btn.addActionListener(listener);
        p_gameOver_btn.add(gameOver_btn);

        // 버튼 패널에 마진 주기
        p_gameOver_btn.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
        cp.add(p_gameOver_btn, BorderLayout.SOUTH);



        setTitle("소프링의 게임랜드 GUI");
        setSize(750,500);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
