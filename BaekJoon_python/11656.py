import sys

input = sys.stdin.readline().rstrip()

# 접미사 저장할 스택
stack = []
n = 0
while n < len(input):
    stack.append(input[n:]) # n부터 끝까지 문자열을 stack에 저장
    n += 1

stack.sort() # 리스트 정렬
for s in stack: # 결과 출력
    print(s)
