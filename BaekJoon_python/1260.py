# DFS와 BFS
import sys

# Depth-First Search (깊이 우선 탐색)
# 자기 자신을 호출하는 순환 알고리즘
def dfs(v):
    # 시작 정점 방문 여부를 true로 변경
    visited[v] = True

    print(v, end=' ')

    # 재귀 함수 선언
    for node in range(1, N+1):
        if visited[node] is False and matrix[v][node] == 1:
            dfs(node)


# Breadth-First Search (너비 우선 탐색)
# 루트노트에서 시작해서 인접한 노드 먼저 탐색
# FIFO 큐사용
def bfs(v):
    # 큐에 start node를 넣음
    queue = [v]
    visited[v] = True

    while queue:
        # 큐에서 맨 앞의 노드를 dequeue (0번 인덱스 pop)
        pop_v = queue.pop(0)
        print(pop_v, end=' ')
        for node in range(1, N+1):
            if visited[node] is False and matrix[pop_v][node] == 1:
                queue.append(node)
                visited[node] = True


# 입력받기
N, M, V = map(int, sys.stdin.readline().strip().split())
matrix = [[0]*(N+1) for i in range(N+1)]
#print(list)

for i in range(M):
    n1, n2 = map(int, sys.stdin.readline().strip().split())
    matrix[n1][n2] = matrix[n2][n1] = 1

# 방문 여부 확인해야 함
visited = [False for _ in range(N + 1)]
dfs(V)
print()
# 방문 여부 다시 초기화
visited = [False for _ in range(N + 1)]
bfs(V)
