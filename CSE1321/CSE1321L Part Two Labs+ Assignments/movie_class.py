
class Movie:
    def __init__(self,title,director):
        self.title=title
        self.director=director
        self.is_rented=False
    def rent(self):
        if not self.is_rented:
            self.is_rented = True
            return "You rented the movie"
        else:
            return "Movie already rented"
    def return_movie(self):
        if self.is_rented:
            self.is_rented=False
            return "You returned the movie"
        else:
            return  "Movie is not rented"