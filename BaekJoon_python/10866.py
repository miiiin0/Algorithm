import sys

testCase = int(sys.stdin.readline())
deque = []
result = []

for i in range(testCase):
    line = sys.stdin.readline().split()

    # push_front X: 정수 X를 덱의 앞에 넣는다.
    if line[0] == 'push_front':
        deque.insert(0, line[1])

    # push_back X: 정수 X를 덱의 뒤에 넣는다.
    elif line[0] == 'push_back':
        deque.append(line[1])

    # pop_front
    # 덱의 가장 앞에 있는 수를 빼고 그 수를 출력 + 만약 덱에 들어있는 정수가 없는 경우에는 -1 출력
    elif line[0] == 'pop_front':
        if len(deque) == 0:
            result.append(-1)
        else:
            result.append(deque.pop(0))

    # pop_back
    # 덱의 가장 뒤에 있는 수를 빼고 그 수를 출력 + 만약 덱에 들어있는 정수가 없는 경우에는 -1 출력
    elif line[0] == 'pop_back':
        if len(deque) == 0:
            result.append(-1)
        else:
            result.append(deque.pop())

    # size: 덱에 들어있는 정수의 개수를 출력
    elif line[0] == 'size':
        result.append(len(deque))

    # empty: 덱이 비어있으면 1 아니면 0을 출력
    elif line[0] == 'empty':
        if len(deque) != 0:
            result.append(0)
        else:
            result.append(1)

    # front
    # 덱의 가장 앞에 있는 정수를 출력 + 만약 덱에 들어있는 정수가 없는 경우에는 -1 출력
    elif line[0] == 'front':
        if len(deque) == 0:
            result.append(-1)
        else:
            result.append(deque[0])

    # back
    # 덱의 가장 뒤에 있는 정수를 출력 + 만약 덱에 들어있는 정수가 없는 경우에는 -1 출력
    elif line[0] == 'back':
        if len(deque) == 0:
            result.append(-1)
        else:
            result.append(deque[-1])

# 결과 출력
for i in result:
    print(i)

