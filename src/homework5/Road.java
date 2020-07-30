package homework5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Road extends Stage {
    public static int getRoadCount() {
        return roadCount;
    }

    private static int roadCount;
    private CyclicBarrier cb;
    public Road(int length, CyclicBarrier cb) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
        this.cb = cb;

    }
    @Override
    public void go (Car c) {
        try {
            roadCount++;
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
//            if (roadCount == 5){
//                System.out.println(c.getName() + " WIN");
//                try {
//                    cb.await();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
//
//                return;
//            }
            System.out.println(c.getName() + " закончил этап: " + description);


            if((roadCount) > 4){
                try {
                    cb.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
