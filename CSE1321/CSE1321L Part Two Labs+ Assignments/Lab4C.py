#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:4C

side1=(int(input("Enter the first side of the triangle: ")))
side2=(int(input("Enter the second side of the triangle: ")))
side3=(int(input("Enter the third side of the triangle: ")))

if side1==side2==side3:
    print("The triangle is an equilateral triangle.")
else:
    if side1==side2 or side2==side3 or side1==side3:
        print("The triangle is an isosceles triangle.")
    print("The triangle is a scalene triangle.")
    if not side1+side2>=side3 or not side2+side3>=side1 or not side1+side3>=side2:
        print("The sides do not form a valid triangle.")
    if side1==0 or side2==0 or side3==0:
        print("Invalid input. All sides must be greater than 0. ")