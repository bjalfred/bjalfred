public class GasCar extends Car implements GasEngine {
    private double tankCapacity;
    private double currentVolume;

    GasCar(double maxVolume, double presentVolume ){
        tankCapacity=maxVolume;
        currentVolume=presentVolume;
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
    public String toString(){
        return "Car: " + id + " | Current Fuel : " + currentVolume + "/" + tankCapacity + " gals";
    }
}
