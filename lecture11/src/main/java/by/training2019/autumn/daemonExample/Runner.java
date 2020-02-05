package by.training2019.autumn.daemonExample;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        LOGGER.info(Thread.currentThread().getName());

        Thread daemon = new Thread(() -> { for(int i = 0; ; i++) {
            System.out.println("Daemon is running: " + i);

            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }});

        daemon.setDaemon(true);
        daemon.start();

        System.out.println("Main is finishing...");
    }
}