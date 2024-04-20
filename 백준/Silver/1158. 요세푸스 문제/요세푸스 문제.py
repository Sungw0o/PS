n, k = map(int, input().split())
queue = list(range(1, n+1))
answer = []
index = 0

while queue:
    index = (index + k - 1) % len(queue)
    answer.append(str(queue.pop(index)))

print("<" + ", ".join(answer) + ">")
