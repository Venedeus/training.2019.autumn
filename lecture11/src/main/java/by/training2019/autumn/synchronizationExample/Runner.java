package by.training2019.autumn.synchronizationExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    private int balance = 50;
    private int sum = 0;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public static void main(String[] args) throws InterruptedException {
        Runner account = new Runner();

        Thread fred = new Thread(account);
        Thread lucy = new Thread(account);

        fred.setName("Fred");
        lucy.setName("Lucy");

        lucy.start();
        fred.start();

        fred.join();
        lucy.join();

        LOGGER.info("------------------------------------------------");
        LOGGER.info("Balance is: " + account.balance);
        LOGGER.info("Sum: " + account.sum);
    }

    public void run() {
        for (int x = 0; x < 5; x++) {
            makeWithdrawal(10);

            if (getBalance() < 0) {
                LOGGER.info("account is overdrawn!");
            }
        }
    }

    private synchronized void makeWithdrawal(int amount) {
        if (getBalance() >= amount) {
            LOGGER.info(Thread.currentThread().getName()
                    + " is going to withdraw");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            withdraw(amount);
            sum += amount;
            LOGGER.info(Thread.currentThread().getName()
                    + " completes the withdrawal. The balance is "
                    + getBalance());
            LOGGER.info("Sum is: " + sum);
        } else {
            LOGGER.error("Not enough in account for "
                    + Thread.currentThread().getName()
                    + " to withdraw " + getBalance());
        }
    }
}
