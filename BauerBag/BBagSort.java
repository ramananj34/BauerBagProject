//This class containts all of the sort methods

package BauerBag;

import java.util.Random; //Necessary for shuffle method in Bogo Sort

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
        for (int i = startIndex; i <= endIndex; i++) {
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
        for (int i = endIndex; i >=startIndex; i--) {
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
            for (int i = startIndex; i < endIndex; i++) {
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
            for (int i = endIndex; i > startIndex; i--) {
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
        for (int i = startIndex+1; i <= endIndex; i++) {
            int spot = i;
            while (spot > startIndex && arr[spot] < arr[spot-1]) {Helpers.swap(arr, spot-1, spot); spot--;}
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
        for (int i = endIndex-1; i >= startIndex; i--) {
            int spot = i;
            while (spot < endIndex && arr[spot] > arr[spot+1]) {Helpers.swap(arr, spot+1, spot); spot++;}
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
        int[] tempArr = new int[endIndex-startIndex+1]; //To perform this, we need a temporary array so we don't overide data. You will see why
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
				tempArr[i-startIndex] = arr[secondHalfIndex++]; //Put the value in the second half and move up that index
			else if (secondHalfIndex > endIndex) //If the second half index passes the range, take the first half index
				tempArr[i-startIndex] = arr[firstHalfIndex++]; //Puts the value in the first half and moves on
			else if (arr[firstHalfIndex] < arr[secondHalfIndex]) //If the value of the first half index is less than the second half, take the value from the first half
				tempArr[i-startIndex] = arr[firstHalfIndex++]; //Does above
			else //If all else fails, use the second half index
				tempArr[i-startIndex] = arr[secondHalfIndex++]; //Uses the second half index
        }

        for (int i = startIndex; i <= endIndex; i++) { //Copy the values from the temp array back to the origional
			arr[i] = tempArr[i-startIndex];
		}
    }

    /**
     * Lomuto Quick Sort
     * This is a simplified version of the real quick sort (the Hoare Quick Sort) that takes the last element and puts all the elements less than it before it and the ones greater after it. Then it sorts the two arrays created by that partition.
     * 
     * @param arr is the array you are sorting
     * @param startIndex is the lower bound of the range you are sorting
     * @param endIndex is the upper bound of the range you are sorting
     */
    public static void lomutoQuickSort(int[] arr, int startIndex, int endIndex) 
    {
        if (startIndex < endIndex) { //If the start index is less than the end index, there is sorting to be done
            int partitionIndex = lomutoPartition(arr,startIndex,endIndex); //Partition the data by putting the elements less than it before it and the ones greater than it after it. partitionIndex is now the index of the origional pivot
            lomutoQuickSort(arr,startIndex,partitionIndex-1); //Sort the data before it
            lomutoQuickSort(arr,partitionIndex+1,endIndex); //Sort the data after it
        }
    }

    //Helper method to partition the Lomuto Quick Sort
    private static int lomutoPartition(int[] arr, int startIndex, int endIndex) 
    {
        //We assume the pivot is the last element of the array, it makes no differance

        int smallerIndex = startIndex-1; //Sets the index of the array less than it to one less than the start index

        for (int i = startIndex; i <= endIndex-1; i++) { //For each element in question
            if (arr[i] <= arr[endIndex]) { //If that element is less than the pivot
                smallerIndex++; //Increment the smaller index
                Helpers.swap(arr,smallerIndex,i); //Swap it with the element you are on
            }
        }

        Helpers.swap(arr,endIndex,smallerIndex+1); //Swap the pivot with where you ended to put the pivot in the right spot
        return smallerIndex+1; //Return the location of the pivot
    }

    /**
     * Hoare Quick Sort
     * This sort works in a more efficient manner than the Lomuto Quick Sort. But to make the partitions, rather than manually deciding for each one if it is greater than or less than, it finds two that are out of place and swaps them until it doesn't need to. Then it positions the pivot and does the same thing to the two sides. 
     * 
     * @param arr is the array you are sorting
     * @param startIndex is the lower bound of the range you are sorting
     * @param endIndex is the upper bound of the range you are sorting
     */
    public static void hoareQuickSort(int[] arr, int startIndex, int endIndex) 
    {
        if (startIndex < endIndex) { //If the start index is less than the end index, there is sorting to be done. 
            int partitionIndex = hoarePartition(arr,startIndex,endIndex); //Partition the data and store the location of the pivot
            hoareQuickSort(arr,startIndex,partitionIndex-1); //Sort everything before the partition
            hoareQuickSort(arr,partitionIndex+1,endIndex); //Sort everything after the partition
        }
    }

    //Helper method to partition the Hoare Quick Sort
    private static int hoarePartition(int[] arr, int startIndex, int endIndex)
    {
        //Assumes the pivot is the first element, it makes no differance
        int smallerIndex = startIndex-1; //Starts at the beginning
        int biggerIndex = endIndex+1; //Starts at the end

        while (true) { //Does this until the two index's go passed eachover

            do { //This loop moves the smaller index to the first element that is bigger than the pivot, going from the start
                smallerIndex++;
            } while (arr[smallerIndex] < arr[startIndex]);

            do { //This loop moves the bigger index to the first element that is less than the pivot, going from the end
                biggerIndex--;
            } while (arr[biggerIndex] > arr[startIndex]);

            if (smallerIndex >= biggerIndex) { return biggerIndex;} //If they went passed eachover, return the bigger index, which is now the location of the pivot

            Helpers.swap(arr, smallerIndex, biggerIndex); //Swap them so they are in the right spot relative to eachover

        }
    }

    /**
     * Bogo Sort
     * This is a fairley inneficient sort that generates random permutations of the array until it finds one that is sorted
     * 
     * @param arr is the array you are sorting
     * @param startIndex is the lower bound of the range you are sorting
     * @param endIndex is the upper bound of the range you are sorting
     */
    public static void BogoSort(int[] arr, int startIndex, int endIndex) 
    {
        while (!Helpers.isSorted(arr,startIndex,endIndex)) { //While the array is not sorted
            Helpers.shuffle(arr, startIndex, endIndex); //Get a random permutation of the array
        }
    }

    /**
     * Heap Sort
     * This sort works by turning the array into a heap, and using the properties of a heap to sort it. It is hard to explain without looking at the code. 
     * 
     * @param arr is the array you are sorting
     * @param startIndex is the lower bound of the range you are sorting
     * @param endIndex is the upper bound of the range you are sorting
     */
    public static void heapSort(int[] arr, int startIndex, int endIndex) {

        Helpers.buildMaxHeap(arr,startIndex,endIndex); //First, turn the array into a heap

        for (int i = endIndex; i > startIndex; i--) { //For each value
            Helpers.swap(arr,startIndex,i); //Put the first node at the end because it is the biggest
            Helpers.reMaxHeap(arr, i, startIndex); //Make a new heap without the node you just sorted
        }
    }

    //Sorts left: Bucket, Counting, Radix (LSD, MSD), Shell, Cocktail Shaker, Gnome, Bitonic, introsort, Stable

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

        //Helper method to shuffle an array
        private static void shuffle(int[] arr, int startIndex, int endIndex) 
        {
            Random rand = new Random(); //Make a new random maker

            for (int i = startIndex; i <= endIndex; i++) { //For each element
                int newIndex = startIndex + rand.nextInt(1+endIndex-startIndex); //Give it a random new index
                swap(arr,i,newIndex); //Swap the element with its random new position
            }
        }

        //Helper method to check if an array is sorted
        private static boolean isSorted(int[] arr, int startIndex, int endIndex)
        {
            for (int i = startIndex; i < endIndex; i++) { //For each element
                if (arr[i] > arr[i+1]) { return false; } //If it is bigger than the element after it, return false
            }
            return true; //If you get to the end, return true
        }
    
        //Helper method to turn a array into a Max Heap
        private static void buildMaxHeap(int[] arr, int startIndex, int endIndex) 
        {
            int size = 1 + (endIndex-startIndex); //Gets the size of the array

            for (int i = startIndex + (size / 2 - 1); i >= startIndex; i--) { //Sorting the first half of the array does it all, so for each value in the first half
                Helpers.reMaxHeap(arr, size, i); //Call the heap maker below
            }
        }

        //Helper method to turn an array into a Max Heap. We call this when we know that the heap is already pretty much a Max Heap because it is not efficient to call the method above. This one has assumptions to make it faster. 
        private static void reMaxHeap(int[] arr, int size, int startIndex)
        {
            int largest = startIndex; //Assumes the first node is the biggest one
            int l = 2 * startIndex + 1; //Gets the left child
            int r = 2 * startIndex + 2; //Gets the right child

            if (l < size && arr[l] > arr[largest]) {
                largest = l; //If the left child is larger than the root, swap the index's
            }
            if (r < size && arr[r] > arr[largest]) {   
                largest = r; //If the right child is larger than the root, swap the index's
            }

            if (largest != startIndex)  { //If we swapped the indexes
                Helpers.swap(arr,startIndex,largest); //Swap the largets with the root node
                Helpers.reMaxHeap(arr, size, largest); //Re-heap the branches
            }
        }

    }

}