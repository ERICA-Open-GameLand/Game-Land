package gui.userInfo;

public class UserInfo {
    

    // 필드변수 정의
    private String userName;
    private String userAge;
    

    
    public int gameCoins; // 게임런처 코인변수
    /*
     *  public으로 해두고, 바로 값을 가져올 수 있도록
     *  설정 해둠.
     */
    public int blackjeckChips;

    // 초 단위로 저장되어 있음.
    public int slidePuzzleTime;
    public int sudokuTime;
    public int matchingGameTime;
    
    // 생성 메소드
    public UserInfo(String name, String age){
        userName = name;
        userAge = age;


        gameCoins = 10; // 게임런처 초기 코인 10개
        /*
            유저 게임런처 처음 실행 시
            게임 정보 Default 값
         */
        blackjeckChips = 0;
        slidePuzzleTime = 0;
        sudokuTime = 0;
        matchingGameTime = 0;
    }



    /*
     *   유저 기본 정보 가져오기 메소드
     */
    // 유저 이름 가져오기 메소드
    public String getUserName(){
        return userName;
    }

    // 유저 나이 가져오기 메소드
    public String getUserAge(){
        return userAge;
    }








    /*
     * UserInfo의 전역변수를 String으로 받는 메소드
     * GUI에 Text로 나타내기 위해서 전역변수 타입 변환 메소드
     */
    // 유저의 게임런처 코인 갯수 String으로 가져오기
    public String getGameLauncherCoin(){

        // Int to String
        String coinsText = Integer.toString(gameCoins);
        return coinsText;

    }

    // 유저의 블랙잭 칩 갯수 String으로 가져오기 메소드
    public String getBlackjeckChips(){

        // Text 로 띄우기 - Int to String
        String chipsText = Integer.toString(blackjeckChips);
        return chipsText;

    }

    // 슬라이드 퍼즐 게임 - 분 & 초 시간 가져오기 메소드
    public String[] getSlidePuzzleGameTime(){
        int minute = slidePuzzleTime / 60;
        int second = slidePuzzleTime % 60;
        String minute_str = Integer.toString(minute);
        String second_str = Integer.toString(second);

        String gameTime[] = new String[2];
        gameTime[0] = minute_str;
        gameTime[1] = second_str;

        /*
         *  Return Idx
         *  Idx = 0 : gameTime_minute
         *  Idx = 1 : gameTime_second
        */
        return gameTime;
    }

    // 스도쿠 - 분 & 초 시간 가져오기 메소드
    public String[] getSudokuTime(){
        int minute = sudokuTime / 60;
        int second = sudokuTime % 60;
        String minute_str = Integer.toString(minute);
        String second_str = Integer.toString(second);

        String gameTime[] = new String[2];
        gameTime[0] = minute_str;
        gameTime[1] = second_str;

        /*
         *  Return Idx
         *  Idx = 0 : gameTime_minute
         *  Idx = 1 : gameTime_second
        */
        return gameTime;
    }

    // 짝 맞추기 게임 - 분 & 시간 가져오기 메소드
    public String[] getMatchingGameTime(){
        int minute = matchingGameTime / 60;
        int second = matchingGameTime % 60;
        String minute_str = Integer.toString(minute);
        String second_str = Integer.toString(second);

        String gameTime[] = new String[2];
        gameTime[0] = minute_str;
        gameTime[1] = second_str;

        /*
         *  Return Idx
         *  Idx = 0 : gameTime_minute
         *  Idx = 1 : gameTime_second
        */
        return gameTime;
    }

}   

