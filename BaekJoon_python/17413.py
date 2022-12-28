import sys

# 커서 기준으로 Left와 Right로 나눈다
stackLeft = list(sys.stdin.readline().strip()) # 초기 문자열을 Left에 넣어준다
stackRight = []

# 입력할 명령어의 개수
case = int(sys.stdin.readline())

for i in range(case):
    line = sys.stdin.readline()

    # L일때
    # 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
    if line[0] == 'L':
        if len(stackLeft) == 0: # stackLeft가 0이면 커서가 문장의 맨 앞이라는 뜻
            continue
        else:
            stackRight.append(stackLeft.pop()) # Left 마지막에 있는 문자를 right로 옮겨줌으로써 커서를 옮긴다

    # D일때
    # 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
    elif line[0] == 'D':
        if len(stackRight) == 0: # stackRight가 0이면 커서가 문장의 맨 뒤라는 뜻
            continue
        else:
            stackLeft.append(stackRight.pop()) # Right 마지막에 있는 문자를 Left로 옮겨줌으로써 커서를 옮긴다

    # B일때
    # 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
    elif line[0] == 'B':
        if len(stackLeft) == 0: # stackLeft가 0이면 커서가 문장의 맨 앞이라는 뜻
            continue
        else:
            stackLeft.pop() # 문자 삭제

    # P일때
    # 문자를 커서 왼쪽에 추가함
    elif line[0] == 'P':
        stackLeft.append(line[2])  # 추가해야 되는 문자 추가


for i in (stackLeft + list(reversed(stackRight))):
    print(i, end='') # 한줄에 출력하기 위해 end='' 를 해줌
