import java.util.Arrays;

public class Building {
    Tenant [] apartments;
    private static double balance=0;
    static int nextId=1;
    private  int id;

    public  Building(){

    }
    public Building(int numOfApartments){
        this.apartments= new Tenant[numOfApartments];
        this.id=nextId;
        nextId+=1;

    }

    public int getID() {

        return id;
    }

    public static double getBalance(){
        return balance;
    }

    public  int countTenants(){
        int numOfTenants=0;
        for (int i=0; i<apartments.length; i++ ){
            if (!(apartments[i]==null)){
               numOfTenants+=1;

            }
        }
        return numOfTenants;
    }
    public boolean addTenant(Tenant nameOftenant ,int numOfApartment){
        if((numOfApartment>=apartments.length)||(!(apartments[numOfApartment]==null))){
            return false;
        }
        else{
            apartments[numOfApartment]= nameOftenant;
            return true;
        }

    }
    public boolean removeTenant(int numOfApartment){

        if((numOfApartment>=apartments.length)||((apartments[numOfApartment]==null))){
            return false;
        }
        else{
            apartments[numOfApartment] = null;
            return true;
        }
    }

    public String listTenants() {
        String list = "";
        for (int i = 0; i < apartments.length; i++) {
            list+= "Apartment " + i + ": ";
            if (apartments[i] != null) {
                list += apartments[i].toString();
            } else {
                list += "Empty";
            }
            list += "\n";
        }
        return list;
    }

    Tenant getTenant(int numOfApartment){
        if (numOfApartment < 0 || numOfApartment >= apartments.length ){
        return null;
        }
       else {
            return  apartments[numOfApartment];
       }
    }

    static void collectRent(Tenant nameOfTenant){
       balance+=nameOfTenant.rent;

    }

    static void payForService(double servPrice){
        balance-=servPrice;

    }

}


