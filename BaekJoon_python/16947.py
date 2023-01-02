# 서울 지하철 2호선
import sys
from collections import deque
sys.setrecursionlimit(10**9)

# 순환선 확인하기 -> dfs
def dfs(start, now, cnt):
    global cycle
    # 현재 역이 시작역으로 돌아왔고 방문한 역이 두곳 이상일 경우
    if start == now and cnt >= 2:
        cycle = True
        return

    # 현재 역 방문 여부 true로 변경
    visited[now] = True

    # 다음 방문할 역
    for next in matrix[now]:
        # 다음 방문할 역이 아직 방문하지 않은 역일때
        if visited[next] is False:
            dfs(start, next, cnt+1)
        # 다음 방문할 역이 이미 방문한 역이고 방문한 역이 두곳 이상일 경우
        elif start == next and cnt >= 2:
            cycle = True
            return
            # dfs(start, next, cnt) #그대로 다시 호출 (visited[now] True로 바꿨으니까 if문 들어감)

# 1.입력받기
input = sys.stdin.readline
n = int(input())

matrix = [[]*(n+1) for i in range(n+1)]
for i in range(n):
    n1, n2 = map(int, sys.stdin.readline().strip().split())
    matrix[n1].append(n2)
    matrix[n2].append(n1)

# 2.순환선 확인하기 -> dfs
cycleStation = [False] * (n+1)  # 순환역 표시하는 어레이
for i in range(n+1):
    # 방문 여부 확인해야 함
    visited = [False for _ in range(n + 1)]

    # dfs함수 호출하기 전에 cycle을 False로 초기화
    cycle = False
    # dfs함수 호출
    dfs(i, i, 0)
    # dfs함수 호출 후 cycle이 True이면 해당 정점(i)을 cycleStation[i] True로 변경
    if cycle is True:
        cycleStation[i] = True

q = deque()
dist = [-1] * (n+1) # 거리 표시하는 어레이


# 3.역과 순환선 사이의 거리 구하기 -> bfs
dequeList = deque()
dist = [-1] * (n+1) # 거리 표시하는 어레이

# 순환역에 속하는 역은 모두 거리가 0으로 초기화?한다
for i in range(n+1):
    if cycleStation[i] is True:
        dist[i] = 0
        dequeList.append(i)

# 덱이 끝날때까지 반복
while dequeList:
    # current는 현재 역
    current = dequeList.popleft()

    # n은 current의 다음 역이 될 수 있는 역들
    for n in matrix[current]:
        # 다음 역인 n이 순환선에 포함되지 않는 역이라면
        if dist[n] == -1:
            # 그 역과 이어진 다른 역들도 비교해야되니까 dequeList에 넣는다
            dequeList.append(n)
            dist[n] = dist[current] + 1


# 결과 출력
del dist[0] # 0번째꺼는 빼기
for i in dist:
    print(i, end=' ')
