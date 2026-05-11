#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:6C

size=int(input("Enter Number for Rows or 0 to quit: "))
for i in range(1, size + 1):
    # num of spaces
    for j in range(size - i):
        print(" ",end="")
    # increasing numbers
    for k in range(i, 0, -1):
        print(k, end="")
    # decreasing numbers
    for l in range(2,i+1):
        print(l, end="")
    print()
