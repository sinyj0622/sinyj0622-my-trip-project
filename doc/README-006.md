# 6 - 패키지로 클래스를 분류하기

### 작업1) 데이터 타입 클래스를 별도의 패키지로 분류하기

- 도메인 패키지 생성
    - `sinyj0622.mytrip.domain` 패키지 생성
- 도메인 클래스를 `domain` 패키지로 이동
    - `TravelPlan`, `Member`, `Board` 클래스를 `sinyj0622.mytrip.domain` 패키지로 옮긴다.
    - 다른 패키지에서 변수에 접근할 수 있도록 접근 제어를 `public` 으로 변경
- 핸들러 클래스에 import 문 추가
    - `TravelPlanHandler`, `MemberHandler`, `BoardHandler` 클래스를 변경한다.


### 작업2) 사용자 명령을 처리하는 클래스를 별도의 패키지로 분류하기.

- 핸들러 패키지 생성
    - `sinyj0622.mytrip.handler` 패키지 생성
- 핸들러 클래스를 `handler` 패키지로 이동
    - `TravelPlanHandler`, `MemberHandler`, `BoardHandler` 클래스를 `sinyj0622.mytrip.handler` 
              패키지로 옮긴다.
    - 다른 패키지에서 변수에 접근할 수 있도록 접근 제어를 `public` 으로 변경
- App.java 변경
    - 핸들러 클래스에 대해 import 문 추가
