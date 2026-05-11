#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:5A

Largestnum=0
print("Please enter 10 numbers and this program will display the largest.")
for i in range (10):
    number=int(input(f"Please enter number {i+1}:"))
    print()
    if number>Largestnum:
        Largestnum=number
print(f"The largest number was {Largestnum}")



