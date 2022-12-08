package SlidePuzzleGame;

public class PuzzleStarter {

    private int best_time;

    public static void main(String[] args) {
        new PuzzleFrame(new SlidePuzzleBoard(), 0);
    }
    /*public void bestTime(int t) {
        best_time = t;
        startGame();
    }

    public void startGame() {
        new PuzzleFrame(new SlidePuzzleBoard(),best_time);
    }*/

}
