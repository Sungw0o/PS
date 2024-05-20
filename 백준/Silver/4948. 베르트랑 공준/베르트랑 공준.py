def sosu(num):
    if num < 2:
        return False
    elif num == 2:
        return True
    elif num % 2 == 0:
        return False
    else:
        last = round(num ** 0.5) + 1
        for i in range(3, last, 2):
            if num % i == 0:
                return False
    return True

while True:
    x = int(input())
    if x == 0:
        break
    cnt = 0
    for i in range(x+1, 2*x+1):
        if sosu(i):
            cnt += 1
    print(cnt)