//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab: blue ray disk class


public class BlueRayDisk {
    public String title;
    public String director;
    public int yearOfRelease;
    public double cost;
    public BlueRayDisk next;

    public BlueRayDisk(String nameOfMovie, String nameOfDirector, int movieYear, double priceOfMovie){
        title=nameOfMovie;
        director=nameOfDirector;
        yearOfRelease=movieYear;
        cost=priceOfMovie;
        next=null;

    }

    @Override
    public String toString(){
        return title + " - " + director + " (" + yearOfRelease + ") "+ ": " + cost ;
    }
}
