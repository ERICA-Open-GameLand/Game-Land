package gui.gameLauncher;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import gui.userInfo.UserInfo;

public class GameLauncherGUI extends JFrame{
   

    // 필드변수 정의
    private UserInfo userInfo; // 유저 정보 객체
    private JLabel coinText_JLabel;

    // 생성 메소드
    public GameLauncherGUI(UserInfo u) throws IOException{
        userInfo = u;

        Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

        // BorderLayout - NORTH 패널
        JPanel p_gameLauncherGUI_coins_mypageBtn = new JPanel(new FlowLayout());
        
        // 패널 요소 1. 코인 이미지
        File coinImgFile = new File("src/gui/image/dollar.png");
        BufferedImage coinImg = ImageIO.read(coinImgFile);

        
        ImageIcon coinImgIcon = new ImageIcon(coinImg); // 코인 이미지 객체 생성
        Image getCoinImg = coinImgIcon.getImage(); // 코인 이미지 가져오기

        Image editCoinImg = getCoinImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // 가져온 이미지 크기 설정
        ImageIcon editCoinImgIcon = new ImageIcon(editCoinImg); // 조절된 이미지로 이미지 객체 생성

        
        JLabel coinImg_JLabel = new JLabel(editCoinImgIcon); // JLabel 객체 생성
        p_gameLauncherGUI_coins_mypageBtn.add(coinImg_JLabel); // 패널에 요소로 이미지 JLabel 추가

        
        // 패널 요소 2. 코인 : 텍스트
        JLabel coinText = new JLabel("코인 : " + userInfo.getGameLauncherCoin() + "개");
        coinText.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));
        coinText.setBorder(BorderFactory.createEmptyBorder(0,0,0,370));
        coinText_JLabel = coinText; // Coins 텍스트 필드변수로 저장
        p_gameLauncherGUI_coins_mypageBtn.add(coinText);


        // 패널 요소 3. 마이페이지 버튼
        JButton mypage_btn = new GameLauncherMypageButton("마이페이지", userInfo, this);

        // 버튼 색상 설정
        mypage_btn.setBackground(Color.red);
        mypage_btn.setOpaque(true);
        mypage_btn.setBorderPainted(false);
        
        mypage_btn.setFont(new Font("Aharoni 굵게", Font.BOLD, 15)); // 버튼 폰트 설정
        mypage_btn.setSize(30, 25); // 버튼 텍스트 크기 설정
        mypage_btn.setPreferredSize(new Dimension(150, 50)); // 버튼 크기 설정
        p_gameLauncherGUI_coins_mypageBtn.add(mypage_btn);
        cp.add(p_gameLauncherGUI_coins_mypageBtn, BorderLayout.NORTH);






        // BorderLayout - CENTER 패널
        JPanel p_gameLauncherGUI_gameText_gameBtn = new JPanel(new GridLayout(2,4, 30,70));

        // 패널 요소 1. 게임 텍스트 (블랙잭, 슬라이드 퍼즐 게임, 스도쿠, 짝 맞추기 게임)
        JLabel blackText = new JLabel("블랙잭", SwingConstants.CENTER);
        blackText.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));

        JLabel slideText = new JLabel("<html><body><center>슬라이드<br>퍼즐게임</center></body></html>", SwingConstants.CENTER);
        slideText.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));

        JLabel sudokuText = new JLabel("스도쿠", SwingConstants.CENTER);
        sudokuText.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));
        
        JLabel matchingText = new JLabel("<html><body><center>짝 맞추기<br>게임</body></html>", SwingConstants.CENTER);
        matchingText.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));

        p_gameLauncherGUI_gameText_gameBtn.add(blackText);
        p_gameLauncherGUI_gameText_gameBtn.add(slideText);
        p_gameLauncherGUI_gameText_gameBtn.add(sudokuText);
        p_gameLauncherGUI_gameText_gameBtn.add(matchingText);


        // 패널 요소 2. 게임 버튼 (블랙잭, 슬라이드 퍼즐 게임, 스도쿠, 짝 맞추기 게임)
        JButton blackjack_btn = new BlackjackButton("게임시작", userInfo, this);
        // 버튼 색상 설정
        blackjack_btn.setBackground(Color.red);
        blackjack_btn.setOpaque(true);
        blackjack_btn.setBorderPainted(false);
    
        blackjack_btn.setFont(new Font("Aharoni 굵게", Font.BOLD, 20)); // 버튼 폰트 설정
        blackjack_btn.setSize(50, 50); // 버튼 텍스트 크기 설정
        blackjack_btn.setPreferredSize(new Dimension(200, 70)); // 버튼 크기 설정


        JButton slidePuzzle_btn = new SlidePuzzleButton("게임시작", userInfo, this);
        // 버튼 색상 설정
        slidePuzzle_btn.setBackground(Color.red);
        slidePuzzle_btn.setOpaque(true);
        slidePuzzle_btn.setBorderPainted(false);
    
        slidePuzzle_btn.setFont(new Font("Aharoni 굵게", Font.BOLD, 20)); // 버튼 폰트 설정
        slidePuzzle_btn.setSize(50, 50); // 버튼 텍스트 크기 설정
        slidePuzzle_btn.setPreferredSize(new Dimension(200, 70)); // 버튼 크기 설정

        JButton sudoku_btn = new SudokuButton("게임시작", userInfo, this);
        // 버튼 색상 설정
        sudoku_btn.setBackground(Color.red);
        sudoku_btn.setOpaque(true);
        sudoku_btn.setBorderPainted(false);
    
        sudoku_btn.setFont(new Font("Aharoni 굵게", Font.BOLD, 20)); // 버튼 폰트 설정
        sudoku_btn.setSize(50, 50); // 버튼 텍스트 크기 설정
        sudoku_btn.setPreferredSize(new Dimension(200, 70)); // 버튼 크기 설정

        JButton matching_btn = new MatchingButton("게임시작", userInfo, this);
        // 버튼 색상 설정
        matching_btn.setBackground(Color.red);
        matching_btn.setOpaque(true);
        matching_btn.setBorderPainted(false);
    
        matching_btn.setFont(new Font("Aharoni 굵게", Font.BOLD, 20)); // 버튼 폰트 설정
        matching_btn.setSize(50, 50); // 버튼 텍스트 크기 설정
        matching_btn.setPreferredSize(new Dimension(200, 70)); // 버튼 크기 설정

        p_gameLauncherGUI_gameText_gameBtn.add(blackjack_btn);
        p_gameLauncherGUI_gameText_gameBtn.add(slidePuzzle_btn);
        p_gameLauncherGUI_gameText_gameBtn.add(sudoku_btn);
        p_gameLauncherGUI_gameText_gameBtn.add(matching_btn);
        
        p_gameLauncherGUI_gameText_gameBtn.setBorder(BorderFactory.createEmptyBorder(50,20,100,20));
        cp.add(p_gameLauncherGUI_gameText_gameBtn, BorderLayout.CENTER);

        









        setTitle("소프링의 게임랜드 GUI");
        setSize(750,500);
        setVisible(true);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }








    // gui 가리기
    public void gui_unVisible(){
        this.setVisible(false);
    }

    // gui 보이기
    public void gui_visible(){
        this.setVisible(true);
    }


    // gui 업데이트
    public void gui_update(){
        coinText_JLabel.setText("코인 : " + userInfo.getGameLauncherCoin() + "개");
    }


}
