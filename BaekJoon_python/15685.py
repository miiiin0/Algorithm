#드래곤커브

import sys

input = sys.stdin.readline
n = int(input())

# 동북서남
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

# 드래곤 커브들이 모일 배열 (1이면 드래곤 커브의 일부)
# x, y가 0부터 100까지 이므로 좌표를 101까지 설정
arr = [[0] * 101 for _ in range(101)]

for _ in range(n):
    # x, y : 드래곤 커브 시작점, d : 시작 방향, g : 세대
    x, y, d, g = map(int, input().split())
    arr[x][y] = 1

    # 시작 방향 저장
    move = [d]

    # 이동방향을 move에 저장
    # g 세대 만큼 반복
    for _ in range(g):
        tmp = []
        for i in range(len(move)):
            # 다음방향 = (이전방향+1)%4
            tmp.append((move[-i - 1] + 1) % 4)
        move.extend(tmp)

    # move에 저장한 이동방향을 하나씩 불러와서 이동
    for i in move:
        nx = x + dx[i]
        ny = y + dy[i]
        arr[nx][ny] = 1
        # x, y 좌표 업데이트
        x, y = nx, ny

# 정사각형 개수 구하기
ans = 0
for i in range(100):
    for j in range(100):
        if arr[i][j]:
            # 인접한 세변도 확인
            if arr[i+1][j] and arr[i][j+1] and arr[i+1][j+1]:
                ans += 1
print(ans)
