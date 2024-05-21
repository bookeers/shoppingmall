package exercise.etc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> sport_star = new ArrayList<>();

        sport_star.add("ABC");
        sport_star.add("DEF");
        sport_star.add("GHI");
        sport_star.add("JKL");
        sport_star.add("MNO");

        for (int i = 0; i < sport_star.size(); i++) {
            System.out.println(sport_star.get(i));
        }


        Map<Integer, String> fruits = new HashMap<>();
        fruits.put(1, "apple");
        fruits.put(2, "banana");
        fruits.put(3, "pineapple");
        fruits.put(4, "blueberry");
        fruits.put(5, "melon");

        Iterator<String> fruitIterator = fruits.values().iterator();

        while (fruitIterator.hasNext()) {

            System.out.println(fruitIterator.next());
        }
    }
}