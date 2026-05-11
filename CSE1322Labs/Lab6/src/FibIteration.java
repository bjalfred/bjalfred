//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab: Fib Iteration Class

public class FibIteration implements FindFib {
    private int x=1;
    private int y=0;
    private int temp;
    private int count=0;
    private int temp2;

    @Override
    public int calculateFib(int fibNumber){
        if (fibNumber==0){
            return 0;
        }
        else if (fibNumber==1){
            return 1;
        }
        else if(fibNumber>=2)
           do {
               temp=x+y;
               temp2=x;
               x=temp;
               y=temp2;
               count+=1;
           }while(count != fibNumber-1);
           return temp;

    }
}
