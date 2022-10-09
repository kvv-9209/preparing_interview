package hw2;

import java.util.concurrent.locks.ReentrantLock;

public class Count {
    ReentrantLock lock = new ReentrantLock();
    int count = 0;

    void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}
