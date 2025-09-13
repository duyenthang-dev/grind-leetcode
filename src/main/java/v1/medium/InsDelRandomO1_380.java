package v1.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * to get O(1) when insert or remove elm, we have to use map to store postition of the emlement that was insert to list
 * by that way we can know position when remove an elm without loop through the array with O(N)
 */

public class InsDelRandomO1_380 {
    private List<Integer> lst;
    private HashMap<Integer, Integer> map;
    private final Random rnd = new Random();

    public InsDelRandomO1_380() {
        lst = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, lst.size());
        lst.add(val);
        return true;
    }

    // [8, 4, 3, 2]
    // [{8, 0}, {4, 1}, {3, 2}, {2, 3}]
    // v = 4
    // -> after
    // [8, 2, 3]
    // [{8, 0}, {3, 2}, {2, 1}]
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int last = lst.get(lst.size() - 1); // last = 2
        lst.set(map.get(val), last); // lst = [8, 2, 3, 2]
        lst.remove(lst.size() - 1); // lst = [8, 2, 3]
        map.put(last, map.get(val)); //  [{8, 0}, {4, 1}, {3, 2}, {2, 1}]
        map.remove(val);//  [{8, 0}, {3, 2}, {2, 1}]
        return true;
    }

    public int getRandom() {
        return lst.get(rnd.nextInt(lst.size()));
    }

    public static void main(String[] args) {
        InsDelRandomO1_380 obj = new InsDelRandomO1_380();
        boolean boolValue = obj.insert(1);
        boolValue = obj.remove(2);
        boolValue = obj.insert(2);
        int intValue = obj.getRandom();
        boolValue = obj.remove(1);
        boolValue = obj.insert(2);
        intValue = obj.getRandom();
    }
}
