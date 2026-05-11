#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Assignment:2C

print("Welcome to the RPG Game!")
print("Choose your class: 1. Warrior 2. Mage 3. Healer ")
charClass=int(input("Enter the number of your class (1/2/3): "))

if charClass<1 or charClass>3:
    print("Invalid class choice. The game ends.")
    print("Thank you for playing!")

match charClass:
    case 1:
        print("Warrior: You have chosen Warrior! You are strong and brave.")
        print("What would you like to do? 1.Attack your sword. 2. Defend with your shield.")
        action=int(input("Choose your action (1/2): "))
        if action==1:
            print("You swing your sword and defeat the enemy!")
            print("Thanks for playing!")
        if action==2:
            print( "You raise your shield and block the enemy's attack!")
            print("Thanks for playing!")
        if action< 1 or action>2:
            print("Invalid action choice. The game ends.")
            print("Thank you for playing!")

    case 2:
        print("You have chosen Mage! You wield powerful magic.")
        print("What would you like to do? 1. Cast a fireball 2. Cast a healing spell ")
        action = int(input("Choose your action (1/2): "))
        if action == 1:
            print("You cast a fireball and scorch the enemy!")
            print("Thanks for playing!")
        if action == 2:
            print("You cast a healing spell and restore your energy.")
            print("Thanks for playing!")
        if action < 1 or action > 2:
            print("Invalid action choice. The game ends.")
            print("Thank you for playing!")

    case 3:
        print("You have chosen Healer! You are kind and supportive.")
        print("What would you like to do? 1. Heal your ally 2. Attack with your staff")
        action = int(input("Choose your action (1/2): "))
        if action == 1:
            print(" You heal your ally and boost their morale!")
            print("Thanks for playing!")
        if action == 2:
            print("You swing your staff and knock out the enemy!")
            print("Thanks for playing!")
        if action < 1 or action > 2:
            print("Invalid action choice. The game ends.")
            print("Thank you for playing!")
