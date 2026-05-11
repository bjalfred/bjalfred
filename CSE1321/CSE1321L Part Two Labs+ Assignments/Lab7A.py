#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:7A

def isValid(width,height):
    if width+height>30:
        return True
    else:
        return False

def perimeter(width,height):
    return (width * 2) + (height * 2)

def area(width,height):
    return width*height


running=True
while running:
    width = float(input("Enter width: "))
    height = float(input("Enter height: "))

    if isValid(width,height):
        print("This is a valid rectangle.")
        print(f"The area is: {area(width,height)}")
        print(f"The perimeter is: {perimeter(width,height)}")
        retry = input("Do you want to enter another width and height (Y/N)?: ")
    else:
        print("This is not a valid a rectangle")
        retry=input("Do you want to enter another width and height (Y/N)?: ")
    if retry=="Y":
        continue
    else:
        print("Program Ends")
        running=False




