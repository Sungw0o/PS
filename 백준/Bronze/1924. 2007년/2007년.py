months = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
days = ["MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"]

month, day = map(int, input().split())

total_days = day
for i in range(month - 1):
    total_days += months[i]

day_of_week = days[(total_days - 1) % 7]

print(day_of_week)
