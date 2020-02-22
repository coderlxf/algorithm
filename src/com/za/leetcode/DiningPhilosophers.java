package com.za.leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {
    private ReentrantLock[] locks = new ReentrantLock[]{
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock()
    };
//    private ReentrantLock pickBothForks = new ReentrantLock();
    private Semaphore eatLimit = new Semaphore(4);

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftFork = (philosopher + 1) % 5;
        int rightFork = philosopher;
        eatLimit.acquire();
//        pickBothForks.lock();
        locks[leftFork].lock();
        locks[rightFork].lock();
        pickLeftFork.run();
        pickRightFork.run();
//        pickBothForks.unlock();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        locks[leftFork].unlock();
        locks[rightFork].unlock();
        eatLimit.release();
    }
}
