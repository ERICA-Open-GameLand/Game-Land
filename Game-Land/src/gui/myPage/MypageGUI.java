package gui.myPage;

import javax.swing.JFrame;

import gui.gameLauncher.GameLauncherGUI;
import gui.userInfo.UserInfo;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MypageGUI extends JFrame{


    // 필드 변수 정의
    private UserInfo userInfo;
    private GameLauncherGUI gameLauncher_gui;

    // 생성 메서드
    public MypageGUI(UserInfo u, GameLauncherGUI g){
        userInfo = u;
        gameLauncher_gui = g;

        Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

        // MyPageGUI - NORTH
        JLabel mypageTitle = new JLabel("마이페이지", SwingConstants.CENTER);
        mypageTitle.setFont(new Font("Aharoni 굵게", Font.BOLD, 50));
        cp.add(mypageTitle, BorderLayout.NORTH);




        // MypageGUI - CENTER
        /*
         * TO DO
         * CENTER에 배치된
         * Text
         * Button을 두 패널로 분리해서 원하는 뷰를 구성해보기
         * [텍스트와 버튼 요소들이 서로 붙어져 있는 채로 배치]
         */
        JPanel p_userInfo = new JPanel(new FlowLayout(FlowLayout.LEFT, 150, 0));

        // 패널 요소 1. 유저 이름 텍스트
        JLabel userName_text = new JLabel(userInfo.getUserName() + "님의 게임 진행상황입니다.");
        userName_text.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));
        userName_text.setBorder(BorderFactory.createEmptyBorder(30,0,50,0));

        // 패널 요소 - 코인 갯수 텍스트 - 추가 구현

        // 패널 요소 2. 블랙잭 게임 진행상황 텍스트
        JLabel blackjack_text = new JLabel("블랙잭 : " + userInfo.getBlackjeckChips() + " Chips");
        blackjack_text.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));
        blackjack_text.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

        // 패널 요소 3. 슬라이드 퍼즐 게임 진행상황 텍스트
        JLabel slidePuzzle_text = new JLabel("슬라이드 퍼즐 게임 : " + userInfo.getSlidePuzzleGameTime()[0] + "분  " + userInfo.getSlidePuzzleGameTime()[1] + "초");
        slidePuzzle_text.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));
        slidePuzzle_text.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

        // 패널 요소 4. 스도쿠 게임 진행상황 텍스트
        JLabel sudoku_text = new JLabel("스도쿠 : " + userInfo.getSudokuTime()[0] + "분  " + userInfo.getSudokuTime()[1] + "초");
        sudoku_text.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));
        sudoku_text.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

        // 패널 요소 5. 짝 맞추기 게임 진행상황 텍스트
        JLabel matching_text = new JLabel("짝 맞추기 게임 : " + userInfo.getMatchingGameTime()[0] + "분  " + userInfo.getMatchingGameTime()[1] + "초");
        matching_text.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));
        matching_text.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));


        p_userInfo.add(userName_text);
        p_userInfo.add(blackjack_text);
        p_userInfo.add(slidePuzzle_text);
        p_userInfo.add(sudoku_text);
        p_userInfo.add(matching_text);
        cp.add(p_userInfo, BorderLayout.CENTER);



        // MypageGUI - SOUTH
        JPanel p_check_btn = new JPanel(new FlowLayout());

        JButton mypageCheckButton = new MypageCheckButton("확인", gameLauncher_gui, this);
        
        // 버튼 색상 설정
        mypageCheckButton.setBackground(Color.red);
        mypageCheckButton.setOpaque(true);
        mypageCheckButton.setBorderPainted(false);
        
        mypageCheckButton.setFont(new Font("Aharoni 굵게", Font.BOLD, 30)); // 버튼 폰트 설정
        mypageCheckButton.setSize(50, 50); // 버튼 텍스트 크기 설정
        mypageCheckButton.setPreferredSize(new Dimension(200, 70)); // 버튼 크기 설정

        p_check_btn.add(mypageCheckButton);
        p_check_btn.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
        cp.add(p_check_btn, BorderLayout.SOUTH);
        


        setTitle("소프링의 게임랜드 GUI");
        setSize(750,500);
        setVisible(true);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);





    }

    
}
