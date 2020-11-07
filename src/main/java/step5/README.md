# 자동차 경주 게임 (리팩토)
## 리팩토링 요구사항
* 핵심 비지니스 로직을 가지는 객체를 domain 패키지, UI 관련 객체를 view 패키지에 구현.
* MVC 패턴 기반으로 리팩토링해 view 패키지의 객체가 domain패키지 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 구현한다.
* 테스트 가능한 부분과 테스트하기 힘든 부분을 분리해 테스트 가능한 부분에 대해서만 단위 테스트를 진행한다.




### step5 구조
```
src
 ├── Constant.java
 ├── Main.java
 ├── README.md
 ├── controller
 │     └── game
 │         ├── GameHistory.java
 │         ├── RacingGame.java
 │         └── RacingGameImpl.java
 ├── domain
 │     ├── dto
 │     │     └── RacingInfomation.java
 │     └── model
 │         └── car
 │             ├── Car.java
 │             └── RacingCar.java
 ├── strategy
 │     ├── InputStrategy.java
 │     ├── MoveStrategy.java
 │     ├── PrintMarkStrategy.java
 │     └── RacingInfoInputStrategy.java
 └── view
     ├── InputView.java
     ├── RacingResultView.java
     └── ResultView.java //ResultView 인터페이스 분리 메소드 play()로 로직 호
``` 
