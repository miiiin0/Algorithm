# 퇴사 문제

# 입력받기
N = int(input())
t = []
p = []
for i in range(N):
    a, b = map(int, input().split())
    t.append(a)
    p.append(b)

# 1차원 배열 N+1개 요소를 모두 0으로 초기화
# (i번째에 i+1번째와 비교하니까 1 크게 선언)
d = [0] * (N + 1)

# range(start, end, step)
# 즉, i는 N-1부터 0까지 -1씩 하면서 for문을 도는 것이다
for i in range(N - 1, -1, -1):
    # '현재 일자 + 상담을 완료하는데 걸리는 기간 t'이 N을 넘어가면 일을 맡을 수 없다
    if i + t[i] > N:
        # 따라서 아래처럼 max로 비교할 필요없다
        d[i] = d[i + 1]
    else:
        # 'i번째 날의 수익'은 다음날인 'i+1번째 날 수익'과 'i번째 날 수익' + 'T[i]만큼 지난 후 수익' 중
        # 큰 값을 골라야 한다.
        d[i] = max(d[i + 1], p[i] + d[i + t[i]])

print(d[0])

