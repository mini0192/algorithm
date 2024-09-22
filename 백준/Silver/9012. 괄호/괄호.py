n = int(input())

rtn = ""
for i in range(n):
    check = True
    stack= []
    str = input()
    for s in str:
        if s == '(':
            stack.append("a")
        else:
            if len(stack) == 0:
                rtn += "NO\n"
                check = False
                break
            stack.pop()

    if not check:
        continue
    if len(stack) == 0:
        rtn += "YES\n"
    else:
        rtn += "NO\n"

print(rtn)
