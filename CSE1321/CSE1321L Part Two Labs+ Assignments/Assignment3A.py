#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Assignment:3A


size=int(input("Enter Number for Rows or 0 to quit: "))

if size%2==0:
    size+=1
    print(f"Size must be an odd number; we will increase it to {size}")

num=0
space=size//2

for i in range(0, (size//2)+1):
    # num of spaces
    print(" " * space, end="")
    space -= 1
    for k in range(0,2*i +1):
        print(num,end="")
        num+=1
        if num%10==0:
            num=0
    print()

space=1
for l in range(size-2,0,-2):
    print(" "*space,end="")
    space+=1
    for n in range(l):
        print(num, end="")
        num += 1
        if num%10==0:
            num = 0
    print()






