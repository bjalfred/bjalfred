from A4C_Functions import Display_Main_Menu
from A4C_Functions import Deposit
from A4C_Functions import Withdraw
from A4C_Functions import Check_balance

running=True
print("Welcome to the ATM!")
name=input("Please enter your name: ")
balance=float(input("Enter your initial balance: $"))

while running:
    Display_Main_Menu()
    option=int(input("Please choose an option (1-4): "))
    if option==1:
        amount1=float(input("Enter the amount to deposit: $"))
        print(f"Deposited ${amount1}. New balance: ${Deposit(balance,amount1)}")
        balance=Deposit(balance,amount1)
    if option==2:
        amount2=float(input("Enter the amount to withdraw: $"))
        if Withdraw(balance,amount2):
            balance-=amount2
            print(f"Withdrew ${amount2}. New balance: ${balance}")
        else:
            print("Insufficient balance")
    if option==3:
        print(f"Your current balance is: ${Check_balance(balance)}")
    if option==4:
        print(f"Goodbye, {name}! Thank you for using the ATM.")
        running=False
    if option<1 or option>4:
        print("Invalid choice. Please try again.")