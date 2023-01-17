# LG Uplus x AWS Refactoring Kata
리팩토링을 연습할 수 있는 예제 입니다.

# Welcome to Gilded Rose!

안녕하세요, **Gilded Rose**에 오신 것을 환영합니다. 이곳은 도시의 주요 지역에있는 작은 잡화점입니다. 잡화점엔 다양한 카테고리의 아이템이 있습니다.

저희 잡화점이 가진 아이템은 판매 기한이 가까워 질수록 품질이 저하됩니다. 그리고 이러한 아이템의 정보를 업데이트하는 시스템이 있습니다.

앞으로 더 많은 아이템들이 입고될 예정입니다.

당신이 할 일은 이 시스템을 리팩토링하고, 새로운 아이템을 추가하는 것입니다.

## 시스템 소개
먼저 시스템을 소개합니다.

- 모든 아이템은 `SellIn` 값을 가지며, 이는 아이템을 판매해야하는 (남은) 기간을 나태냅니다.
- 모든 아이템은 `Quality` 값을 가지며, 이것은 아이템의 가치를 나타냅니다.
- 하루가 지날때마다, 시스템은 두 값(`SellIn`, `Quality`)을 *1* 씩 감소시킵니다.

간단하죠? 흥미로운 부분은 지금부터입니다.

- 판매하는 나머지 일수(`SellIn`)가 0보다 작으면, `Quality` 값은 **2배**로 떨어집니다.
- `Quality` 값은 결코 음수가 되지는 않습니다.
- "**Aged Brie**"은(는) 시간이 지날수록 `Quality` 값이 1씩 올라갑니다.
- `Quality` 값은 50를 초과 할 수 없습니다.
- "**Sulfuras**"는 전설의 아이템이므로, 반드시 판매될 필요도 없고(sellIn이 변하지 않음) Quality 값도 떨어지지 않습니다.
- "**Backstage passes**"는 "**Aged Brie**"와 유사하게 `SellIn` 값에 가까워 질수록 `Quality` 값이 상승하고, **10일 부터는** 매일 *2* 씩 증가하다, **5일 부터는** 매일 *3* 씩 증가하지만, 콘서트 종료 후에는 *0*으로 떨어집니다.

## 새롭게 추가될 아이템

최근 "**Conjured**" 아이템 공급 업체와 계약했습니다. 따라서 시스템의 업데이트가 필요합니다.

- "**Conjured**" 아이템은 일반 아이템의 2배의 속도로 품질(`Quality`)이 저하됩니다.

## 추신

모든 것이 제대로 작동하는 한에서는 `UpdateQuality()` 메서드를 변경하거나 새로운 코드의 추가를 자유롭게 할 수 있습니다.

다시 한 번 확인하자면, 아이템의 `Quality`는 50 이상으로 증가할 수는 없습니다. 하지만 `Sulfuras`는 전설의 아이템이기 때문에 `Quality` 값은 80이며, 값이 바뀌지 않습니다.

리팩토링을 하며, 코드를 변경한 후 기존 테스트케이스가 모두 통과하는지 꼭 확인하며 진행하세요!
