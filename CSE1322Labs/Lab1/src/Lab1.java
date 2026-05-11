//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab:1
import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {

        // entering the name
        System.out.println("[Budgeting System]");
        System.out.println(("Enter your name: "));
        Scanner scanner = new Scanner(System.in);
        String Name= scanner.next();
        System.out.print("Hello"+ " " +Name+".");

        // entering the salary
        System.out.print(" Please enter your monthly salary: ");
        int Salary= scanner.nextInt();
        System.out.println();

        // amount of loan and interest rates
        System.out.print("What is the total amount of your loan? ");
        double Loan= scanner.nextDouble();

        System.out.print("What is the interest rate of your loan? ");
        double Interest= scanner.nextDouble();

        // Calculating interest and Principal
        double perInterest= Interest/100;
        double Principal= Loan * (Math.pow(((1+(perInterest/12))),12));
        double YearlySalary= Salary*12;

        //printing out values
        System.out.println(("Your yearly salary is $" +" "+YearlySalary));
        System.out.println("In 12 months, your loan's principal will be $"+" "+ Math.round(Principal*100.0)/100.0);
        System.out.println();

        //Booleans
        System.out.print(("At the end of the year, you will have paid off your debt: "));
        System.out.print(YearlySalary>=Principal);
        System.out.println();

        System.out.print("At the end of the year, your will still have some debt left: ");
        System.out.print(YearlySalary<Principal);
        System.out.println();

        System.out.println("At the end of the year, you will have $" +Math.round(((YearlySalary-Principal)*100.0))/100.0 + "  of your salary left");

        //Loan Relief
        System.out.println("The government is offering loan relief for persons 25 and under, and for those 65 and over.");
        System.out.println("What is your age? ");
        int Age= scanner.nextInt();

        boolean validRelief= (Age<=25)||(Age>=65);
        System.out.println("The relief is $10000. You are eligible for the relief: "+ validRelief);
        boolean fullyPaid= (YearlySalary>Principal) || (validRelief &&((YearlySalary+10000)>Principal));
        System.out.println("With or without relief, you will be able to pay your loan in full: "+ fullyPaid);

        }
}