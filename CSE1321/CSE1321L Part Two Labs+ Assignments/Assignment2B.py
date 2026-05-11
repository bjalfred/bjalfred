#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Assignment:2B

print("[Loan Approval System]")
age=int(input("Enter your age: "))
income=int(input("Enter your income:"))
credit=int(input("Enter your credit score: "))

if age<18:
    print("You do not qualify for a loan due to age.")
if credit<300 or credit>850:
    print("Invalid credit score")
if 300<=credit<600:
    print("You do not qualify for a loan due to poor credit.")
#basic loans
if 10000<income<50000 and credit>=600:
    print("You qualify for a Basic Loan.")
#standard loans
if 50000<=income<=100000 and credit>=600 or income>=100000 and 600<=credit<700:
    print("You qualify for a Standard Loan.")
#premium loans
if income>100000 and credit>=700:
    print("You qualify for a Premium Loan.")
