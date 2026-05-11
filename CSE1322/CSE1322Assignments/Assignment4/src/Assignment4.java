//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Assignment: Assignment 4

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Assignment4 {
    public static void main(String[] args) {
        ArrayList<Car> listOfCars = new ArrayList<>();
        ArrayList<Car> gasCars= new ArrayList<>();
        ArrayList<Car> eleCars= new ArrayList<>();

        Random gallons = new Random();
        Random percent = new Random();
        Scanner scanner= new Scanner(System.in);

        boolean running = true;

        double balance = 0;

        System.out.print("[The Refueler Station]");

        while(running){

            System.out.println("""
             1. Add gas car
             2. Add electric car
             3. Add hybrid car
             4. Refuel all gas engines
             5. Recharge all electric engines
             6. Refuel and recharge all vehicles
             7. Display all vehicles
             8: Dispatch all vehicles
             9. Quit""");

            System.out.println("Gas: $4.00/gal | Electricity: $0.20/kW");
            System.out.println("Enter Option: ");
            int Option= scanner.nextInt();

            switch(Option) {
                case 1:
                    int tankCapacity = gallons.nextInt(16) + 15;
                    int currentVol = gallons.nextInt(13) + 2;

                    Car gasCar = new GasCar(tankCapacity, currentVol);

                    listOfCars.add(gasCar);

                    System.out.println("Vehicle " + gasCar.getID() + " has parked at pump");
                    break;
                case 2:
                    int maxBattery = percent.nextInt(61) + 40;
                    int currentCha = percent.nextInt(29) + 2;

                    Car eleCar = new ElectricCar(maxBattery, currentCha);

                    listOfCars.add(eleCar);

                    System.out.println("Vehicle " + eleCar.getID() + " has parked at charger");
                    break;
                case 3:
                    maxBattery = percent.nextInt(61) + 40;
                    currentCha = percent.nextInt(29) + 2;
                    tankCapacity = gallons.nextInt(16) + 15;
                    currentVol = gallons.nextInt(13) + 2;

                    Car hybCar = new HybridCar(maxBattery, currentCha, tankCapacity, currentVol);

                    listOfCars.add(hybCar);

                    System.out.println("Vehicle " + hybCar.getID() + " has parked at pump-charger");
                    break;
                case 4:
                    for (int i = 0; i < listOfCars.size(); i++) {
                        if (listOfCars.get(i) instanceof GasEngine) {
                            gasCars.add(listOfCars.get(i));
                        }
                    }

                    for (int i = 0; i < gasCars.size(); i++) {
                        if (gasCars.get(i) instanceof GasCar) {
                            GasCar refuel = (GasCar) gasCars.get(i);
                            balance += refuel.refuelTank(30) * 4;
                        } else if (gasCars.get(i) instanceof HybridCar) {
                            HybridCar refeulCar = (HybridCar) gasCars.get(i);
                            balance += refeulCar.refuelTank(30) * 4;
                        }

                    }

                    for (int i=0; i<gasCars.size(); i++){
                        gasCars.remove(gasCars.get(i));
                    }

                    System.out.println("All gas vehicles refueled. Current balance is $" + balance);

                    break;
                case 5:
                    for (int i = 0; i < listOfCars.size(); i++) {
                        if (listOfCars.get(i) instanceof ElectricEngine) {
                            eleCars.add(listOfCars.get(i));
                        }
                    }

                    for (int i = 0; i < eleCars.size(); i++) {
                        if (eleCars.get(i) instanceof ElectricCar) {
                            ElectricCar recharge = (ElectricCar) eleCars.get(i);
                            balance += recharge.rechargeBattery(100) * .20;
                        } else if (eleCars.get(i) instanceof HybridCar) {
                            HybridCar rechargeCar = (HybridCar) eleCars.get(i);
                            balance += rechargeCar.rechargeBattery(100) * .20;
                        }

                    }

                    for (int i=0; i<eleCars.size(); i++){
                        eleCars.remove(eleCars.get(i));
                    }

                    System.out.println("All electric vehicles recharged. Current balance is $" + balance);
                    break;
                case 6:
                    for (int i = 0; i < listOfCars.size(); i++) {
                        if (listOfCars.get(i) instanceof GasEngine) {
                            gasCars.add(listOfCars.get(i));
                        }
                        if (listOfCars.get(i) instanceof ElectricEngine) {
                            eleCars.add(listOfCars.get(i));
                        }
                    }

                    for(int i=0; i<gasCars.size(); i++) {
                        if (gasCars.get(i) instanceof GasCar) {
                            GasCar refuel = (GasCar) gasCars.get(i);
                            balance += refuel.refuelTank(30) * 4;
                        } else if (gasCars.get(i) instanceof HybridCar) {
                            HybridCar refeulCar = (HybridCar) gasCars.get(i);
                            balance += refeulCar.refuelTank(30) * 4;
                        }
                    }
                    for(int i=0; i<eleCars.size(); i++) {
                        if (eleCars.get(i) instanceof ElectricCar) {
                            ElectricCar recharge = (ElectricCar) eleCars.get(i);
                            balance += recharge.rechargeBattery(100) * .20;
                            }
                        else if (eleCars.get(i) instanceof HybridCar) {
                            HybridCar rechargeCar = (HybridCar) eleCars.get(i);
                            balance += rechargeCar.rechargeBattery(100) * .20;
                            }
                        }

                    for (int i=0; i<eleCars.size(); i++){
                        eleCars.remove(eleCars.get(i));
                    }

                    for (int i=0; i<gasCars.size(); i++){
                        gasCars.remove(gasCars.get(i));
                    }

                    System.out.println("All vehicles refueled and recharged. Current balance is $" + balance);

                    break;
                case 7:
                    for(int i=0; i<listOfCars.size(); i++){
                        System.out.println(listOfCars.get(i).toString());
                    }
                    break;
                case 8:
                   listOfCars.clear();
                    System.out.println("All vehicles have left.");
                    break;

                case 9:
                    System.out.println("We've made a total of $" + balance + " today");
                    System.out.println("Shutting off...");
                    running=false;
            }

        }





    }
}