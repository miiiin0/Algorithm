# 숨바꼭질
from collections import deque

def bfs():
    dequeList = deque() #덱 선언
    dequeList.append(N) # 수빈이의 위치를 덱에 추가

    while dequeList:
        num = dequeList.popleft() # 덱 가장 처음에 있는 수를 pop
        if num == K: # 동생이 있는 위치에 도착한 경우를 뜻함
            print(list[num])
            break
        for n in (num-1, num+1, num*2): # 수빈이가 움직일 수 있는 경우의 수 3가지
            if 0 <= n <= MAX and not list[n]:
                list[n] = list[num] + 1
                dequeList.append(n)

# 입력받기
N, K = map(int, input().split())
MAX = 100000
# list값 초기화
list = [0] * (MAX+1)

bfs()
