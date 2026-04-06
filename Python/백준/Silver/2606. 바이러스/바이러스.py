from collections import deque


def chasing():
    count = 0
    visited = [1]
    dq = deque()
    dq.append(1)

    while (dq):
        node = dq.popleft()
        for next in ways[node]:
            if next not in visited:
                visited.append(next)
                dq.append(next)
                count+=1
    print(count)

computers = int(input())
way = int(input())
ways = [[] for _ in range(computers + 1)]

for i in range(way):
    a, b = map(int, input().split())
    ways[a].append(b)
    ways[b].append(a)  # 양방향 연결

chasing()
