a, b, c = map(int, input().split())

price = 0
if a == b == c:
    price = 10000 + (a * 1000)
elif a == b or b == c or c == a:
    if a == b or a == c:
        price = 1000 + (a * 100)
    else:
        price = 1000 + (b * 100)
else:
    price = max(a, b, c) * 100

print(price)
