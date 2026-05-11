//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Assignment: Electric Car Class

public class ElectricCar extends Car implements ElectricEngine {
    double maxBattery;
    double currentCharge;

    ElectricCar(double batteryCapacity, double presentCharge){
        maxBattery=batteryCapacity;
        currentCharge=presentCharge;
    }

    @Override
    public double rechargeBattery(double percent) {
        double storeCharge;
        if (percent>maxBattery || percent+currentCharge >maxBattery){
            storeCharge=maxBattery-currentCharge;
            currentCharge=maxBattery;
            return storeCharge  ;
        }
        else{
            currentCharge+=percent;
            return percent;
        }

    }
    @Override
    public double getMaxBattery(){
        return maxBattery;

    }

    @Override
    public double getCurrentCharge(){

        return currentCharge;
    }

    @Override
    public String toString() {
        return "Car: " + id + " | Current Charge : " + currentCharge + "/" + maxBattery + " KW";
    }

}
