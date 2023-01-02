import sys

# 필요한 변수 선언
result = [] # 결과값 +, - 기록하는 리스트
stack = []
count = 1 # stack에 넣었던 최대 숫자 저장
possible = True # 가능한 수열인지 파악

testCase = int(sys.stdin.readline())

for i in range(testCase): # testCase만큼 반복
    line = int(sys.stdin.readline()) # 한줄씩 읽음

    if line >= count:
        while line >= count:
            stack.append(count)
            result.append("+")
            count += 1

        stack.pop()
        result.append("-")

    else:
        if line == stack[-1]:
            stack.pop()
            result.append("-")
        else:
            possible = False
            break

if possible == False:
    print("NO")
else:
    for i in result:
        print(i)