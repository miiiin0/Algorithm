import sys

# 띄어쓰기 기준으로 잘라서 리스트 형태로 저장
num = list(sys.stdin.readline().split())

print(int(num[0] + num[1]) + int(num[2] + num[3]))
