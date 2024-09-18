num1: int = int(input())
num2: int = int(input())

n: int = 1
while True:
    data: int = int(num2 % 10 ** n)
    d: int = int(data / (10 ** (n - 1)))

    print(d * num1)
    n += 1

    if data == num2:
        break

print(num1 * num2)