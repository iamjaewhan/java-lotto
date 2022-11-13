# 미션 - 로또



## 🚀 기능 요구 사항

로또 게임 기능을 구현해야 한다. 로또 게임은 아래와 같은 규칙으로 진행된다.

```
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
```

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.

- 로또 1장의 가격은 1,000원이다.

- 당첨 번호와 보너스 번호를 입력받는다.

- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.

- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.

  

### 입출력 요구 사항

#### 입력

- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.

```
14000
```

- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.

```
1,2,3,4,5,6
```

- 보너스 번호를 입력 받는다.

```
7
```

#### 출력

- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.

```
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]
```

- 당첨 내역을 출력한다.

```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```

- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)

```
총 수익률은 62.5%입니다.
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

```java
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```





## 🎯구현 기능 목록

### Class

#### Application

**메소드**

- lottoMachine() : LottoMachine 객체 반환
- person() : Person 객체 반환
- lottoController() -> LottoController 객체 반환



#### LottoController

- runLotto() -> 로또 프로그램 실행시킨다.
- setWinningLottoNumber() -> 당첨 로또 번호를 설정
- setWinningBonusNumber() -> 당첨 보너스 번호를 설정



#### Lotto 

- validate(List\<int\> numbers) -> void : 로또 번호 유효성 검사

- getLottoNumbers() -> List<int> numbers -> 해당 로또의 번호 반환



#### LottoMachine class

- generateLottoNumber() -> List<int> : 로또 번호를 생성한다.
- getNumOfLottos(int money) -> int : 투입한 금액에 알맞는 로또 개수를 반환한다.
- getNewLottos(int money) -> List<Lotto> : 투입한 금액에 알맞는 개수의 로또 리스트를 반환한다.



#### Person class

- getLottoResult() -> LottoPrize : 로또의 결과에 해당하는 LottoPrize 를 반환한다
- countCorrectLottoNumber() -> int count : 맞은 로또 번호의 개수를 반환한다.
- countCorrectBonusNumber() -> int count : 맞은 보너스 번호의 개수를 반환한다.

- aggregateResults() -> void : 로또의 결과들을 집계하여 수익률을 계산



#### LottoInputFilter

- readPurchaseAmount() -> int
- readLottoNumber() -> List<int>
- readBonusNumber() -> int  





### Enum

#### ErrorEessage Enum

**Types**

- NOT_POSITIVE_INTEGER
- INVALID_RANGE_NUMBER
- DUPLICATED_NUMBER
- INVALID_SIZE
- INVALID_FORMAT
- NON_NUMERIC

**메소드**
- getMessage() -> String : 각 에러에 맞는 에러 메세지 반환



#### LottoPrize Enum

**Types**

- 1ST_PRIZE
- 2ND_PRIZE
- 3RD_PRIZE
- 4TH_PRIZE
- 5TH_PRIZE
- NO_PRIZE

**메소드**

- getPrizeinfo() -> String : 당첨 개수 정보와 상금 정보 문자열 반환

- getPrizeMoney() -> int : 당첨금 금액 반환

- getPrize(int correctLottoNumberCount, int correctBonusNumberCount) -> LottoPrize





#### LottoSettings enum

**Types**

- SIZE

- START_FROM

- END_TO

**메소드**

- getValue() -> int
