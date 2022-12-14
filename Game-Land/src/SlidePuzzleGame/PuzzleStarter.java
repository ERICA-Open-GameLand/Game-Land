package SlidePuzzleGame;

import gui.gameLauncher.GameLauncherGUI;
import gui.userInfo.UserInfo;

public class PuzzleStarter {

    private UserInfo userInfo;
    private GameLauncherGUI launcherGUI;
    public void slidePuzzleGameStart(UserInfo ui, GameLauncherGUI gl) {
        userInfo = ui;
        launcherGUI = gl;
        new PuzzleFrame(userInfo, launcherGUI, new SlidePuzzleBoard(), userInfo.slidePuzzleTime);
    }
}
