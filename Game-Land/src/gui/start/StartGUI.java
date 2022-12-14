package gui.start;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;



public class StartGUI extends JFrame {


    // 필드 변수 정의
    private Image startIntroImg;

    // 이미지 너비
    private int w;
    // 이미지 높이
    private int h;


	// 생성 메소드
	public StartGUI() throws IOException {

		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		/*
		 * To DO 1. 게임런처 인트로 이미지 삽입
		 */

        /*
             To DO 1 - 2. 이미지를 JPanel에 넣는 작업
        */
        // ImageIcon startIntroImgIcon = new ImageIcon("../image/controller.jpg");


        // // 이미지 가로 길이
        // w = startIntroImgIcon.getIconWidth();
        // // 이미지 세로 길이
        // h = startIntroImgIcon.getIconHeight();

        // // 이미지를 가져옴
        // startIntroImg = startIntroImgIcon.getImage();


        // // 이미지를 패널형태로 만들고, 컨테이너 요소로 삽입
        // JPanel p1_startImg = new JPanel(new FlowLayout());
        // JPanel imgStartIntroPanel = new ImagePanel();
        // p1_startImg.add(imgStartIntroPanel);


        /*
         * To Do 1 - 2. 이미지 JLabel로 구현
        */
        File imgFile = new File("src/gui/image/controller.jpg");
        // 이미지 파일 예외처리 - 에러로그
        /*
         * 이미지 주소 받아오기
        */
        BufferedImage img = ImageIO.read(imgFile);


        /*
         * 이미지 주소에 따른 이미지 객체 생성 & 이미지 받아오기
        */
        ImageIcon IntroImgIcon = new ImageIcon(img);
        Image getImg = IntroImgIcon.getImage();

        /*
         * 받은 이미지 사이즈 조절
         */
        Image checkImg = getImg.getScaledInstance(270, 270, Image.SCALE_SMOOTH);

        /*
         * 사이즈 조절된 이미지 객체 생성
         */
        ImageIcon checkIntroImg = new ImageIcon(checkImg);


        /*
         * JLabel에 이미지 객체 삽입 후 객체 생성
         * 컨테이너에 JLabel 객체 추가
         */
        JLabel lb = new JLabel(checkIntroImg);
        cp.add(lb, BorderLayout.NORTH);


        /*
         * TO DO 2. 게임런처 인트로 텍스트
         */
        JPanel p_startTitle = new JPanel(new FlowLayout());
        JLabel startTitleJLabel = new JLabel("소프링의 게임랜드", SwingConstants.CENTER);
        
        // JLabel 텍스트 크기 조절 & 폰트 설정 & 가운데 정렬
        startTitleJLabel.setFont(new Font("Aharoni 굵게", Font.BOLD, 50));
        p_startTitle.add(startTitleJLabel);

        // 게임런처 인트로 텍스트 마진_TOP 주기
        p_startTitle.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));
        cp.add(p_startTitle, BorderLayout.CENTER);


        /*
         * TO DO 3. 게임런처 Start 버튼
         */
        JPanel p_startButton = new JPanel(new FlowLayout());
        JButton startButton = new StartButton("Start", this);

        // 버튼 색상 설정
        startButton.setBackground(new Color(189,215,238));
        startButton.setOpaque(true);
        startButton.setBorderPainted(false);
        // 버튼 폰트 설정
        startButton.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
        // 버튼 텍스트 크기 설정
        startButton.setSize(50, 50);
        // 버튼 크기 설정
        startButton.setPreferredSize(new Dimension(200, 70));

        // 패널에 버튼 추가
        p_startButton.add(startButton);


        // 게임런처 인트로 Start 버튼 마진_Top 주기
        p_startButton.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
        cp.add(p_startButton, BorderLayout.SOUTH);


        setTitle("소프링의 게임랜드 GUI");
        setSize(750,500);
        setVisible(true);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
	}




    // StartGUI를 종료 메소드
    public void startGUI_unVisible(){
        this.setVisible(false);
    }



    // 이미지를 JPanel로 만듦.
    // class ImagePanel extends JPanel{

    //     // 이건 이클립스 경고 메세지를 없애기 위한 버전
    //     private static final long serialVersionUID = 1L;


    //     // 다시 그리는 paintComponent를 오버라이드
	// 	@Override
	// 	public void paintComponent(Graphics g) {
	// 		super.paintComponent(g);
	// 		g.drawImage(startIntroImg, 10, 10, 100, 100, this);
	// 	}
    // }
    
}