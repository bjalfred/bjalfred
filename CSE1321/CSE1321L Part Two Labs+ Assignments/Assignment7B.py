
number=int(input("Enter number of students:"))
studentList=[]


def calculate_average(scores:list):
    total_score=scores[0]+scores[1]+scores[2]
    average=total_score/len(scores)
    return round(average,2)

def get_grade(average:float):
    grade=average
    if average>=90:
        grade="A"
    elif 80<=average<90:
        grade="B"
    elif 70<=average<80:
        grade="C"
    elif 60<=average<70:
        grade="D"
    elif average<60:
        grade="F"
    return grade

def get_status(scores:list):
    total_score = scores[0] + scores[1] + scores[2]
    average = total_score / len(scores)
    if average>=60:
        status="Pass"
    else:
        status="Fail"
    return status

for i in range(number):
    print(f"Enter details for student {i+1}:")
    name=input("Enter student name: ")
    math=float(input("Enter score for Math: "))
    english=float(input("Enter score for English: "))
    science=float(input("Enter score for Science: "))
    if math<0 or math>100:
        print("Invalid input")
        math=float(input("Enter score for Math: "))
    if english<0 or english>100:
        print("Invalid input")
        english = float(input("Enter score for English: "))
    if science<0 or science>100:
        print("Invalid input")
        science = float(input("Enter score for Science: "))
    total_score=math+english+science
    studentInfo={"Name":name
        ,"scores":[science,math,english],
        "total":total_score,
        "average": calculate_average([science,math,english]),
        "grade":get_grade(calculate_average([science,math,english])),
        "status":get_status([science,math,english])}
    studentList.append(studentInfo)
    print("Total score: ",studentInfo["total"])
    print("Average score:",studentInfo["average"])
    print("Grade: ",studentInfo["grade"])
    print("Status: ",studentInfo["status"])

passed=0
failed=0
classAvg=0
topStudent=[]
valedictorian=[]


print("==============================")
print("        Summary Report")
print("==============================")

for student in studentList:
    print("Name:", student["Name"])
    print("Scores:", student["scores"])
    print("Total:", student["total"])
    print("Average:", student["average"])
    print("Grade:", student["grade"])
    print("Status:",student["status"])
    classAvg+=student["average"]
    topStudent.append(student["average"])
    highestStudent=max(topStudent)
    if student["status"]=="Pass":
        passed+=1
    if student["status"]=="Fail":
        failed+=1
    if student["average"]==highestStudent:
        valedictorian.append(student["Name"])



print(f"Class Average: {round((classAvg/len(studentList)),2)}")
print("Students Passed: ", passed)
print("Students Failed: ", failed)
print(f"Top Student: {valedictorian[0]}")










