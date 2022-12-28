def count_candy(data):
    Max = 1
    for i in range(N):
        cnt = 1
        for j in range(1, N):
            if data[i][j] == data[i][j - 1]:
                cnt += 1
            else:
                cnt = 1
            Max = max(Max, cnt)
        cnt = 1
        for j in range(1, N):
            if data[j][i] == data[j - 1][i]:
                cnt += 1
            else:
                cnt = 1
            Max = max(Max, cnt)

    return Max


# 입력받기
N = int(input())
arr = [list(input()) for _ in range(N)]
answer = 1

# 인접한 것 바꾸기
for i in range(N):
    for j in range(N):
        # j+1이 N보다 작으면 열을 바꿀 수 있다
        if j + 1 < N:
            # 인접한 두개 swap
            arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]

            # 함수 호출 결과 값을 temp에 저장
            temp = count_candy(arr)

            if answer < temp:
                answer = temp

            # 원래대로 돌려놓기
            arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]

        # i+1이 N보다 작으면 행을 바꿀 수 있다
        if i + 1 < N:
            # 인접한 두개 swap
            arr[i][j], arr[i + 1][j] = arr[i + 1][j], arr[i][j]

            # 함수 호출 결과 값을 temp에 저장
            temp = count_candy(arr)

            if answer < temp:
                answer = temp

            # 원래대로 돌려놓기
            arr[i][j], arr[i + 1][j] = arr[i + 1][j], arr[i][j]

# 결과 출력
print(answer)
