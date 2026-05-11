#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:13A

number=(input("Enter temperatures for each day separated by space: "))
print()
numbers=number.split()
integer_numbers=list(map(int,numbers))


def hot():
    heat=0
    hotdays=0
    hottemp=0
    for i in range(len(integer_numbers)):
        if integer_numbers[i]>30:
            heat+=1
            if (heat-hottemp)==3:
                hotdays+=1
        else:
            heat=0


    print("Number of heat waves:", hotdays)

def cold():
    cold = 0
    coldays = 0
    coldtemp = 0
    days = (len(integer_numbers))
    for i in range(len(integer_numbers)):
        if integer_numbers[i]<=15:
            cold+=1
            if cold>coldtemp:
                coldtemp=cold
        if integer_numbers[i]>15:
            cold=0
    coldays=coldtemp
    print("Longest cold streak:", coldays ,"days")
    avgTemp = sum(integer_numbers) / days
    avg=round(avgTemp, 2)
    print(f"Average temperature: {avg}°C")

hot()
cold()
