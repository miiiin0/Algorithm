# 숨바꼭질 4
from collections import deque

def bfs():
    dequeList = deque() #덱 선언
    dequeList.append(N) # 수빈이의 위치를 덱에 추가

    while dequeList:
        num = dequeList.popleft() # 덱 가장 처음에 있는 수를 pop
        if num == K: # 동생이 있는 위치에 도착한 경우를 뜻함
            print(list[num]) # 수빈이가 동생을 찾는 가장 빠른 시간 출력
            result = []

            # path에 저장된 경로를 거슬러 올라가면서 ans에 저장
            # N은 처음 수빈이가 있는 위치 즉, 뒤에서부터 처음 수빈이 위치까지 backtracking하는 느낌
            while num != N:
                result.append(num)
                num = path[num]
            result.append(N)
            result.reverse() # 역순으로 저장되어 있으므로 순서 바꿔주기
            print(' '.join(map(str, result))) # 이동 동선 출력
            break

        for n in (num-1, num+1, num*2): # 수빈이가 움직일 수 있는 경우의 수 3가지
            if 0 <= n <= MAX and not list[n]:
                list[n] = list[num] + 1 # 시간+1
                dequeList.append(n)
                # path에 현재 위치 저장
                path[n] = num

# 입력받기
N, K = map(int, input().split())
MAX = 100000

# list와 path값 초기화
list = [0] * (MAX+1)
path = [0] * (MAX+1)

# 함수 호출
bfs()

