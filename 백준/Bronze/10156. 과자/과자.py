a,b,c = map(int,input().split())

snack = a*b
result = snack-c
if result < 0:
    result = 0

print(f"{result}")
