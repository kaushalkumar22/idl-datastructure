package array_google;

import java.util.TreeMap;

public class FloorTestConcept {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(39, 44);
        map.put(13, 49);
        map.put(47,50);
        System.out.println(map.floorKey(70));
    }
}
