# 동물원

# 입력받기
N = int(input())
dp = [1]*(N+1)
dp[1] = 3
if N == 1:
    print(dp[1])
else:
    for i in range(2, N+1):
        dp[i] = dp[i-2] + (dp[i-1]*2)
        dp[i] %= 9901
    print(dp[N])
