# E: 1-15 / S: 1-28 / M: 1-19

# 입력받기
E, S, M = map(int, input().split())
year = 1

while True:
    if ((year-E) % 15 == 0) and ((year-S) % 28 == 0) and ((year-M) % 19 == 0):
        break
    year += 1

# 연도 출력
print(year)
