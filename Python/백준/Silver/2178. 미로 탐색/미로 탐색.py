from collections import deque


def bfs():
    loop = 0
    visited = [[0 for _ in range(m)] for _ in range(n)]
    visited[0][0] = 1
    q = deque()
    q.append([0, 0])
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    while (q):
        for k in range(len(q)):
            node = q.popleft()
            curx = node[0]
            cury = node[1]
            if curx == m - 1 and cury == n - 1:
                print(loop+1)
                return
            for i in range(4):
                nx = curx + dx[i]
                ny = cury + dy[i]
                if nx < 0 or nx > m - 1 or ny < 0 or ny > n - 1:
                    continue
                if maze[ny][nx] == 1 and visited[ny][nx]!=1:
                    q.append([nx, ny])
                    visited[ny][nx] = 1
        loop += 1

    return


n, m = map(int, input().split())
maze = []
for i in range(n):
    maze.append(list(map(int, list(input()))))

bfs()
