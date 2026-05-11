#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Lab:9B

running=True
login={}

while running:
    print("Choose an option")
    print("1- Login")
    print("2- Register")
    print("E- Exit")
    choice=input()

    if choice=="1":
        print("[Login]")
        username = input("Username: ")
        password = input("Password: ")
        if username in login and login[username]==password:
            print("Success!")
            running2=True
            while running2:
                print("Choose an option")
                print("3- Change Password")
                print("4- Logout")
                print("E- Exit")
                choice=input()
                if choice=="3":
                    print("[Changin password]")
                    newPass= input("Password: ")
                    login[username]=newPass
                elif choice=="4":
                    print("Logging Out...")
                    break
                elif choice=="E":
                    running2=False
        else:
            print("Incorrect username/password!")
    if choice=="2":
        print("[Register]")
        username =input("Username: ")
        password =input("Password: ")
        print("User successfully added!")
        login[username]=password
    if choice=="E":
        print("Terminating...")
        break