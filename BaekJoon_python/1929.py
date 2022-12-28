import math

# 소수인지 아닌지 판단하는 함수
def isPrime(num):
    # 1은 소수가 아니므로 건너뛴다
    if num == 1:
        return False

    else:
        # ('비교하려는 수 = num'의 제곱근을 int로 바꾼것) + 1 만큼으로 범위를 지정해준다
        for i in range(2, int(math.sqrt(num) + 1)):
            # 나누어지면 소수가 아니다
            if num % i == 0:
                return False
        return True

# 입력받기
M, N = map(int, input().split())

# M이상 N이하의 소수를 구하는 것이므로 N+1로 설정한다
for i in range(M, N + 1):
    # True이면 소수라는 뜻이므로 출력한다
    if isPrime(i):
        print(i)




