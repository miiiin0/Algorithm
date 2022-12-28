import sys

input = list(sys.stdin.readline())

open = 0 # 열린 괄호 개수
result = 0 # 결과값

for i in range(len(input)):
    if input[i] == '(':
        open += 1
    elif input[i] == ')':
        open -= 1
        if input[i-1] == '(': # '(' 다음에 바로 ')'가 나온 경우
            result += open
        else:
            result += 1

print(result)
