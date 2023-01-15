//This class contains all of the Search methods

package BauerBag;

public final class BBagSearch
{
    /**
     * Sequential or Linear Search
     * This is the most common and basic search, starting from the beginning and going through each value
     * 
     * @param arr is the integer array in which the sort will take place
     * @param target is the number you are searching for
     * @param startIndex is the first index to look at
     * @param endIndex is the last index to look at
     * @return the index of the location of the target, or -1 if not found
     */
    public static int sequentialSearch(int[] arr, int target, int startIndex, int endIndex)
    {
        for (int i = startIndex; (i <=endIndex && i<arr.length); i++) { //For each index in the range (going forward)
            if (arr[i]==target) { return i; } //If the value at that index is the target, return that index
        }
        return -1; //If you didn't find the target, return -1
    }

    /**
     * Recursive Sequential or Linear Search
     * This is the same as a regular sequential search, but modified to acomplish the task recursivley. It is identical in performance to a regular sequential search
     * 
     * @param arr is the integer array in which the sort will take place
     * @param target is the number you are searching for
     * @param startIndex is the first index to look at
     * @param endIndex is the last index to look at
     * @return the index of the location of the target, or -1 if not found
     */
    public static int reverseSequentialSearch(int[] arr, int target, int startIndex, int endIndex)
    {
        for (int i = endIndex; (i >= 0 && i>=startIndex); i--) { //For each index in the range (going backward)
            if (arr[i]==target) { return i; } //If the value at that index is the target, return that index
        }
        return -1; //If you didn't find the target, return -1
    }

    /**
     * Reverse Sequential or Linear Search
     * Rather than starting from the beginning and going forward, this search starts at the last position and works its way backwards in a similar fasion.
     * 
     * @param arr is the integer array in which the sort will take place
     * @param target is the number you are searching for
     * @param startIndex is the first index to look at
     * @param endIndex is the last index to look at
     * @return the index of the location of the target, or -1 if not found
     */
    public static int recursiveSequentialSearch(int[] arr, int target, int startIndex, int endIndex)
    {
        if(startIndex>endIndex || startIndex>=arr.length) { //If the index you are currently searching exceeded the end of the range, it means you did not find the target
            return -1; //You did not find the target, so return -1
        } else if(arr[startIndex]==target) { //If the index you are on is the target
            return startIndex; //Return that index
        } else {
            return recursiveSequentialSearch(arr, target, startIndex+1, endIndex); //If you didn't find the target or exceed the range, then call the method again restricting the range going forward
        }
    }

    /**
     * Recursive Reverse Sequential or Linear Search
     * This is the same as a regular reverse sequential search, but modified to acomplish the task recursivley. It is identical in performance to a regular reverse sequential search
     * 
     * @param arr is the integer array in which the sort will take place
     * @param target is the number you are searching for
     * @param startIndex is the first index to look at
     * @param endIndex is the last index to look at
     * @return the index of the location of the target, or -1 if not found
     */
    public static int recursiveReverseSequentialSearch(int[] arr, int target, int startIndex, int endIndex)
    {
        if(endIndex<startIndex || endIndex<0) { //If the index you are currently searching exceeded the end of the range, it means you did not find the target
            return -1; //You did not find the target, so return -1
        } else if(arr[endIndex]==target) { //If the index you are on is the target
            return endIndex; //Return that index
        } else {
            return recursiveSequentialSearch(arr, target, startIndex, endIndex-1); //If you didn't find the target or exceed the range, then call the method again restricting the range going backward
        }
    }

    /**
     * Binary Search
     * This is a more complicated search that relies on a sorted array. It divides the range in two and checks which half contains the target. It then does the same with that half and again until you found your answer. 
     * 
     * @param arr is the integer array in which the sort will take place
     * @param target is the number you are searching for
     * @param startIndex is the first index to look at
     * @param endIndex is the last index to look at
     * @return the index of the location of the target, or -1 if not found
     */
    public static int binarySearch(int[] arr, int target, int startIndex, int endIndex)
    {
 
		while (startIndex <= endIndex) { //If the start index passed the end index, it means you did not find the target
			int midpointIndex = (startIndex+endIndex)/2; //In your range, find the middle point
			if (arr[midpointIndex] == target) { return midpointIndex; } //If the middle point is the target, return that index
			else if (arr[midpointIndex] < target) { startIndex = midpointIndex + 1; } //If the middle point is less than the target, it means the desired index is in the second half
			else { endIndex = midpointIndex-1; } //The desired index must now be in the first half
		}
		return -1; //If the start index passed the end index, it means you did not find the target
    }

