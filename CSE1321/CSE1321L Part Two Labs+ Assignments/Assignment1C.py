#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Assignment:1C

print("[Centimeters to Feet and Inches Converter]")
centimeters=int(input("Enter the length in centimeters: "))

inches=centimeters/2.54
feet=inches//12
remainder=inches-(feet*12)

print(f"The length is {feet} feet and {round(remainder,2)} inches")