#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:10A



class Chair:
    #attributes of chair
    def __init__(self, legs=4, rolling = False, material = "wood"):
        self.numOfLegs = legs
        self.rolling = rolling
        self.material = material

print("You are about to create a chair.")
legs=input("How many legs does your chair have:")
print()
rolling=(input("Is your chair rolling (true/false): "))
print()
material=input("What is your chair made of: ")
print()
c1 = Chair(legs, rolling, material)
if c1.rolling=="false":
    print(f"Your chair has {c1.numOfLegs} legs, is not rolling, and is made of {c1.material}.")
if c1.rolling=="true":
    print(f"Your chair has {c1.numOfLegs} legs, is rolling, and is made of {c1.material}.")
print ("This program is going to change that.")
c1= Chair()
if c1.rolling==False:
    print(f"Your chair has {c1.numOfLegs} legs, is not rolling, and is made of {c1.material}.")
if c1.rolling==True:
    print(f"Your chair has {c1.numOfLegs} legs, is rolling, and is made of {c1.material}.")