    /**
     * Recursive Binary Search
     * This is the same as a regular binary search, but modified to acomplish the task recursivley. It is identical in performance to a regular binary search
     * 
     * @param arr is the integer array in which the sort will take place
     * @param target is the number you are searching for
     * @param startIndex is the first index to look at
     * @param endIndex is the last index to look at
     * @return the index of the location of the target, or -1 if not found
     */
    public static int recursiveBinarySearch(int[] arr, int target, int startIndex, int endIndex) 
    {
        if (startIndex > endIndex) { return -1; } //If the start index passed the end index, it means you did not find the target

        int midpointIndex = (startIndex+endIndex)/2; //In your range, find the middle point
        if (arr[midpointIndex] == target) { return midpointIndex; } //If the middle point is the target, return that index
		else if (arr[midpointIndex] < target) { return recursiveBinarySearch(arr,target,midpointIndex+1,endIndex);} //If the middle point is less than the target, it means the desired index is in the second half, so check there
		else { return recursiveBinarySearch(arr,target,startIndex,midpointIndex-1); } //The desired index must now be in the first half, so check there
    }
    
    /**
     * Discrete Search
     * This is a search I invented. How it works is the client gives us a step value. The program goes through the array with intervals of the step value, and if it passes the target, it traces its steps backwards to find it.
     * 
     * @param arr is the integer array in which the sort will take place
     * @param target is the number you are searching for
     * @param step is an integer representing how big your steps are through the array. The program steps through the array until it passes the target then backtracks to find its index.
     * @param startIndex is the first index to look at
     * @param endIndex is the last index to look at
     * @return the index of the location of the target, or -1 if not found
     */
    public static int discreteJudeSearch(int[] arr, int target, int step, int startIndex, int endIndex) 
    {
        endIndex = Math.min(endIndex,arr.length-1); //Id the user defined end index exceeds the array, make the end index the last index of the array
        step = Math.max(Math.min(step,2+(endIndex-startIndex)),1); //Make sure the step value is between 1 and the length of the array

        do {
            startIndex+=step; //Walk a step
        } while (startIndex < endIndex && target > arr[startIndex]); //If you are now passed the target or outside of the array, backtrack. If not, walk some more

        if (startIndex > endIndex) {startIndex = endIndex;} //If you went outside the array, go back to the end

        for (int i = 0; i < step; i++) { //Depending on how big your step is, start backtracking until you reached a spot you checked
            if (target == arr[startIndex-i]) {return startIndex-i;} //If you found the target, return that index. 
        }
        return -1; //If you backtrack to an arrea you checked, it means you did not find the target
    }

    /**
     * Polynomial Search
     * This is another search I invented. It extends the logic of binary and linear search to allow for searches of every level, tertiary, and more.
     * A linear search treats every index as a partition. A binary search divides it into two partitions. Here, you can let the user specify how many partitions they want. The program checks in which partition it is and then partitions that partition.
     * 
     * @param arr is the integer array in which the sort will take place
     * @param target is the number you are searching for
     * @param partitions is how many times you want to divide up the array when you search. 2 is a binary search, and if you put the length of the array it is a linear search.
     * @param startIndex is the first index to look at
     * @param endIndex is the last index to look at
     * @return the index of the location of the target, or -1 if not found
     */
    public static int polynomialJudeSearch(int[] arr, int target, int partitions, int startIndex, int endIndex)
    {
        endIndex = Math.min(endIndex,arr.length-1); //If the user defined end index excedes the length of the array, make the end index the length of the array
        partitions = Math.max(Math.min(partitions, endIndex-startIndex), 2); //Make the partitions between 2 and the length of the array
        
        int interval = (endIndex-startIndex)/partitions; //Sets the size of the partitions

        if (arr[startIndex] == target) {return startIndex;} //Checks the lower boundry of the first partition so we can neglect it in the loop

        for (int i = 1; i <= partitions; i++) { //For each partition

            int temp = startIndex + interval*i; //Set the value you are checking to the next partition
            if (i==partitions) { temp = endIndex; } //To solve rounding problems, if you are at the end, use that index

            if (target==arr[temp]) {return temp;} //If the partition is the value return it
            else if (target < arr[temp]) { //If the target is in the partition, then go into it
                return polynomialJudeSearch(arr, target, partitions, startIndex + 1 + (interval*(i-1)), temp-1); //Partition that partition recursivley
            }
        }
        return -1; //If you did not find it, return -1

    }

}