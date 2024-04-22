while True:
    a, b = map(int, input().split())
    if a == 0 and b == 0:
        break
    else:
        if a > b:
            print("Yes")
        else:
            print("No")
