import math

T = int(input())

for _ in range(T):
    x1, y1, r1, x2, y2, r2 = list(map(int, input().split()))
    
    dis = math.sqrt((x1 - x2)**2 + (y1 - y2)**2)
    
    if dis == 0:  
        if r1 == r2:
            print(-1)
        else:                   
            print(0)
    else:            # 두 원의 중심이 다를 경우
        if r1+r2 == dis or abs(r2-r1) == dis:
            print(1)
        elif ((abs(r1-r2) < dis) and (dis < r1+r2)):
            print(2)
        else:
            print(0)