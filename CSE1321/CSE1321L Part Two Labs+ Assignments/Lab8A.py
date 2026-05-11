#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:8A

running=True

print("[Mailing List]")
mailingList=[]
while running:
    print("1 - Add email")
    print("2 - Delete email")
    print("3 - List all emails")
    print("4 - Quit")
    selection=int(input("Make your selection: "))
    if selection==1:
        addEmail=input("Enter the email to be added: ")
        mailingList.append(addEmail)
        print("Email added to mailing list.")
    if selection==2:
        subEmail=input("Enter the email to be removed: ")
        if subEmail not in mailingList:
            print(f"No such email in mailing list: {subEmail}")
        else:
            mailingList.remove(subEmail)
            print("Email removed from mailing list.")
    if selection==3:
        for i in mailingList:
            print(i)

    if selection==4:
        print("Shutting down...")
        running=False