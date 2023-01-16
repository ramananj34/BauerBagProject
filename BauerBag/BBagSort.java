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

    /**
     * Merge Sort
     * This is a slightly more complicated sort that works by breaking down an array and then building it back up in order
     * 
     * @param arr is the array you are sorting
     * @param startIndex is the lower bound of the range you are sorting
     * @param endIndex is the upper bound of the range you are sorting
     */
    public static void mergeSort(int[] arr, int startIndex, int endIndex) 
    {
        int[] tempArr = new int[arr.length]; //To perform this, we need a temporary array so we don't overide data. You will see why
        breakDown(arr,startIndex,endIndex,tempArr); //The first step is to break down the array. The recombination occurs recursivly
    }

    //Helper method to break down arrays for a merge sort
    private static void breakDown(int[] arr, int startIndex, int endIndex, int[] tempArr)
    {
        if (startIndex >= endIndex) {return;} //If the indexes are equal, you know you have broken it down enough

        breakDown(arr, startIndex, (startIndex+endIndex)/2, tempArr); //Break down the first half
        breakDown(arr, 1+((startIndex+endIndex)/2), endIndex, tempArr); //Break down the second half
        recombine(arr, startIndex, endIndex, tempArr); //Recombine the first and second half
    }

    //Helper method to reconstruct the array for a merge sort
    private static void recombine(int[] arr, int startIndex, int endIndex, int[] tempArr)
    {

        int middle = ((startIndex + endIndex)/2); //Gets us the middle point, or where the halfs were
        //How this works is by having two indexes, one for the first half, one for the second. As we go through the broken arrays, we increment these
        int secondHalfIndex = middle+1; //Index for the first half
        int firstHalfIndex = startIndex; //Index for the second half

        for (int i = startIndex; i <= endIndex; i++) { //For each value we are recombining
            if (firstHalfIndex>middle) //If the first half index passes the middle, we know it goes in the second half
				tempArr[i] = arr[secondHalfIndex++]; //Put the value in the second half and move up that index
			else if (secondHalfIndex > endIndex) //If the second half index passes the range, take the first half index
				tempArr[i] = arr[firstHalfIndex++]; //Puts the value in the first half and moves on
			else if (arr[firstHalfIndex] < arr[secondHalfIndex]) //If the value of the first half index is less than the second half, take the value from the first half
				tempArr[i] = arr[firstHalfIndex++]; //Does above
			else //If all else fails, use the second half index
				tempArr[i] = arr[secondHalfIndex++]; //Uses the second half index
        }

        for (int i = startIndex; i <= endIndex; i++) { //Copy the values from the temp array back to the origional
			arr[i] = tempArr[i];
		}
    }

    //This class contains private local methods that might be of use.
    private static final class Helpers
    {
        //Helper method to swap locations of an array
        private static void swap(int[] arr, int pos1, int pos2)
        {
            int temp = arr[pos1]; //Store the first value in a temp
            arr[pos1] = arr[pos2]; //Replace the first value with the second
            arr[pos2] = temp; //Replace the second value with the temp (or first value)
        }
    }
}