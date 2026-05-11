public class Purchaser extends Thread {
    public static int nextId=1;
    int id;
    int itemsProcessed;
    int itemsToProcess;
    Inventory Queue;
    Item item;

    public Purchaser (Inventory startQueue, Item typeOfItems, int needtoProcess ){
        id=nextId;
        nextId+=1;
        itemsToProcess=needtoProcess;
        item=typeOfItems;
        Queue= startQueue;
        itemsProcessed=0;
    }
    @Override
    public void run(){
        System.out.println("Purchaser " + id + " starting purchases...");


        while(itemsToProcess!=0){
            Queue.addItem(item);
            itemsToProcess-=1;
            itemsProcessed+=1;
        }

        System.out.println(id+ " purchased " + itemsProcessed + " '" + item.description + "' .");
    }
}
