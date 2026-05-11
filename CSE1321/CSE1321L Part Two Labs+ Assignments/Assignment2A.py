#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Assignment:2A

print("[Discount Calculator]")
totAmount=(float(input("Enter your total purchase amount: ")))
memClub=input(f"Are you a member of the shopping club {"(Yes or No)"}? ")

if totAmount < 50:
    print("Purchase amount not sufficient for a discount.")
if 50<=totAmount <= 200 and (memClub=="no" or memClub=="NO" or memClub=="No"):
    smallDiscount1=totAmount-(0.05*totAmount)
    print(f"Your discount is: ${0.05 * totAmount}")
    print(f"Your total price after discount is: {smallDiscount1}")
if 50<=totAmount <= 200 and (memClub=="YES" or memClub=="yes" or memClub=="Yes"):
    clubDiscount1=totAmount-(0.1*totAmount)
    print(f"Your discount is: ${0.1*totAmount}")
    print(f"Your total price after discount is: {clubDiscount1}")

if totAmount>200 and memClub == ("no" or memClub == "NO" or memClub == "No"):
    smallDiscount2 = totAmount - (0.1 * totAmount)
    print(f"Your discount is: ${0.1 * totAmount}")
    print(f"Your total price after discount is: {smallDiscount2}")
if totAmount>200 and (memClub == "YES" or memClub == "yes" or memClub == "Yes"):
    clubDiscount2 = totAmount - (0.15 * totAmount)
    print(f"Your discount is: ${0.15 * totAmount}")
    print(f"Your total price after discount is: {clubDiscount2}")



