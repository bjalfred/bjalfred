//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab: FibFormula Class
public class FibFormula implements FindFib{

    @Override
    public int calculateFib(int fibNumber) {
        double rtFive= Math.sqrt(5);
        double goldenRatio= (1+rtFive)/2;
        double goldenConjugate= (1-rtFive)/2;

        double fibonacci= (Math.pow(goldenRatio,fibNumber)-Math.pow(goldenConjugate,fibNumber))/rtFive;

        int fibInt= (int) Math.floor(fibonacci);
        return fibInt;
    }
}
