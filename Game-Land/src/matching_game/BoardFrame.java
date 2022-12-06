package matching_game;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class BoardFrame extends JFrame {
	
	private Timer timer;
	private PieceButton[][] board;
	private int row, col;
	
	public BoardFrame(long best_time) {
		Container cp = getContentPane();
		BorderLayout layout = new BorderLayout();
		cp.setLayout(layout);
		
		JPanel top = new JPanel(new GridLayout(1,2));
		// 타이틀 설정 
		JLabel label = new JLabel("짝 맞추기 게임");
		JPanel title = new JPanel(new FlowLayout(FlowLayout.LEFT));	// Panel
		title.add(label);
		
		// 타이머 설정 (default : 00:00s)
		timer = new Timer(best_time);
		JLabel current_time = new JLabel("Current " + (timer.getTime())+"s");
		JLabel best_timer = new JLabel("Best Time " + timer.getBestTime()+"s");
		JPanel timer_panel = new JPanel(new GridLayout());	// Panel
		Box timer_box = Box.createVerticalBox();
		current_time.setAlignmentX(RIGHT_ALIGNMENT);
		best_timer.setAlignmentX(RIGHT_ALIGNMENT);
		timer_box.add(current_time);
		timer_box.add(best_timer);
		timer_panel.add(timer_box);
		
		top.add(title);
		top.add(timer_panel);
		
		// 게임 보드 설정 
		board = new GameBoard(this).square();
		JPanel board_panel = new JPanel(new GridLayout(4,4));
		row = 4; 
		col = 4;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				board_panel.add(board[i][j]);
			}
		}
		
		// 게임 종료버튼 
		JButton exit_button = new ExitButton("게임 종료");
		JPanel exit_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		exit_panel.add(exit_button);
		
		// 컨테이너에 원소추가 
		cp.add(top, BorderLayout.NORTH);
		cp.add(board_panel, BorderLayout.CENTER);
		cp.add(exit_panel, BorderLayout.SOUTH);
		
		update();
		
		// 기본 설정
		setTitle("Matching Game");
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void update() {
		this.repaint();
	}
}
