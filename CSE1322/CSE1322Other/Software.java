//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Assignment:Software

public class Software extends Item {
    protected String publisher= "Unknown";

    public Software(String nameOfItem, double priceOfItem, String nameOfPublisher){
        super(nameOfItem, priceOfItem);
        setPublisher(nameOfPublisher);
    }

    public void setPublisher(String nameOfPublisher){
        if (nameOfPublisher.isEmpty()){
            publisher = "Unknown";
        }
        else {
            publisher=nameOfPublisher;
        }

    }

    public String getPublisher(){
        return publisher;
    }

    @Override
    public String toString(){
        return super.toString() + "\t Publisher: " + publisher;
    }


}
