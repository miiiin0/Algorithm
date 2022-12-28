import sys

while True:
    line = sys.stdin.readline().rstrip("\n")
    low, up, num, space = 0, 0, 0, 0

    # 다음줄이 없으면 끝내기
    if not line:
        break

    # 소문자, 대문자, 숫자, 공백 구하기
    for s in line:
        if s.islower():
            low += 1
        elif s.isupper():
            up += 1
        elif s.isdigit():
            num += 1
        elif s.isspace():
            space += 1

    print(low, up, num, space)
