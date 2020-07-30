package homework5;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private static int CARS_COUNT;
    private Semaphore semaphore;
    public Tunnel(int CARS_COUNT, Semaphore semaphore) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.CARS_COUNT = CARS_COUNT;
        this.semaphore = semaphore;
    }
    @Override
    public void go(Car c) {


        try {

                try {
                    semaphore.acquire();
                    System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                    System.out.println(c.getName() + " начал этап: " + description);
                    Thread.sleep(length / c.getSpeed() * 1000);
                } catch (InterruptedException  e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(c.getName() + " закончил этап: " + description);
                    semaphore.release();
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


    }

}
