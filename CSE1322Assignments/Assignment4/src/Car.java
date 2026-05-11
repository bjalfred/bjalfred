//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Assignment: Car Class

public abstract class Car {
    protected int id;
    public static int nextId=0;

    Car(){
        id=nextId;
        nextId+=1;
    }

    public int getID(){
        return id;
    }
}
