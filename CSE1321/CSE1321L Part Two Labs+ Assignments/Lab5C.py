#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:5C

running=True

while running:
    magicWord=input(f"If you would like to stop this program, say \"please\" : ")
    print()
    if "please"==magicWord:
        running=False
        print("Program complete")
