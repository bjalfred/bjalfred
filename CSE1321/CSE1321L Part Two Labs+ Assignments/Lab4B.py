#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:4B

print("Welcome!")
maniNum= float(input("Please input a number: "))

print("What would you like to do with this number: ")
print("0) Get the additive inverse of the number")
print("1) Get the reciprocal of the number")
print("2) Square the number")
print("3) Cube the number")
print("4) Exit the program ")
selection=int(input(""))

if selection<0 or selection>4:
    print("Invalid option !")
if selection==0:
    print(f"The additive inverse of {maniNum} is -{maniNum}")
if maniNum == 0 and selection == 1:
    print("Cannot divide by 0!")
if maniNum != 0 and selection==1:
    print(f"The reciprocal of {maniNum} is {round(1/maniNum,2)}")
if selection==2:
    print (f"The square of {maniNum} is {maniNum**2}")
if selection==3:
    print(f"The cube of {maniNum} is {maniNum**3}")
if selection==4:
    print("Thank you, goodbye!")