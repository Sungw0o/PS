a = int(input())

for i in range (1,a):
    print("*" * i,end='')
    print()
print("*"*a)
for i in range (a-1,0,-1):
    print("*"*i,end='')
    print()