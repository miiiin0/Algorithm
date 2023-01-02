import sys

input = list(sys.stdin.readline().rstrip())

result = []

# for n in input:
#     if n.isalpha():
#         result.append()
#     else:
#         if n == '(':
#             continue
#         elif n == ')':
#             continue
#         elif n == '+' or n == '-':
#             print('sfd')
#         elif n == '*' or n == '/':
#             print('sfsf')

n = 0
priority = False

while n < len(input):
    if input[n].isalpha():
        result.append(input[n])

    else:
        if input[n] == '(':
            operation = result.pop()
            priority = True

        if priority is True:
            result.append(input[n])

            if input[n] == ')':
                continue
        elif input[n] == '+' or input[n] == '-':
            result.append(input[n+1])
            result.append(input[n])

        elif input[n] == '*' or input[n] == '/':
            result.append(input[n+1])
            result.append(input[n])

    n += 1

# 결과 출력
for i in result:
    print(i, end='')
