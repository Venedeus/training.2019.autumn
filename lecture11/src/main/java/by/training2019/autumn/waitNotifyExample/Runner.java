package by.training2019.autumn.waitNotifyExample;

public class Runner {
    public static void main(String[] args) {
        Store store = new Store();

        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

// Store class for storing goods
class Store{
    private int product = 0;
    public synchronized void get() {
        while (product < 1) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }

        product--;

        System.out.println("\tConsumer bought 1 item of goods");
        System.out.println("\tAmount of goods in a store: " + product);

        notify();
    }

    public synchronized void put() {
        while (product >= 3) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }

        product++;

        System.out.println("Producer added 1 item of goods");
        System.out.println("Amount of goods in a store: " + product);

        notify();
    }
}

// Producer class for filling a store with goods
class Producer implements Runnable{

    Store store;
    Producer(Store store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}
// Consumer class for getting goods
class Consumer implements Runnable{

    Store store;
    Consumer(Store store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}