import sys

testCase = int(sys.stdin.readline())
queue = []
result = []

for i in range(testCase):
    line = sys.stdin.readline().split()

    # push일때
    # push X : 정수 X를 큐에 넣는 연산
    if line[0] == 'push':
        queue.append(line[1])  # append() : 리스트의 맨 마지막에 요소 추가

    # pop일때
    # 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력 & 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
    if line[0] == 'pop':
        if len(queue) == 0:
            result.append(-1)
        else:
            result.append(queue.pop(0))  # pop(0): 리스트에서 주어진 위치(0)에 있는 요소를 삭제하고 그 요소를 반환

    # size일때
    # 큐에 들어있는 정수의 개수를 출력
    if line[0] == 'size':
        result.append(len(queue))

    # empty일때
    # 큐가 비어있으면 1, 아니면 0을 출력
    if line[0] == 'empty':
        if len(queue) == 0:
            result.append(1)
        else:
            result.append(0)

    # front일때
    # 큐의 가장 앞에 있는 정수를 출력 & 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
    if line[0] == 'front':
        if len(queue) == 0:
            result.append(-1)
        else:
            result.append(queue[0])

    # back일때
    # 큐의 가장 뒤에 있는 정수를 출력 & 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
    if line[0] == 'back':
        if len(queue) == 0:
            result.append(-1)
        else:
            result.append(queue[-1]) # 리스트의 맨 마지막 요소를 제거하지 않고 가져오기만 할 때에는 [-1] 사용

for i in result:
    print(i)
