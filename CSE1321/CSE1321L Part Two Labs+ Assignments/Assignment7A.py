from movie_class import Movie
from customer_class import Customer

# Define a Movie and Customer for testing
movie1 = Movie("Inception", "Christopher Nolan")
customer1 = Customer("Ethan")
# Scenario 1: Ethan rents the movie "Inception"
print(customer1.rent_movie(movie1))

# Scenario 2: Ethan tries to rent "Inception" again
print(customer1.rent_movie(movie1))

# Scenario 3: Ethan returns "Inception"
print(customer1.return_movie(movie1))

# Scenario 4: Ethan tries to return "Inception" again
print(customer1.return_movie(movie1))

# Scenario 5: Another customer, Olivia, tries to rent "Inception"
customer2 = Customer("Olivia")
print(customer2.rent_movie(movie1))

# Scenario 6: Ethan tries to rent more than the limit of 2 movies
# Define more movies
movie2 = Movie("The Matrix", "Wachowskis")
movie3 = Movie("Interstellar", "Christopher Nolan")
# Ethan rents 2 movies
print(customer1.rent_movie(movie2))
print(customer1.rent_movie(movie3))

# Ethan tries to rent a third movie- still renting it to him?
movie4 = Movie("Avatar", "James Cameron")
print(customer1.rent_movie(movie4))