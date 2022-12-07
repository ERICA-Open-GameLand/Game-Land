package gui.userInfo;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

public class UserInfoGUI extends JFrame {
    
    // 필드 변수 정의
    public JTextField userInfo_textField[];



    // 생성 메소드
    public UserInfoGUI(){
        

        // UserInfoGUI의 메인 Layout {컨테이너} 정의
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		


        /*
         * TO DO 1. UserInfoGUI 타이틀 텍스트
         */
        JPanel p_userInfoGuiTitle = new JPanel(new FlowLayout());
        JLabel userInfoGuiTitle = new JLabel("유저 정보 입력", SwingConstants.CENTER);
        
        // JLabel 텍스트 크기 조절 & 폰트 설정 & 가운데 정렬
        userInfoGuiTitle.setFont(new Font("Aharoni 굵게", Font.BOLD, 50));
        p_userInfoGuiTitle.add(userInfoGuiTitle);

        // 게임런처 인트로 텍스트 마진_TOP 주기
        p_userInfoGuiTitle.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        cp.add(p_userInfoGuiTitle, BorderLayout.NORTH);







        /*
         * TO DO 2. UserInfoGUI 유저 이름 텍스트 입력창
         * TO DO 3. UserInfoGUI 유저 나이 텍스트 입력창
         */

         // 유저의 텍스트 필드 입력정보를 담는 객체 생성 [name & age]
        userInfo_textField = new JTextField[2];

        // 유저 정보 (Name & Age) 의 TextField를 담는 패널 생성 - GridLayout
        JPanel p_userInfoTextField = new JPanel(new GridLayout(2,2, 50, 100));


        /*
         *  유저 이름 & 나이 텍스트 JLabel
         */
        JLabel userInfo_text_name = new JLabel("이름", SwingConstants.CENTER);
        JLabel userInfo_text_age = new JLabel("나이", SwingConstants.CENTER);

        // JLabel 텍스트 폰트 설정
        userInfo_text_name.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));
        userInfo_text_age.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));


        /*
         * 유저 Name & age TextField
         * 
         * Idx : 0 => User Name
         * Idx : 1 => User Age
         */
        userInfo_textField[0] = new JTextField();
        userInfo_textField[1] = new JTextField();

        // TextField 텍스트 폰트 설정
        userInfo_textField[0].setFont(new Font("Aharoni 굵게", Font.BOLD, 30));
        userInfo_textField[1].setFont(new Font("Aharoni 굵게", Font.BOLD, 30));

        // 유저 이름 (Text & TextField)
        p_userInfoTextField.add(userInfo_text_name);
        p_userInfoTextField.add(userInfo_textField[0]);
        
        // 유저 나이 (Text & TextField)
        p_userInfoTextField.add(userInfo_text_age);
        p_userInfoTextField.add(userInfo_textField[1]);

        p_userInfoTextField.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));

        /*
            TO DO. JPanel 크기 설정 (GridLayout 요소 크기를 작게 하기)
         */ 
        // p_userInfoTextField.setPreferredSize(new DimensionUIResource(100, 100));
        p_userInfoTextField.setBorder(BorderFactory.createEmptyBorder(50,0,50,100));
        cp.add(p_userInfoTextField, BorderLayout.CENTER);







        /*
         * TO DO 4. UserInfoGUI Check 버튼
         */
        JPanel p_checkButton = new JPanel(new FlowLayout());
        JButton checkButton = new UserInfoButton("완료", this);

        // 버튼 색상 설정
        checkButton.setBackground(Color.red);
        // 버튼 폰트 설정
        checkButton.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        // 버튼 텍스트 크기 설정
        checkButton.setSize(50, 50);
        // 버튼 크기 설정
        checkButton.setPreferredSize(new Dimension(200, 70));

        // 패널에 버튼 추가
        p_checkButton.add(checkButton);


        // // 게임런처 인트로 Start 버튼 마진_Top 주기
        p_checkButton.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
        cp.add(p_checkButton, BorderLayout.SOUTH);


        setTitle("소프링의 게임랜드 GUI");
        setSize(750,500);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }



    // gui 가리기
    public void gui_unVisible(){
        this.setVisible(false);
    }


}
