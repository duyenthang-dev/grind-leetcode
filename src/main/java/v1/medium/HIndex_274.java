package v1.medium;

import java.util.*;
import java.util.stream.IntStream;

public class HIndex_274 {
    public int hIndex(int[] citations) {
        int[] reverseSorted = IntStream.of(citations).boxed()
                .sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
        int i = 0;
        for (; i < reverseSorted.length; i++) {
            if (reverseSorted[i] <= i)
                return i;
        }
        if (reverseSorted[0] == 0)
            return 0;
        return i;
    }
    public static void main(String[] args) {
        int[] citations = new int[] {0};
        System.out.println(new HIndex_274().hIndex(citations));
    }
}

//0 1 3 5 6