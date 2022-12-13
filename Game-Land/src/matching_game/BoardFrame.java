package matching_game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BoardFrame extends JFrame {
	
	private GameTimer timer; // 타이머 객체 (시간을 관리하고 포멧을 리턴)
	private MatchingGameStarter starter;
	private PieceButton[][] board;
	private int row, col; // 가로세로게임 행, 열 갯수 (추가 가능 확장가)
	private int first_row, first_col; // 첫번째로 고른 row, col  만약 아무것도 선택되지 않았다면 -1 의 값을 가짐 
	private int opened_piece; // 현재까지 열린 칸의 갯수 (16이면 게임 종료)
	
	public BoardFrame(int best_time, MatchingGameStarter m) {
		starter = m;
		Container cp = getContentPane();
		BorderLayout layout = new BorderLayout();
		cp.setLayout(layout);
		
		JPanel top = new JPanel(new GridLayout(1,2));
		// 타이틀 설정 
		JLabel label = new JLabel("짝 맞추기 게임");
		JPanel title = new JPanel(new FlowLayout(FlowLayout.LEFT));	// Panel
		title.add(label);
		
		// 타이머 설정 (default : 00:00s)
		JLabel current_time = new JLabel();
		timer = new GameTimer(best_time, current_time);
		JLabel best_timer = new JLabel("Best Time " + timer.getBestTime());
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
		JButton exit_button = new ExitButton("게임 종료", this);
		JPanel exit_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		exit_panel.add(exit_button);
		
		// 컨테이너에 원소추가 
		cp.add(top, BorderLayout.NORTH);
		cp.add(board_panel, BorderLayout.CENTER);
		cp.add(exit_panel, BorderLayout.SOUTH);
		
		// 기본 설정
		setTitle("Matching Game");
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	/** 
	 * 시간 체크 시작 및 1초(1000ms)마다 업데이
	 */
	public void timerStart() {
		timer.start();
	}
	private void endGame() {
		timer.stop_timer();
	}
	
	public void firstColor(int r, int c) {
		first_row = r;
		first_col = c;
	}
	public void compareColor(int ro, int co) {
		if(board[ro][co].color() == board[first_row][first_col].color()) {
			board[ro][co].setRevealed();
			board[first_row][first_col].setRevealed();
			opened_piece += 2;
			if(opened_piece >=16) {
				endGame();
			}
		}
		else {
			
			board[ro][co].hide();
			board[first_row][first_col].hide();
		}
	}
	
	/**
	 * Exit 버튼 클릭시 실행 
	 * @return 게임을 클리어 했을 시 시간 리턴 (long 타입),클리어 못했을 시 0 리
	 */
	public void exitGame() { 
		if (timer.getNumberTime() != 0)
			endGame();
		if(opened_piece >= 16) {
			if(timer.getNumberBestTime() < timer.getNumberTime() && timer.getNumberBestTime() != 0) {
				JOptionPane.showMessageDialog(null, "걸린 시간 - "+ timer.getTime());
				starter.setTime(timer.getNumberBestTime());
			}
			else { 
				JOptionPane.showMessageDialog(null, "최고기록 갱신!!\n걸린시간 - "+ timer.getTime());
				starter.setTime(timer.getNumberTime());
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Game Over");
			starter.setTime(timer.getNumberBestTime());
		}
	}
}
