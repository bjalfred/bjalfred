#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:6A

running=True
product=0
exProduct=0
while running:
    print("Multiplication and Exponent Calculator")
    print("Choose option 1 for Multiplication")
    print("Choose option 2 for Exponentiation")
    print("Choose option 3 to Exit")
    choice=int(input(""))
    if choice==1:
        operand1=int(input("Enter an operand: "))
        operand2=int(input("Enter the other operand: "))
        for i in range (operand2):
            product+=operand1
        print(f" {operand1} x {operand2}= {product}")
        product=0
    if choice==2:
        base=int(input("Enter the base: "))
        exponent=int(input("Enter the exponent: "))
        result = 1
        for i in range(exponent):
            t = 0
            for j in range(result):
                t += base
            result = t
        print(result)

    if choice==3:
        print("Closing the Calculator...")
        running=False