package homework1.lesson3;

import java.util.ArrayList;

public class Box<T, F extends Number> {
    private T obj;
    private float weight;


    public Box(T obj, float weight) {
        this.obj = obj;
        this.weight = weight;

    }

    ArrayList<T> arrayList = new ArrayList<>();

    public void addFruit(T o){// метод добавляет объект в массив
        arrayList.add(o);

    }

    public float info(){ // метод возвращает размер массива

       return arrayList.size();
    }
    public float getWeight(){
        return arrayList.size() * weight;
    }
    // метод сравнивает 2 коробки
    public boolean compare(Box<?, Float> another ){
        return Math.abs(this.getWeight() - another.getWeight()) < 0.0001;
    }





}
