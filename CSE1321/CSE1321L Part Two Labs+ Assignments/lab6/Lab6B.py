#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:6B
import random

running=True
random_number=random.randint(10,20)
while running:
    #should I keep it in the while loop?
    #random_number=random.randint(10,20)
    guess=int(input("Enter any number between 1 and 100: "))
    if guess>random_number:
        print("Too high!")
    if guess<random_number:
        print("Too low!")
    if guess==random_number:
        print(f"Correct! I was thinking of {random_number} ")
        running=False

