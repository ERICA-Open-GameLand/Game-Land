package SlidePuzzleGame;

public class PuzzleStarter {

    private int best_time;

    public void slidePuzzleGameStart(int bt) {
        new PuzzleFrame(new SlidePuzzleBoard(), bt);
    }
    /*public void bestTime(int t) {
        best_time = t;
        startGame();
    }

    public void startGame() {
        new PuzzleFrame(new SlidePuzzleBoard(),best_time);
    }*/

}
