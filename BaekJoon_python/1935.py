import sys

N = int(sys.stdin.readline())
input = list(sys.stdin.readline().rstrip())

num = []
for i in range(N):
    num.append(int(sys.stdin.readline().rstrip()))

stack = []

for i in input:

    if i.isalpha(): # 알파벳을 만났을때
        stack.append(num[ord(i) - ord('A')]) # 알파벳에 대응하는 숫자를 리스트에 저장한다.

    else: # 연산자를 만났을때

        # 연산자 앞에 숫자 두개를 pop해줌
        a = stack.pop()
        result = stack.pop()

        # 계산
        if i == '+':
            result += a
        elif i == '-':
            result -= a
        elif i == '*':
            result *= a
        elif i == '/':
            result /= a

        # 결과값을 스택에 저장
        stack.append(result)

# 소숫점 둘째 자리까지 출력하기 위해 '%.2f' 사용
# 리스트의 맨 마지막 요소를 가져오기 위해 [-1] 사용
print('%.2f' %stack[-1])
