



amoOwed=float(input("Amount owed: $"))
apR=float(input("APR: "))
monPerRate=(apR/100)/12
minPay=amoOwed*monPerRate
print(f"Monthly percentage rate: {round(monPerRate*100,3)}")
print(f"Minimum payment: ${round(minPay,2)}")