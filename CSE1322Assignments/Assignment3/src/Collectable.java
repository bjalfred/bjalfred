//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Assignment: Collectable

public class Collectable extends DigitalGood {
    protected String collectType;

    public Collectable(String nameOfItem, double priceOfItem, String nameOfDescription, String typeOfCollect){
        super(nameOfItem,priceOfItem,nameOfDescription);
        setCollectType(typeOfCollect);
    }

    public void setCollectType(String typeOfCollect){
        typeOfCollect=typeOfCollect.toLowerCase();

        if (typeOfCollect.equals("emoticon") || typeOfCollect.equals("avatar") || typeOfCollect.equals("background") ){
            collectType = typeOfCollect;
        }
        else {
            collectType = "nothing";
        }
    }

    public String getCollectType(){
        return collectType;
    }

    @Override
    public String toString(){
        return super.toString() + "\n\t Can be used as " + collectType ;
    }
}
