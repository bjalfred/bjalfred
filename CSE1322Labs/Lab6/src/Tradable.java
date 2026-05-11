//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Assignment: Tradable

public class Tradable extends DigitalGood{
    protected int saleDelay=0;

    public Tradable(String nameOfItem, double priceOfItem, String nameOfDescription, int numOfDelay){
        super(nameOfItem,priceOfItem,nameOfDescription);
        saleDelay = numOfDelay;
        setSaleDelay(numOfDelay);
    }

    public int setSaleDelay(int numOfDelay) {
        if (numOfDelay>=0){
            saleDelay = numOfDelay;
            return saleDelay;
        }
        else {
            return saleDelay=0;
        }

    }

    public int getSaleDelay(){
        return saleDelay;
    }

    @Override
    public String toString(){
        return super.toString() +  "\n\t Item can only be sold after being owned for " + getSaleDelay() + " days" ;
    }
}
