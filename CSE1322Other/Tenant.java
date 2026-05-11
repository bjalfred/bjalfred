public class Tenant {
    public String name;
    public double rent;
    public int age;

    public Tenant(String n , int a, double r ){
        name=n;
        rent=r;
        age=a;
    }

    public String toString() {
        return name+" ("+age+") | $" +rent +"/mo" ;

    }
}
