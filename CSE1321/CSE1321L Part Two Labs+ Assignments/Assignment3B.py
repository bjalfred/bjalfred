#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Assignment:3B




print("[Character Frequencies]")
string1=input("Enter a string: ")

string1=string1.replace(" ","")
lowerString=string1.lower()

tempText=" "
for i in lowerString:
    if tempText.count(i)==1:
        continue
    count=lowerString.count(i)+lowerString.count(i.upper())
    print(f"{i} has been found {count} times")
    tempText+=i

