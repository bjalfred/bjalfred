
smaSan=int(input("Enter the number of small sandwiches: "))
mediSan=int(input("Enter the number of medium sandwiches: "))
larSan=int(input("Enter the number of large sandwiches: "))
xlarSan=int(input("Enter the number of extra-large sandwiches: "))

sStime= smaSan* 30
mStime= mediSan*60
lStime= larSan*75
xlStime= xlarSan*135

toTimeMin= int((sStime+mStime+lStime+xlStime)/60)
toTimeSec=((sStime+mStime+lStime+xlStime)/60)-(int((sStime+mStime+lStime+xlStime)/60))


print(f"You've entered {smaSan} small sandwiches.")
print(f"You've entered {mediSan} medium sandwiches.")
print(f"You've entered {larSan} large sandwiches.")
print(f"You've entered {xlarSan} extra-large sandwiches.")

print(f"Total cooking time is {toTimeMin} minutes and {int(toTimeSec*60)} seconds.")

