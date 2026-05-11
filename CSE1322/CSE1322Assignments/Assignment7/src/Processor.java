public class Processor extends Thread {
    public static int nextId=1;
    int id;
    Inventory Queue;
    int numberOfOrders;
    double revenue;

    public Processor(Inventory nameOfQueue ){
        numberOfOrders=0;
        id=nextId;
        nextId+=1;
        Queue= nameOfQueue;
    }

    @Override
    public void run(){
        System.out.println("OrderProcessor " + id + " starting order processing...");

        while (true){
            Item nameOfItem= Queue.retrieveItem();
            if(nameOfItem==null){
                break;
            }
            Queue.incrementBalance(nameOfItem.cost);
            numberOfOrders+=1;
            revenue+=(nameOfItem.cost);
        }
        System.out.println("OrderProcessor " + id + " processed a total of " + numberOfOrders + " orders for a total of $" + revenue);
    }
}
