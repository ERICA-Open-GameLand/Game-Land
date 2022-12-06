package gui.userInfo;

public class UserInfo {
    

    // 필드변수 정의
    private String userName;
    private String userAge;

    /*
     *  public으로 해두고, 바로 값을 가져올 수 있도록
     *  설정 해둠.
     */
    public int blackjeckChips;
    public long slidePuzzleTime;
    public long sudokuTime;
    public long matchingGameTime;
    
    // 생성 메소드
    public UserInfo(String name, String age){
        userName = name;
        userAge = age;

        /*
            유저 게임런처 처음 실행 시
            게임 정보 Default 값
         */
        blackjeckChips = 0;
        slidePuzzleTime = 0;
        sudokuTime = 0;
        matchingGameTime = 0;
    }



    // 유저 이름 가져오기 메소드
    public String getUserName(){
        return userName;
    }

    // 유저 나이 가져오기 메소드
    public String getUserAge(){
        return userAge;
    }





    

    // 유저의 블랙잭 칩 갯수 가져오기 메소드 - String
    public String getBlackjeckChips(){

        // Text 로 띄우기 - Int to String
        String chipsText = Integer.toString(blackjeckChips);
        return chipsText;

    }

    /*
     * 게임 런처 오락 게임
     * 클리어 게임시간 가져오기 메소드
     */
    //  public String[] getSlidePuzzleGame(){

    //  }

}   

