package hw2;

import java.util.Objects;

public class PingPong {

    private final String pong = "pong";
    private final Object object = new Object();
    private volatile String current = "ping";


    public static void main(String[] args) throws InterruptedException {

        PingPong pingPong = new PingPong();
        Thread thread1 = new Thread(pingPong::printPing);
        Thread thread2 = new Thread(pingPong::printPong);
        thread1.start();
        thread2.start();
    }

    public void printPing() {
        synchronized (object) {
            try {
                for (int i = 0; i < 10; i++) {
                    String ping = "ping";
                    while (!Objects.equals(current, ping)) {
                        object.wait();
                    }
                    System.out.print(ping);
                    current = pong;
                    object.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printPong() {
        synchronized (object) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (!Objects.equals(current, pong)) {
                        object.wait();
                    }
                    System.out.print(pong);
                    object.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

