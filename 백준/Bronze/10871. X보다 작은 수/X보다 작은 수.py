a, b = map(int, input().split(" "))

arr = []
data = map(int, input().split(" "))
for i in data:
    if(i < b):
        arr.append(i)

s = ''
for i in arr:
    s += str(i) + " "

print(s)