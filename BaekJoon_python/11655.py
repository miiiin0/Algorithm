import sys

input = sys.stdin.readline().rstrip("\n")
result = ""

# input을 한글자씩 읽는다
for s in input:

    # 대문자일때
    if 'A' <= s <= 'Z':
        # M보다 앞에 있는 문자인 경우 (A-M일때)
        if s <= 'M':
            # 문자를 아스키코드로 변환하고, 13칸을 움직인 다음, 아스키코드 값을 다시 문자로 변환
            result += chr(ord(s) + 13)

        else: # (N-Z일때)
            result += chr(ord(s)-13)

    # 소문자일때
    elif 'a' <= s <= 'z':
        # m보다 앞에 있는 문자인 경우 (a-m일때)
        if s <= 'm':
            # 문자를 아스키코드로 변환하고, 13칸을 움직인 다음, 아스키코드 값을 다시 문자로 변환
            result += chr(ord(s) + 13)

        else: # (n-z일때)
            result += chr(ord(s) - 13)

    # 다른 문자일때 (숫자나 기호)
    else:
        result += s

print(result)
