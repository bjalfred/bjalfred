#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:7B

from MyMath import my_Avg
from MyMath import my_Max
from MyMath import my_Min

number1=int(input("Enter number 1: "))
number2=int(input("Enter number 2: "))

print(f"Min is {my_Min(number1,number2)}")
print(f"Max is {my_Max(number1,number2)}")
print(f"Average is {my_Avg(number1,number2)}")
