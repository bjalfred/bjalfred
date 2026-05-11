def Display_Main_Menu():
    print("ATM Main Menu")
    print("1. Deposit")
    print("2. Withdraw")
    print("3. Check Balance")
    print("4. Exit")


def Deposit(balance,amount1):
    balance+=amount1
    return balance

def Withdraw(balance,amount2):
    if amount2<=balance:
        balance-=amount2
        return True
    if amount2>balance:
        return False

def Check_balance(balance):
    return balance