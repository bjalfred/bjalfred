//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Assignment: Development Kit

import java.util.ArrayList;

public class DevelopmentKit extends Software{
    protected ArrayList<String> targetPlatform;
    public ArrayList<String> newTargets;

    public DevelopmentKit(String nameOfItem, double priceOfItem, String nameOfPublisher,ArrayList<String> newTargets){
        super(nameOfItem,priceOfItem,nameOfPublisher);
        setTargetPlatform(newTargets);
    }
    public void setTargetPlatform(ArrayList<String> newTargets){
        if (newTargets==null ||newTargets.isEmpty()){
            newTargets.add("None");
            targetPlatform=newTargets;
        }
        else{
            targetPlatform=newTargets;
        }
    }
    public ArrayList<String> getTargetPlatform(){
        return targetPlatform;
    }

    @Override
    public String toString(){
        String list = "";
        for (int i = 0; i < targetPlatform.size(); i++) {
            list+= targetPlatform.get(i);
            list +="\n";
        }

        return super.toString() + "\n\t Target Platform: " + "\n\t" +list;
    }
}
