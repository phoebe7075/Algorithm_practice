# Algorithm_practice
Algorithm practice repo


## 이분 탐색(이진 탐색)
- 정렬되어 있는 어느 배열 구조체에서, 범위를 두고 내가 원하는 값 x를 찾기 위해 사용하는 알고리즘.
- 시작값을 처음, 끝 값을 마지막 인덱스로 두고 그 중간의 값을 구한 뒤 그 값이 x와 큰지, 작은지를 비교해 처음과 끝 값을 중간값 앞뒤로 이동시켜 찾아야 하는 범위를 **절반으로** 줄여서 찾으므로, 아무리 큰 인덱스 값에서 찾아야 해도(만약 16777216	 = 2^24의 경우) 최대 24번 안에 찾을 수 있게 된다. 
- 즉 탐색에 걸리는 비용을 극단적으로 줄여준다. 그래서 브루트 포스 알고리즘 처럼 보이는 알고리즘에 대해, 그 자료구조가 정렬이 되며 비교 가능한 상황에서, 탐색에 들어가는 비용이 커서 시간복잡도가 크게 소모될 것으로 생각될 때 사용하면 좋다.
- 혹은 탐색을 매우 많이 해야하는 환경에서 효과가 좋다.

### 매개변수 탐색
- 위와 같은 이진탐색의 특성을 가지고, x에 대해 비교하는 것이 아닌, x를 특정한 상황으로 두고 내가 찾은 중간 값이 이 상황에 부합하는지 or 그것보다 부족한지 or 그것보다 큰지로 나누어 이진탐색을 거는 방식이다.
- 여기서 주의점은, 이분탐색과는 조금 이질적인 범위값 설정에 있다. 이진탐색의 방식으로 할 수도 있고, 아예 내가 찾아야 하는 특정 값의 범위를 두는 경우도 있다.
- 예를 들어 나무가 5개 있고, 이 나무의 크기는 1~20,000,000m까지 자란다, 나는 7m만큼만 가져가고 싶은데, 나무를 몇m만큼 잘라야 7m에 근접하거나 많게 남길 수 있을까? 와 같은 상황에 적합하다.
    - 그렇다면 이와 같은 경우에 start 값은 0이 될 것이고, (무조건 되는 값) end 값은 20,000,000 이 될 것이다.(무조건 안되는 값)
- 매개변수 탐색에서 범위값 설정은 매우매우 중요. start 값은 무조건 되는 값을, end값은 도달해서는 안되는, 혹은 내가 구해야 하는 값에서 최대값으로 두어야 함.
- 그리고 내가 구한 중간값이 찾아야 하는 상황에 부합하는지를 체크하여, 그 숫자를 줄여야 하는지, 늘려야 하는지를 판단할 수 있어야 함.
- 매개변수 탐색에서 정답이 잘 안나오는 경우는 문제의 조건이 최대값인지, 최소값인지에 있다. 그리고 범위 설정을 할때 루프값 종료조건에서도 문제가 있을 수 있음. `start <= end` 의 경우 종료가 될 때는 start값이 end값보다 커지기에, end값이 구해야 하는 값이 된다. 
- 즉 범위 설정을 잘 해야하고 종료 후 어떤 값을 출력하는지에 따라 답이 갈린다.