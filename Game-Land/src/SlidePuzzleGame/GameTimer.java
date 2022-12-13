package SlidePuzzleGame;

public class GameTimer {

    public int this_time;
    public int best_time;

    /**
     * Timer 생성자 : 최소시간을 기록해 둔다.
     * @param bt : 메인페이지에서 받아올 최소 시간
     */
    public GameTimer(int bt) {
        best_time = bt;
    }

    public String getTime() {
        return timerFormat(this_time);
    }

   /*public int getNumberTime() {
        return this_time;
    }*/

    /**
     * @return : 현재시간을 1초 증가시킨다.
     */
    public void increaseTime() {
        this_time++;
    }

    /**
     *
     * @return 최고 기록 띄우기
     */
    public String getBestTime() {
        return timerFormat(best_time);
    }


    public String timerFormat(int t) {
        int min=0, sec =0;
        if(t >= 60)
            min = t/60;
        sec = t % 60;

        return ((min < 10) ? "0" + min : min) + ":" + ((sec < 10) ? "0" + sec : sec);
    }

    /**
     *
     * @return best_time, this_time 비교 후 최소 시간 리턴
     */
    public int bestTime() {
        best_time = Math.min(best_time, this_time);
        return best_time;
    }
}
