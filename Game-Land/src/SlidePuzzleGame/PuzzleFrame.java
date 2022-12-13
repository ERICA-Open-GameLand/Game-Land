package SlidePuzzleGame;

import gui.gameLauncher.GameLauncherGUI;
import gui.userInfo.UserInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PuzzleFrame extends JFrame {

    private SlidePuzzleBoard board;

    private PuzzleButton[][] button_board;

    private GameTimer timer;
    private JLabel time_record; // 시간 라벨
    public Timer sTimer; // 스윙 타이머 객체 (1초에 한 번 실행)
    private UserInfo userInfo;
    private GameLauncherGUI launcherGUI;

    public PuzzleFrame(UserInfo ui, GameLauncherGUI gl, SlidePuzzleBoard b, int best_time) {
        userInfo = ui;
        launcherGUI = gl;
        board = b;
        button_board = new PuzzleButton[4][4];
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        JPanel top = new JPanel(new BorderLayout());

        //퍼즐 이름
        JPanel game_name = new JPanel(new FlowLayout());
        JLabel name = new JLabel("슬라이드 퍼즐 게임");
        name.setFont(new Font("Hy엽서M", Font.BOLD, 30));
        game_name.add(name);

        //스타트 버튼
        JPanel start = new JPanel(new FlowLayout());
        ImageIcon start_img = new ImageIcon("src/SlidePuzzleGame/image/gamestart1.png");
        ImageIcon start_img2 = new ImageIcon("src/SlidePuzzleGame/image/gamestart2.png");
        start.add(new StartButton(board, this, start_img,start_img2));

        //시간 표시
        JPanel p_time = new JPanel((new FlowLayout(FlowLayout.LEFT,15,0)));
        timer = new GameTimer(best_time);
        time_record = new JLabel("시간: " + timer.getTime());
        JLabel best_time_record = new JLabel("최고 기록: " + timer.getBestTime() + "\n");
        time_record.setOpaque(true);
        time_record.setFont(new Font("Hy엽서M", Font.BOLD, 18));
        best_time_record.setOpaque(true);
        best_time_record.setFont(new Font("Hy엽서M", Font.BOLD, 18));
        Box timer_box = Box.createVerticalBox();
        time_record.setAlignmentX(RIGHT_ALIGNMENT);
        best_time_record.setAlignmentX(RIGHT_ALIGNMENT);
        timer_box.add(time_record);
        timer_box.add(best_time_record);
        p_time.add(timer_box);

        //게임이름, 시간, 시작버튼을 상단 BorderLayout 위치에 add
        top.add(game_name,BorderLayout.NORTH);
        top.add(start,BorderLayout.SOUTH);
        top.add(p_time,BorderLayout.EAST);

        //보드
        JPanel p2 = new JPanel(new GridLayout(4,4));
        for (int row = 0; row < 4; row ++)
            for (int col = 0; col < 4; col ++) {
                button_board[row][col] = new PuzzleButton(board, this);
                p2.add(button_board[row][col]);
            }

        //메인페이지로 이동 버튼
        JPanel exit = new JPanel(new FlowLayout(FlowLayout.LEFT,0,10));
        ImageIcon exit_img = new ImageIcon("./src/SlidePuzzleGame/image/gameexit1.png");
        ImageIcon exit_img2 = new ImageIcon("./src/SlidePuzzleGame/image/gameexit2.png");
        ExitButton exit_button = new ExitButton(exit_img,exit_img2);

        /**
         * exit_button을 눌렀을 때 이벤트 처리
         */
        exit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                if(board.gameOver()) {
                    if (userInfo.slidePuzzleTime != 0) {
                        userInfo.slidePuzzleTime = timer.bestTime();

                        launcherGUI.setVisible(true);
                        launcherGUI.gui_update();
                    }
                    else {
                        userInfo.slidePuzzleTime = timer.thisTime();
                        launcherGUI.setVisible(true);
                        launcherGUI.gui_update();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "게임이 끝나지 않았습니다. \n" +
                            " 게임은 기록되지 않습니다. ");
                    launcherGUI.setVisible(true);
                    launcherGUI.gui_update();
                }
            }
        });
        exit.add(exit_button);

        //컨테이너에 add
        cp.add(top,BorderLayout.NORTH);
        cp.add(p2,BorderLayout.CENTER);
        cp.add(exit,BorderLayout.SOUTH);
        cp.add(new JPanel(),BorderLayout.EAST);
        cp.add(new JPanel(),BorderLayout.WEST);

        update();

        setTitle("Slide Puzzle");
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void update() {
        for (int row = 0; row < 4; row ++)
            for (int col = 0; col < 4; col ++) {
                PuzzlePiece pp = board.getPuzzlePiece(row,col);
                if (pp != null) {
                    String n = Integer.toString(pp.face());
                    button_board[row][col].setText(n);
                }
                else
                    button_board[row][col].setText("");
            }
    }

    public void finish() {
        button_board[3][3].setText("DONE");
        //System.out.println(timer.this_time + "\n" + timer.best_time);

    }

    /**
     * 시간 체크 시작 및 1초(1000ms)마다 업데이트
     */
    public void timerStart() {
        sTimer = new Timer (1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.increaseTime();	// timer 객체 시간 1초 증가
                time_record.setText("시간: " + timer.getTime()); // 현재 초를 불러와서 timer label에 세
            }
        });
        sTimer.start();  // swing 타이머 시작
        sTimer.setRepeats(true); // 반복 : true
    }
    
}


