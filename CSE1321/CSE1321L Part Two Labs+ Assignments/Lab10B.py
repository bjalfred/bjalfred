#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:10B

class Dog:
    def __init__(self, name, age, furColor, typeOfDog, weight):
        self.name = name
        self.age = age
        self.furColor = furColor
        self.breed = typeOfDog
        self.weight = weight
    def bark(self):
        print("Woof! Woof!")
    def rename(self,name):
        self.name=name
    def eat(self,feed):
        self.weight+=feed

print("You are about to create a dog.")
age = input("How old is the dog: ")
print()
weight = float(input("How much does the dog weigh: "))
print()
name = input("What is the dog's name: ")
print()
furColor = input("What color is the dog: ")
print()
breed = input("What breed is the dog: ")
print()
d1 = Dog(name, age, furColor, breed, weight)
print(f"{d1.name} is a {d1.age} year old {d1.furColor} {d1.breed} that weighs {d1.weight} lbs.")
d1.bark()
feed=float(input(f"{d1.name} is hungry, how much should he eat:"))
print()
d1.eat(feed)
d1.rename(input(f"{d1.name} isn't a very good name. What should they be renamed to: "))
print()
print(f"{d1.name} is a {d1.age} year old {d1.furColor} {d1.breed} that weighs {d1.weight} lbs.")
