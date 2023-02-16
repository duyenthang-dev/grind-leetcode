package easy;

public class Problem69 {
    public static int mySqrt(int x) {
        if (x == 0)
            return 0;
        if (x < 4)
            return 1;
        long i =0;
        for (; i < x; i++) {
            if (i * i >= (long) x) {
                if (i * i == (long) x)
                    return (int)i;
                return (int)i -1;
            }
        }
        return (int)i;
    }
    public static void main(String[] args) {
        System.out.println(Problem69.mySqrt(2147483647));
    }
}
