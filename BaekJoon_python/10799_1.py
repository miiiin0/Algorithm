import sys

input = list(sys.stdin.readline())
open = 0
result = 0
n = 0

length = len(input)
for n in range(length):
    if input[n] == '(':
        open += 1
        count = 0
        i = n + 1
        while open != 0:
            if input[i] == '(':
                open += 1
                if input[i+1] == ')': # '(' 다음이 바로 ')'일때
                    count += 1
                    open -= 1
                    i += 1

            elif input[i] == ')':
                open -= 1
            i += 1

        if count != 0:
            result += count + 1

print(result)
