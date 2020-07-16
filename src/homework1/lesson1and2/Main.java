package homework1.lesson1and2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String s[] = new String[10];
        for (int i = 0; i < 10 ; i++) {
            s[i] = "Элемент " + i ;
        }
        for (int i = 0; i <s.length ; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();

        arrSwapElement(s, 5, 2);

        for (int i = 0; i <s.length ; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();
        System.out.println(" Второе задание " + arrInList(s));

    }
    private static void arrSwapElement(Object[] obj, int i, int j){
       Object a = obj[i];
       Object b = obj[j];

       obj[j] = a;
       obj[i] = b;
    }
    private static <T> ArrayList<T> arrInList(T[] obj){
        ArrayList<T> arrayList = new ArrayList<>();
        for (int i = 0; i <obj.length ; i++) {
            arrayList.add(obj[i]);
        }
        return arrayList;
    }

}
