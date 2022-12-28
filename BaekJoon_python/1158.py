import sys

input = sys.stdin.readline().split()
CircularQueue = []
for i in range(int(input[0])): # 큐에 1~7까지 넣기 위한 for문
    CircularQueue.append(i + 1) # i가 0부터 시작이니까 +1해서 리스트에 append

num = int(input[1])
result = []
index = 0

while len(CircularQueue) != 0:
    index += num - 1 # 큐의 인덱스는 0부터 시작하니까 -1해줌

    if index >= len(CircularQueue): # 한바퀴 다 돌았을 때 현재 큐(리스트) 길이로 나눠줘서 처음으로 돌아가게 구현
        index = index % len(CircularQueue)

    result.append(CircularQueue.pop(index)) # 큐에서 pop해서 result에 append

print("<", ', '.join(str(i) for i in result)[:], ">", sep="") # 결과 출력
