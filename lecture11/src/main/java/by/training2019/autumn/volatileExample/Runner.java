package by.training2019.autumn.volatileExample;

public class Runner {
    public static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Runnable whileFlagFalse = () -> {
            while(!flag) {
            }

            System.out.println("Flag is now TRUE");
        };

        new Thread(whileFlagFalse).start();

        Thread.sleep(1000);

        flag = true;
    }
}
