# 011 - UI 코드와 데이터 처리 코드를 분리


### 작업) ***Handler에서 데이터 처리 코드를 분리하기

- PlanHandler.java, BoardHandler.java, LessonList.java
    - `PlanHandler,BoardHandler,LessonHandler`에서 데이터 처리 코드를 이 클래스로 옮긴다.
    - 데이터 배열을 리턴하는 toArray() 메서드를 정의
    - 데이터를 저장하는 add() 메서드를 정의
    - 기본 생성자와 배열의 초기 크기를 설정하는 생성자를 정의  
- PlanHandler.java, BoardHandler.java, LessonList.java
    - `PlanList, BoardList, LessonList` 클래스를 사용하여 데이터를 처리한다.

