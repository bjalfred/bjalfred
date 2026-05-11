#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Assignment:1B

print("[Ideal Gas Law Calculator]")
moles=float(input("Enter the number of moles of the gas: "))
temp=float(input("Enter the temperature of the gas in Celsius: "))
volume=float(input("Enter the volume of the gas in Liters: "))
R=0.0821 #ideal gas constant
kelTemp= temp+273.15
pressure=(moles*R*kelTemp)/volume
print(f"The pressure of the gas is {round(pressure,2)} atm")