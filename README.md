# kotlin-lotto-precourse

## 리팩토링 사항
- 입력 예외 사항을 더 추가했습니다.
- 상수화를 위해 노력하였습니다.
- 에러가 날때 종료하지 않고, 에러메세지출력 + 재입력 받았습니다.

3주차과제 할 때 부터 궁금했는데요. 1. 이렇게 종료하지 않고 재입력 받는게 맞는지, 2. 에러만들기 전에 print를 하는게 맞는지 의견이 궁금합니다!!

- 리뷰 반영하기
  - [x] print문으로 버림처리한다고 안내
  - [x] 보너스 번호가 중복일 경우
  - [x] 수익률 천단위 콤마
  - [x] enum클래스로 로또랭크와 당첨금 설정하기


- 스스로 생각하기에
  -[x] 로또 번호를 개수만큼 입력하지 않았을 경우 
 - [x] 파일들을 폴더로 구분하기
 - [x] 더욱 mvc 패턴처럼 해보기
 - [x] 상수화


```
- 지난 README.md


- [x] README.md 상세히 작성하기

## 기능목록

- [x] 구입금액 입력

- [x] 숫자 1~45 중에 6개 로또 뽑기
- [x] 로또 구입수만큼 로또 발행
- [x] 로또 1장 가격 상수로 선언

- [x] 당첨금 상수로 선언
- [x] 로또 등수 만들기

- [x] 6개숫자와 보너스번호 입력받기
- [x] 몇개 일치하는지 등수 구하기
- [x] 로또 번호 오름차순 정렬
  
- [x] 1000원으로 나누어 떨어지지 않은경우 살 수 있는 만큼만
- [x] 로또 번호 중복인 경우
- [x] 입력한 로또 번호가 범위에 맞지않을 경우
  
- [x] else 지양 (아예 금지는 아님)
- [x] Enum 클래스 적용
- [x] 한 메서드에서 한 가지 기능만 하기
- [x] 메서드를 15라인 이하로
---
  
- [x] 에러라면 에러메세시 출력후 다시 입력받기
- [x] 에러 유형을 명확하기 처리하기

- [x] 문자열이나 숫자를 하드코딩하지 말고 상수로 정의하기
- [x] 변수이름에 자료형 사용하지 않기

- [x] 테스트를 작성하는 이유에 대해 본인의 경험을 토대로 정리해본다.

---
## 나만의 문제 해석
### Lotto 클래스 해석
입력한 당첨번호인가? 랜덤으로 뽑는 번호인가?

number6개 제한으로보아 램덤으로 뽑은 로또라고 판단하였다. 따라서 로또 한장 한장을 Lotto라고 생각하고 구현하였다.

### LottoRound클래스
Lotto가 로또 한장이라면 `1`회를 관리하는 객체도 필요하다고 생각하고 LottoRound클래스를 만들었다.
이번 횟수에서 당첨 개수와 승률을 계산한다.

### LottoMaker
Lotto클래스 생성사에 number를 받고 있으므로 이미 랜덤6개가 생성되어있어야 한다.
따라서 만드는 함수를 LottoMaker라는 클래스에 따로 만들었다.

### 로또 등수
실제와 유사하면서 편하게 상수를 만들기 위해 등수를 만들었다.

1등 6개 일치
2등 5개 일치 + 보너스번호 일치
3등 5개 일치
4등 4개 일치
5등 3개 일치
others..

### 등수와 관련된 map자료구조들
등수 enum에 대응되는 당첨금과 일치개수를 map자료구조로 저장하였다.

## 테스트를 작성하는 이유
테스트는 구현할 때 보다는 유지보수를 할 때 빛을 발한다고 생각한다.

과거에 구현한 뒤 리팩토링해야 하는 일이 있었다. 
하나 둘 수정할 때 마다 기존에 했던 기능이 잘 돌아가는지 일일이 확인해야 했다. 
도중에 놓치는 케이스도 많아서 되돌아가는 일이 잦았다. 
오류가 나면 '아 이 경우도 있었네'하고 그때서야 코드를 추가했다.

이 때 테스트 코드가 있었다면 실행 한번으로 확인하고 지나갈 수 있었겠다고 느꼈다.


```
