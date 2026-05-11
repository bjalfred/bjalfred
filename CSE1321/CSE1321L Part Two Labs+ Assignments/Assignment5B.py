from random import random

#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Assignment:5B

row=int(input("Enter the width of the grid: "))
column=int(input("Enter the height of the grid: "))

Board=[]
treasureBoard=[]
numberOfUndiscoveredTreasures=0

for i in range(column):
    treasureBoard.append([])
    Board.append([])
    for j in range (row):
        number=random()
        if number<0.7:
            treasureBoard[i].append("O")
        else:
            treasureBoard[i].append("T")
            numberOfUndiscoveredTreasures+=1
        Board[i].append("O")

print("Number of treasures hidden: ",numberOfUndiscoveredTreasures)

while numberOfUndiscoveredTreasures:
    answer1=int(input(f"Enter the row number (0 to {row-1}) :"))
    answer2=int(input(f"Enter the column number(0 to {column-1}):"))
    if "T"==treasureBoard[answer2][answer1]:
        print (" Congratulations! You found a treasure!")
        numberOfUndiscoveredTreasures -= 1
        Board[answer2][ answer1]="X"
        for r in range(row):
            for c in range(column):
                print(Board[r][c], end="")
            print()
    else:
        print("No treasure here, try again!")

print("Congratulations! You've found all the treasures!")
for r in range(row):
    for c in range (column):
        print(Board[r][c], end="")
    print()