package matching_game;

public class Timer {

	private long first_time;
	private long best_time;
	
	/**
	 * Timer 생성자 : 최소시간을 기록해 둔다.
	 * @param bt : 메인페이지에서 받아올 최소 시간 
	 */
	public Timer(long bt) {
		best_time = bt;
	}
	
	// 시작시간 설정 
	public void setStringTimer() {
		first_time = System.currentTimeMillis()/1000;
	}
	
	/**
	 * @return : 처음 게임 시작 시간과 현재시간을 빼서 시간을 기록한다.
	 */
	public String getTime() {
		long now_time = first_time == 0 ? 0 : (System.currentTimeMillis()/1000) - first_time;
		
		return timerFormat(now_time);
		
	}
	
	/**
	 * @return : 현재까지중 게임의 최고 기록을 띄워준다. (변동 X)
	 */
	public String getBestTime() {
		return timerFormat(best_time);
	}
	
	
	/**
	 * 분 : 초 단위만 처리한다.  
	 * @param l : 인수로 전달받은 Long 타입 시간  
	 * @return 만약 분이나 초가 한 자리 숫자라면 앞에 '0'을 써준다 -> 02:04
	 */
	private String timerFormat(long l) {
		long min=0, sec=0;
		if(l >=60 ) {
			min = l/60;
		}
		sec = l % 60;
		
		return ((min < 10) ? "0"+min : min) + ":" + ((sec < 10) ? "0"+sec : sec);
	}
	
	// 최소 시간을 리턴한다.
	public long bestTime() {
		return best_time;
	}
	
	
}
