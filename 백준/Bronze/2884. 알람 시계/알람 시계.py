hour,sec= input().split()
hour = int(hour)
sec = int(sec)

if hour > 0:
    if sec >= 45:
        sec -= 45
    else:
        hour -= 1
        sec += 60
        sec -= 45
else:
    if sec >= 45:
        sec -= 45
    else:
        hour += 23
        sec += 60
        sec -= 45

print(f"{hour} {sec}")
