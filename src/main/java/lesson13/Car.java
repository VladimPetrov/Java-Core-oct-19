package lesson13;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private static int CARS_WINNER = 0;
    private static boolean CARS_PREPARATION = true;
    private static boolean CARS_FINISHED = true;
    private static CyclicBarrier cb;
    private static Lock lock = new ReentrantLock();

    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cb = new CyclicBarrier(CARS_COUNT);
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        if(CARS_PREPARATION){
            CARS_PREPARATION = false;
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        lock.lock();
        if (CARS_WINNER == 0) {
            System.out.println(this.name + " WINNER!!!!");
            this.CARS_WINNER = CARS_COUNT;
        }
        lock.unlock();
        try {
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        if(CARS_FINISHED) {
            CARS_FINISHED = false;
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
    }
}
