def fibonacci(n):
    if n <= 1:
        return n
    else:
        fib_prev = 0
        fib_current = 1
        for _ in range(2, n + 1):
            fib_next = fib_prev + fib_current
            fib_prev, fib_current = fib_current, fib_next
        return fib_current

a = int(input())

fibonacci_result = fibonacci(a)
print(f"{fibonacci_result}")
