package gui.userInfo;

public class GameLauncherGUI {
	
	// GameLauncherGUI 클래스의 GUI 업데이트 메소드
	// gui 업데이트
	    public void gui_update(){
	        coinText_JLabel.setText("코인 : " + userInfo.getGameLauncherCoin() + "개");
	    }
}
