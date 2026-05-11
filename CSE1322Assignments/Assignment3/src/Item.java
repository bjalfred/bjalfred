//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Assignment: Item

public class Item {
    protected int id;
    public static int nextID=0;
    protected double price;
    protected String name;

    public Item(String nameOfItem, double priceOfItem){
        id = nextID;
        nextID += 1;
        name = nameOfItem;
        setPrice(priceOfItem);
    }
    public int getID(){

        return id;
    }

    public void  setPrice(double priceOfItem){

        if (priceOfItem>=0){
            price=priceOfItem;
        }
        else{
            price=0;
        }

    }

    public double getPrice(){

        return price;
    }

    public void setName(String nameOfItem){
        name=nameOfItem;
    }

    public String getName(){
        return name;

    }

    @Override
    public String toString(){

        return "Item: " + name + " (#" + id + ") | Price: $" + getPrice() + "\n";
    }
}
