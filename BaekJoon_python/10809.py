import sys

sentence = sys.stdin.readline().rstrip()

alphabet = {'a': -1, 'b': -1, 'c': -1, 'd': -1, 'e': -1,
            'f': -1, 'g': -1, 'h': -1, 'i': -1, 'j': -1,
            'k': -1, 'l': -1, 'm': -1, 'n': -1, 'o': -1,
            'p': -1, 'q': -1, 'r': -1, 's': -1, 't': -1,
            'u': -1, 'v': -1, 'w': -1, 'x': -1, 'y': -1, 'z': -1}

num = 0
for s in sentence:
    if alphabet[s] == -1: # 처음 등장한 알파벳이라면
        alphabet[s] = num
    num += 1

for n in alphabet.values(): # 결과 출력
    print(n, end=' ')
