package homework5;

import java.util.concurrent.*;

public class Main {
    public static final int CARS_COUNT = 4;
    public static int count = 0;
    public static int roadCount = 0;
    public static CyclicBarrier cb = new CyclicBarrier(CARS_COUNT+1);
    public static Semaphore semaphore = new Semaphore(CARS_COUNT/2);

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60, cb), new Tunnel(CARS_COUNT, semaphore), new Road(40, cb));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cb);
        }

        for (int i = 0; i < cars.length; i++) {
                new Thread(cars[i]).start();
            }

        try {
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        try {
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");


    }



}
