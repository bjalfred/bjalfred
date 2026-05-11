#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:9A


firstNum=int(input("Enter your first number: "))
secondNum=int(input("Enter your second number: "))

def allMath(firstNum, secondNum):
    if firstNum>0 and secondNum>0:
        math=(firstNum+secondNum,firstNum-secondNum,firstNum*secondNum,firstNum/secondNum, firstNum//secondNum,firstNum%secondNum,firstNum**secondNum)
        return math
    else:
        math2=(firstNum+secondNum,firstNum-secondNum,firstNum*secondNum,None,None,None,firstNum**secondNum)
        return math2

print(f"Your resulting tuple is {allMath(firstNum,secondNum)} ")