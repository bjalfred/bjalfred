import java.util.LinkedList;

public class Inventory {
    private double balance = 0;
    private int itemsProcessed = 0;
    public LinkedList<Item> processingQueue = new LinkedList<>();

    public synchronized void addItem(Item nameOfItem) {
        processingQueue.add(nameOfItem);
    }

    public synchronized Item retrieveItem() {
        if (processingQueue.isEmpty()) return null; // Avoid NoSuchElementException
        itemsProcessed += 1;
        return processingQueue.removeFirst();
    }

    public synchronized void incrementBalance(double addToBalance) {
        balance += addToBalance;
    }

    public synchronized double retrieveBalance() {
        return balance;
    }

    public synchronized int getQueueSize() {
        return processingQueue.size();
    }

    public synchronized int getItemsProcessed() {
        return itemsProcessed;
    }
}