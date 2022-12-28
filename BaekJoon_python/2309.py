list = [int(input()) for i in range(9)]

total = sum(list)

for i in range(8):
    for j in range(i+1, 9):
        if 100 == total - (list[i] + list[j]):
            num1 = list[i]
            num2 = list[j]

list.remove(num1)
list.remove(num2)
list.sort()  # 오름차순 정리
for i in range(len(list)):
    print(list[i])
