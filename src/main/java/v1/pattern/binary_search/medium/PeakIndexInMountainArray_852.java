package v1.pattern.binary_search.medium;

public class PeakIndexInMountainArray_852 {
    public int peakIndexInMountainArray(int[] arr) {
        // f f f f f t t 
        int l = 0;
        int r = arr.length - 1;
        int idx = -1;
        while(l <= r) {
            int mid = (l + r)/2;
            // feasible function: arr[mid] >= arr[mid+1]
            if (arr[mid] >= arr[mid + 1]) {
                idx = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        
    }
}
