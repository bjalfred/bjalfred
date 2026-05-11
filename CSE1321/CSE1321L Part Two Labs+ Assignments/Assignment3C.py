#Class: CSE 1321 L
# Section: 10
#Term: Spring 2025
#Instructor: Srisaigoutham Pilli
#Name: Brooke Alfred
#Assignment:3C


print("Welcome to the Guess the Word game!")
word=input("Enter a word to guess (lowercase letters only): ")
running=True
unknownWord=len(word)*"_"
while running:
    print("The word to guess is: ",unknownWord)
    guess=input("Guess a letter: ")
    for i in range(len(word)):
        if guess==word[i]:
            print("Good guess!")
            unknownWord = unknownWord[:i] + guess + unknownWord[i + 1:]
    else:
        print("Oops! That letter is not in the word.")
    if unknownWord==word:
        print(f"Congratulations! You've guessed the word: {word}")
        running=False



