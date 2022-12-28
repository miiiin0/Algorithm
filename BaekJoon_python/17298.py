import sys

testCase = int(sys.stdin.readline())
input = sys.stdin.readline().split()
result = [] 

for i in range(testCase):

    if input[i] != input[-1] and input[i] < input[i+1]: # input
        result.append(input[i+1])
    else:
        result.append(-1)

    j = i + 2
    while j < testCase:

        if input[i] < input[j]:

            if int(result[i]) < int(input[j]): # result에 먼저 들어온 값이 나중에 비교한 값보다 작을때는 냅둔다
                if result[i] == -1: # 하지만 -1이면 바꿔줌
                    result.pop()
                    result.append(input[j])
                break
            else:  # 나중에 비교한 값이 더 작을때는 삭제하고 다시 넣어준다 (바꿔준다)
                result.pop()
                result.append(input[j])

        j += 1

for n in range(testCase-1):
    print(result[n], end=' ')
print(result[-1])
