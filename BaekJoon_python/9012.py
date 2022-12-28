import sys

testCase = int(sys.stdin.readline())

for i in range(testCase): # 6번 반복하는지 3번 반복하는지
    line = sys.stdin.readline()
    count = 0

    for n in line: #한글자씩 읽기
        if n == '(':
            count += 1
        elif n == ')':
            count -= 1
        if count < 0:
            print("NO")
            break

    if count > 0:
        print("NO")
    elif count == 0:
        print("YES")
