n = int(input())
dp=[]
for i in range(n):
    dp.append(list(map(int,input().split())))

for i in range(1,n):
    # 시작 경우가 3개이므로 3개
    # (상향식) 아래에서 위로
    dp[i][0] += min(dp[i-1][1],dp[i-1][2])
    dp[i][1] += min(dp[i-1][0],dp[i-1][2])
    dp[i][2] += min(dp[i-1][1],dp[i-1][0])

print(min(dp[-1]))