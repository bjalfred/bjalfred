def format_word(word):
    return word.capitalize()

def convert_to_pascal(text):
    temp=""
    result=""
    for i in text+" ":
        if i==" ":
            result+=format_word(temp)
            temp=""
            continue
        temp+=i
    return result


word=input("Enter a string: ")
print(f"pascal case: {convert_to_pascal(word)}")
