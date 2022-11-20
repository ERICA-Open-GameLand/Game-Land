# 오픈소스 SW 기초 {게임 런처 Java Application 개발 프로젝트}
게임 런처 Java Application 개발 프로젝트
</br>
</br>
</br>

</br></br></br></br></br>
# 개발 스택
Java
</br>
</br></br></br>

# 프로젝트 설명
게임 런처 Java Application
</br>
</br></br></br>

# 프로젝트 구성원
팀장:김동욱 소프트웨어학부 2022011249</br>
팀원:노준아 소프트웨어학부 2022055978</br>
팀원:김준서 소프트웨어학부 2022050491</br>
팀원:박치준 소프트웨어학부 2022042997</br>
팀원:강제호 소프트웨어학부 2022061921</br>
</br></br></br>


# 프로젝트 진행 사항 Review - {2022/11/17}
</br>프로젝트 기획 확정 {방향성 & 구체화}
</br></br>
- 게임 런처 {GameLand}</br>
    - 게임 코인</br>
        - 초기 코인 : 10개</br>
        - 게임을 진행하면, 코인 하나 소모</br>
        - 게임을 이기거나, 성공적으로 완수하면 코인을 (임의로 정해둠)5개 제공</br>
        - 코인이 0개가 되었을 때 알림창 띄우고 게임런처 종료</br>
            - “코인을 다 사용하셨네요… 충전하고 이용해주세요.” 출력</br>
            - 확장 가능성 {결제 서비스 도입}</br>
    - 게임 점수기록</br>
        - 최고점수, 현재점수</br>
        - 최소 걸린시간, 현재 걸린시간</br>
    </br>
    - 게임 종류 {프설방}</br>
        - 블랙잭 (점수 & 점수가 음수이면, 코인획득 없이 메인화면 & 점수가 양수이면, 수 만큼 코인 추가)</br>
        - 슬라이드 퍼즐게임 (시간 & 중간 종료 시 코인획득 없이 메인화면 & 게임 클리어 시 코인 5개 추가)</br>
        - 스도쿠 (시간 & 중간 종료 시 코인획득 없이 메인화면 & 게임 클리어 시 코인 5개 추가)</br>
        - 짝 맞추기 게임 (시간 & 중간 종료 시 코인획득 없이 메인화면 & 게임 클리어 시 코인 5개 추가)</br>
    </br>
    </br>
    💡 핵심기능은 다음과 같으며,</br>
    게임 런처 Application에 대해서 구현을 완료하고, 시간적으로 여유가 남았을 때</br>
    추가 게임을 구현 후 게임 런처 Application에 추가 게임으로 확장하는 방식을 택했다.</br>
    </br>
    요약해서, 핵심기능인 게임 런처 Application을 구현하고, 추가 기능인 추가 게임을 구현한다.
    개발 프로젝트 설계는 별도로 추가회의를 통해 진행할 예정이다.
    </br></br>
    ## 핵심 기능에 대해서 구현 후 추가 구현 예정인 사항**
    </br>
    - 추가 Game {New Game}</br>
        - 틱택토</br>
        - 네모로직</br>
        - 테트리스</br>
        </br></br></br>

## 프로젝트 방향성
💡 프로젝트 방향성은 여러 개의 게임을 구현한 것을 토대로 유저의 선택대로 원하는 게임을 골라서 진행할 수 있는 게임런처 서비스
</br></br>
핵심 기능</br>
유저가 원하는 게임을 선택해서 게임을 진행하고, 게임 진행된 결과를 기록하고,</br>
게임 런처 서비스에서 통합적으로 게임을 이용할 수 있는 서비스이다.</br>
</br></br>
타겟 사용자</br>
여러 게임을 즐겨하며, 원하는 게임을 선택적으로 선택해서 게임을 즐겨하는 사람</br>


