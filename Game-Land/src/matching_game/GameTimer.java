package matching_game;

import javax.swing.JLabel;

public class GameTimer extends Thread{

	private int this_time;
	private int best_time;
	JLabel timer_label;
	boolean run;
	
	/**
	 * Timer 생성자 : 최소시간을 기록해 둔다.
	 * @param bt : 메인페이지에서 받아올 최소 시간 
	 */
	public GameTimer(int bt, JLabel tl) {
		best_time = bt;
		timer_label = tl;
		this_time = 0;
		run = true;
		
		timer_label.setText("Current 00:00s");
	}
	
	public void run() {
		while (run) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this_time++;
			timer_label.setText("Current "+getTime());
		}
	}
	public void stop_timer() {
		run = false;
	}

	public String getTime() { // 게임 시작 후 흐른시간 리턴 (문자)
		return timerFormat(this_time);
	}
	public int getNumberTime() { // 게임 시작 후 흐른시간 리턴 (숫자)
		return this_time;
	}
	
	/**
	 * @return : 현재까지중 게임의 최고 기록을 띄워준다. (변동 X)
	 */
	public String getBestTime() {
		return timerFormat(best_time);
	}
	public int getNumberBestTime() {
		return best_time;
	}
	
	
	/**
	 * 분 : 초 단위만 처리한다.  
	 * @param l : 인수로 전달받은 Long 타입 시간  
	 * @return 만약 분이나 초가 한 자리 숫자라면 앞에 '0'을 써준다 -> 02:04s
	 */
	private String timerFormat(int l) {
		int min=0, sec=0;
		if(l >=60 ) {
			min = l/60;
		}
		sec = l % 60;
		
		return ((min < 10) ? "0"+min : min) + ":" + ((sec < 10) ? "0"+sec : sec)+"s";
	}
	
	// 최소 시간을 리턴한다.
	public int bestTime() {
		return best_time;
	}
	
	
}
