//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Assignment: Hybrid Car Class

public class HybridCar extends Car implements GasEngine, ElectricEngine{
    double maxBattery;
    double currentCharge;
    private double tankCapacity;
    private double currentVolume;

    HybridCar(double batteryCapacity, double presentCharge,double maxVolume, double presentVolume ){
        maxBattery=batteryCapacity;
        currentCharge=presentCharge;
        tankCapacity=maxVolume;
        currentVolume=presentVolume;
    }
    @Override
    public double rechargeBattery(double percent) {
        double storeCharge;
        if (percent>maxBattery || percent+currentCharge>maxBattery){
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
    public double refuelTank(double gallons){
        double storeGallons;
        if (gallons>tankCapacity || gallons+currentVolume>tankCapacity){
            storeGallons=tankCapacity-currentVolume;
            currentVolume=tankCapacity;
            return storeGallons  ;
        }
        else{
            currentVolume+=gallons;
            return gallons;
        }

    }

    @Override
    public double getTankCapacity(){
        return tankCapacity;

    }

    @Override
    public double getCurrentVolume(){

        return currentVolume;
    }

    @Override
    public String toString() {
        return "Car: " + id + " | Current Charge : " + currentCharge + "/" + maxBattery + " KW | Current Fuel : " + currentVolume + "/" + tankCapacity + " gals";
    }



}
