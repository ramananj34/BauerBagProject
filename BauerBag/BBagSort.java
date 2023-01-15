//This class containts all of the sort methods

package BauerBag;

public final class BBagSort
{

    /**
     * Selection Sort
     * This is a common sort which starts from the beginning and goes through the array, constantly finding the smallest value, and puts it at the beginning
     * 
     * @param arr is the array you are sorting
     * @param startIndex is the lower bound of the range you are sorting
     * @param endIndex is the upper bound of the range you are sorting
     */
    public static void selectionSort(int[] arr, int startIndex, int endIndex)
    {
        for (int i = startIndex; i < arr.length && i <= endIndex; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length && j <= endIndex; j++) {
                if (arr[j] < arr[minIndex]) { minIndex = j; }
            }
            Helpers.swap(arr, i, minIndex);
        }
    }

    /**
     * Reverse Selection Sort
     * This sort reflects the regular selection sort by starting from the end and going through the array, constantly finding the biggest value and putting it at the end
     * 
     * @param arr is the array you are sorting
     * @param startIndex is the lower bound of the range you are sorting
     * @param endIndex is the upper bound of the range you are sorting
     */
    public static void reverseSelectionSort(int[] arr, int startIndex, int endIndex)
    {
        for (int i = endIndex; i >= 0 && i >=startIndex; i--) {
            int maxIndex = i;
            for (int j = i-1; j >=0 && j >=startIndex; j--) {
                if (arr[j] > arr[maxIndex]) { maxIndex = j; }
            }
            Helpers.swap(arr, i, maxIndex);
        }
    }

    /**
     * Bubble Sort
     * This sort waves through the array, swapping sets of values out of place until it goes through and doesn't need to swap anything
     * 
     * @param arr is the array you are sorting
     * @param startIndex is the lower bound of the range you are sorting
     * @param endIndex is the upper bound of the range you are sorting
     */
    public static void bubbleSort(int[] arr, int startIndex, int endIndex)
    {
        boolean swap;
        do {
            swap = false;
            for (int i = startIndex; i < endIndex && i < arr.length-1; i++) {
                if (arr[i] > arr[i+1]) {swap = true; Helpers.swap(arr, i, i+1);}
            }
        } while (swap);
    }

    /**
     * Reverse Bubble Sort
     * This sort follows the same logic as a regular bubble sort, just goes backwards instead of forwards
     * 
     * @param arr is the array you are sorting
     * @param startIndex is the lower bound of the range you are sorting
     * @param endIndex is the upper bound of the range you are sorting
     */
    public static void reverseBubbleSort(int[] arr, int startIndex, int endIndex)
    {
        boolean swap;
        do {
            swap = false;
            for (int i = endIndex; i > 0 && i > startIndex; i--) {
                if (arr[i] < arr[i-1]) {swap = true; Helpers.swap(arr, i, i-1);}
            }
        } while (swap);
    }

    /**
     * Insertion Sort
     * This sort goes through the array and for each value backtracks it to the right spot.
     * 
     * @param arr is the array you are sorting
     * @param startIndex is the lower bound of the range you are sorting
     * @param endIndex is the upper bound of the range you are sorting
     */
    public static void insertionSort(int[] arr, int startIndex, int endIndex) 
    {
        for (int i = startIndex+1; i < arr.length && i <= endIndex; i++) {
            int spot = i;
            while (spot > 0 && arr[spot] < arr[spot-1]) {Helpers.swap(arr, spot-1, spot); spot--;}
        }
    }

    /**
     * Reverse Insertion Sort
     * This sort follows the logic of the regular insertion sort but goes backwards instead of forwards
     * 
     * @param arr is the array you are sorting
     * @param startIndex is the lower bound of the range you are sorting
     * @param endIndex is the upper bound of the range you are sorting
     */
    public static void reverseInsertionSort(int[] arr, int startIndex, int endIndex) 
    {
        for (int i = endIndex-1; i >= 0 && i >= startIndex; i--) {
            int spot = i;
            while (spot < endIndex && spot < arr.length-1 && arr[spot] > arr[spot+1]) {Helpers.swap(arr, spot+1, spot); spot++;}
        }
    }

    //This class contains private local methods that might be of use.
    private static final class Helpers
    {
        /**
         * Swap method swaps to value of the array
         * 
         * @param arr Is the array in question
         * @param pos1 One value to swap
         * @param pos2 Another value to swap
         */
        private static void swap(int[] arr, int pos1, int pos2)
        {
            int temp = arr[pos1]; //Store the first value in a temp
            arr[pos1] = arr[pos2]; //Replace the first value with the second
            arr[pos2] = temp; //Replace the second value with the temp (or first value)
        }
    }
}