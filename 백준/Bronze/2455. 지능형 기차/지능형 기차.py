arr = []
result = 0

for i in range(4):
    a, b = map(int, input().split())   # a와 b 입력 4번씩 받기
    
    result = result - a + b
    arr.append(result)
        
print(max(arr))