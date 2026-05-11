#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:8B

print("[Friend List]")
friendList=[]
running=True
while running:
    print("1 - Add friends")
    print("2 - List friends")
    print("3 - Quit")
    selection=int(input("Make your selection: "))
    if selection==1:
        name=input("Enter your friend's name: ")
        age = input("Enter your friend's age: ")
        friendList.append((name,age))
        print("Friend added")
    if selection==2:
        for i in friendList:
            print(f"Name:{i[0]}, Age: {i[1]}")
    if selection==3:
        print("Shutting down...")
        running=False