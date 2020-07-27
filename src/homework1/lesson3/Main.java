package homework1.lesson3;

public class Main {
    private static final float APPLE_WEIGHT = 1.0f;
    private static final float ORANGE_WEIGHT = 1.5f;

    public static void main(String[] args) {
        Apple apple = new Apple(APPLE_WEIGHT);
        Orange orange = new Orange(ORANGE_WEIGHT);
        Box<Apple, Float> appleBox1 = new Box<>(apple, APPLE_WEIGHT);
        Box<Orange, Float> orangeBox1 = new Box<>(orange, ORANGE_WEIGHT);

        appleBox1.addFruit(apple);
        appleBox1.addFruit(apple);
        appleBox1.addFruit(apple);
        appleBox1.addFruit(apple);
        appleBox1.addFruit(apple);
        appleBox1.addFruit(apple);
        orangeBox1.addFruit(orange);
        orangeBox1.addFruit(orange);
        orangeBox1.addFruit(orange);
        orangeBox1.addFruit(orange);
        // orangeBox1.addFruit(orange);

        System.out.println(appleBox1.info());
        System.out.println(orangeBox1.info());
        System.out.println("Apple box " + appleBox1.getWeight());
        System.out.println("Orange box " + orangeBox1.getWeight());
        System.out.println("Apple w " + apple.getWeight());

        System.out.println(appleBox1.compare(orangeBox1));


    }


}



