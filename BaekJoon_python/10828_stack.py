#10828번 스택
import sys

input = int(sys.stdin.readline())
stack = []

for i in range(input):
    line = sys.stdin.readline().split()
    # input변수에서 엔터 기준으로 한줄을 읽어서
    # line라는 변수에 띄어쓰기를 기준으로 리스트 형태로 나눠서 저장
    # 즉, line는 리스트 변수

    # push일때
    # push X : 정수 X를 스택에 넣는 연산
    if line[0] == 'push':
        stack.append(line[1]) # append() : 리스트의 맨 마지막에 요소 추가

    # pop일때
    # 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력
    # 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력
    elif line[0] == 'pop':
        if len(stack) == 0:
            print(-1)
        else:
            print(stack.pop()) # pop() : 리스트의 맨 마지막 요소를 돌려주고 그 요소는 삭제

    # size일때
    # 스택에 들어있는 정수의 개수를 출력
    elif line[0] == 'size':
        print(len(stack))

    # empty일때
    # 스택이 비어있으면 1, 아니면 0을 출력
    elif line[0] == 'empty':
        if len(stack) == 0:
            print(1)
        else:
            print(0)

    # top일때
    # 스택의 가장 위에 있는 정수를 출력
    # 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력
    elif line[0] == 'top':
        if len(stack) == 0:
            print(-1)
        else:
            print(stack[-1]) # 리스트의 맨 마지막 요소를 제거하지 않고 가져오기만 할 때에는 [-1] 사용

