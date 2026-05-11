def check_length(password):
    if len(password)>=8:
        return True
    else:
        return False

def check_special_character(password):
    for i in password:
        if i=="!" or i=="@" or i=="#":
            return True
    return False

def check_upper_lower(password):
    uppercount=False
    lowercount=False
    for i in password:
        if i.isupper():
            uppercount=True
        if i.islower():
            lowercount=True
    if uppercount and lowercount:
        return True
    else:
        return False

password=input("Enter a password: ")
isLength=check_length(password)
isUpperLower=check_upper_lower(password)
isSpecial=check_special_character(password)


if not isLength:
    print("Password does not meet the requirements: Must be at least 8 characters long.")
if not isUpperLower:
    print("Password does not meet the requirements: Must contain both uppercase and lowercase letters.")
if not isSpecial:
    print("Password does not meet the requirements: Must include at least one special character (!, @, #)")
if isLength and isUpperLower and isSpecial:
    print("Password is strong!")