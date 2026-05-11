
class Customer:
    def __init__(self,name):
        self.name=name
        self.rented_movies=[]
    def rent_movie(self,movie):
        if len(self.rented_movies)==2:
            return "Rental limit reached"
        elif movie in self.rented_movies:
            return "Movie already rented by this customer"
        elif movie.is_rented:
            return "Movie already rented by someone else"
        elif not movie.is_rented:
            self.rented_movies.append(movie)
            movie.is_rented=True
            return "Movie rented successfully"
    def return_movie(self,movie):
        if movie not in self.rented_movies:
            return "Movie not rented by this customer"
        else:
            self.rented_movies.remove(movie)
            movie.is_rented=False
            return "Movie returned successfully"


