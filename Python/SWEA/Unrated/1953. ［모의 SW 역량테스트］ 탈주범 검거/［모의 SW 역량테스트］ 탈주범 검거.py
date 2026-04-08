from collections import deque


def bfs(x, y):
    global L
    visited = [[False] * M for _ in range(N)]
    visited[y][x] = True
    dq = deque()
    dq.append([x, y])
    cnt = 1

    while (True):
        if L == 1: #L은 이미한번 쓴게 현위치니까 L-1번 이동해야함..
            break
        dqLen = len(dq)
        for t in range(dqLen):
            node = dq.popleft()
            curx = node[0]
            cury = node[1]
            dir = hole[cury][curx]
            if dir == 0:
                continue
            for i in range(len(dx[dir])):
                nx = curx + dx[dir][i]
                ny = cury + dy[dir][i]
                if nx<0 or nx>M-1 or ny<0 or ny>N-1:
                    continue
                ndir = hole[ny][nx]
                if isConnected(curx, cury, nx, ny, ndir) == True and visited[ny][nx] == False:
                    visited[ny][nx] = True
                    cnt+=1
                    dq.append([nx,ny])
        L -= 1
    # for y in range(M):
    #     for x in range(N):
    #         if visited[y][x]==True:
    #             cnt+=1

    return print("#"+str(test+1)+" "+str(cnt))


def isConnected(curx, cury, nx, ny, ndir):
    if ndir == 0:
        return False
    for i in range(len(dx[ndir])):
        checkX = nx + dx[ndir][i]
        checkY = ny + dy[ndir][i]
        if checkX == curx and checkY == cury:
            return True
    return False



tc = int(input())
for test in range(tc):
    hole = []
    N,M, R, C, L = map(int, input().split())  # 하수구(세로 가로) 범인(세로 가로) 소요시간
    dx = [[], [0, 0, 1, -1], [0, 0], [1, -1], [0, 1], [0, 1], [0, -1], [0, -1]]
    dy = [[], [1, -1, 0, 0], [1, -1], [0, 0], [-1, 0], [1, 0], [1, 0], [-1, 0]]

    for _ in range(N):
        hole.append(list(map(int, input().split())))

    bfs(C,R)
