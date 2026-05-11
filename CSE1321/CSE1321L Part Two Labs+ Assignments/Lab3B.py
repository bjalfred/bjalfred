hours=0
quaPoints=0
for i in range (1,5):
    course=int(input(f"Course {i} hours: "))
    grade=int(input(f"Grade for course {i}: "))
    hours+=course
    quaPoints+=(course*grade)
    if i==4:
        print (f"Total hours: {hours}")
        print(f"Total quality points: {quaPoints}")
        print(f"Your GPA for this semester is {round(quaPoints/hours,2)}")
