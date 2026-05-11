
size=int(input("Enter Number for Rows or 0 to quit: "))
for i in range(size,0,-1):
    # num of spaces
    for j in range(size - i):
        print(" ",end="")
    for l in range(i):
        print(l%10, end="")
    for k in range(i-2,-1,-1):
        print(k%10, end="")
    print()