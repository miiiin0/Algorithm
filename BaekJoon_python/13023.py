# ABCDE
# DFS 이용

def dfs(v, depth):
    # 방문 노드 True로 변경
    visited[v] = True

    global finished

    if depth == 4:
        finished = True
        return

    # 재귀 함수 선언
    for node in matrix[v]:
        if not visited[node]:
            dfs(node, depth+1)
            # dfs에서 나왔다는건 제일 안쪽까지 탐색하고
            # 나오는 것이기 때문에 방문을 다시 False로 바꿔줌
    visited[v] = False


# 입력받기
N, M = map(int, input().split())

# 변수 초기화
matrix = [[] for _ in range(N)]
visited = [False] * N
finished = False

# matrix에 관계 입력
for i in range(M):
    a, b = map(int, input().split())
    matrix[a].append(b)
    matrix[b].append(a)

# 노드를 순서대로 방문하며 dfs 수행
for i in range(N):
    dfs(i, 0)

    if finished:
        break

# 결과값 출력
if finished:
    print(1)
else:
    print(0)

