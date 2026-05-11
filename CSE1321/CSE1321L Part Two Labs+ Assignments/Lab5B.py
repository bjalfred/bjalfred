#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:5B


size=int(input("Please enter a value for the size: "))
print()
print(f"This is the requested {size}x{size} box: ")
for column in range(size):
    print("*"*size)
print(f"This is the requested right-facing {size}x{size} right-triangle: ")
for row in range(size-1):
    print("*")
    for column in range((row+1)):
        print("*",end="")
print("*")

print(f"This is the requested left-facing {size}x{size} right-triangle: ")
space=0
for i in range(size):
    for j in range(size-i-1):
        print(" ",end="")
    for j in range((i+1)):
        print("*",end="")
    print()
