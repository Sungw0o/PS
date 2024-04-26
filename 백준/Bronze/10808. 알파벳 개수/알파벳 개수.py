s = input()


alphabet_count = [0] * 26


for char in s:
    index = ord(char) - ord('a')
    alphabet_count[index] += 1


print(' '.join(map(str, alphabet_count)))
