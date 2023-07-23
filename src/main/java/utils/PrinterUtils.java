package utils;

public class PrinterUtils<T> {
    public String printArray(T[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < arr.length; i++) {
            if (arr.length != i)
                sb.append(arr[i]).append(", ");
            else
                sb.append(arr[i]).append(" ]");
        }
        return sb.toString();
    }
}
