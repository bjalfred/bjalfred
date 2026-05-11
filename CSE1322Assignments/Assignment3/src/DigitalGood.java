//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Assignment: Digital Good

public class DigitalGood extends Item {
    protected String description;

    public DigitalGood(String nameOfItem, double priceOfItem, String nameOfDescription){
        super(nameOfItem,priceOfItem);
        description = nameOfDescription;

    }

    public String setDescription(String nameOfDescription){
        description = nameOfDescription;
        return description;

    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString(){
        return super.toString() + "\n\t Description: " + description;
    }
}

