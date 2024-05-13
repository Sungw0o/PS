def solve(word: str) -> int:
    return sum([1 for x in range(1, len(word)) if word[x] <= word[x-1]]) + 1

if __name__ == '__main__':
    s = str(input())

    print(solve(s))