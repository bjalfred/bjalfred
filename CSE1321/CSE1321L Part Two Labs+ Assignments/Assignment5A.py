#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Assignment:5B


numbers=input("Enter a list of numbers: ")
numbers= numbers.replace(","," ")
numbers=numbers.split()
numList=[]

for i in range(len(numbers)):
    numList.append(int(numbers[i]))

def pairDifference():
    newNum=[]
    if len(numList) < 2:
        print("Not enough numbers to calculate differences.")
        return tuple()
    else:
        for j in range(len(numList)-1):
                number=abs(numList[j]-numList[j+1])
                newNum.append(number)
        print("The absolute differences between consecutive numbers:",tuple(newNum))
        return tuple(newNum)


pairDifference()




