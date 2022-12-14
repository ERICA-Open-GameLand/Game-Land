package sudoku;

import gui.gameLauncher.GameLauncherGUI;
import gui.userInfo.UserInfo;

public class SudokuPuzzle {

   public void sudokuStarter(UserInfo u, GameLauncherGUI g) {
       new SudokuWriter(new Sudoku(), u, g);
   }
}
