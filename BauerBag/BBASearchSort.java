package BauerBag;

public final class BBASearchSort
{

    public static int sequentialSearch(int[] arr, int target, int startIndex, int endIndex)
    {
        for (int i = startIndex; (i <=endIndex && i<arr.length); i++) {
            if (arr[i]==target) { return i; }
        }
        return -1;
    }

    public static int reverseSequentialSearch(int[] arr, int target, int startIndex, int endIndex)
    {
        for (int i = endIndex; (i >= 0 && i>=startIndex); i--) {
            if (arr[i]==target) { return i; }
        }
        return -1;
    }

    public static int recursiveSequentialSearch(int[] arr, int target, int startIndex, int endIndex)
    {
        if(startIndex>endIndex || startIndex>=arr.length) {
            return -1;
        } else if(arr[startIndex]==target) {
            return startIndex;
        } else {
            return recursiveSequentialSearch(arr, target, startIndex+1, endIndex);
        }
    }

    public static int recursiveReverseSequentialSearch(int[] arr, int target, int startIndex, int endIndex)
    {
        if(endIndex<startIndex || endIndex<0) {
            return -1;
        } else if(arr[endIndex]==target) {
            return endIndex;
        } else {
            return recursiveSequentialSearch(arr, target, startIndex, endIndex-1);
        }
    }

    public static int binarySearch(int[] arr, int target, int startIndex, int endIndex)
    {
 
		while (startIndex <= endIndex) {
			int midpointIndex = (startIndex+endIndex)/2;
			if (arr[midpointIndex] == target) { return midpointIndex; }
			else if (arr[midpointIndex] < target) { startIndex = midpointIndex + 1; }
			else { endIndex = midpointIndex-1; }
		}
		
		return -1;
    }

    public static int recursiveBinarySearch(int[] arr, int target, int startIndex, int endIndex) 
    {
        int midpointIndex = (startIndex+endIndex)/2;
        if (arr[midpointIndex] == target) { return midpointIndex; }
		else if (arr[midpointIndex] < target) { return recursiveBinarySearch(arr,target,midpointIndex+1,endIndex);}
		else { return recursiveBinarySearch(arr,target,startIndex,midpointIndex-1); }
    }
    
    public static int discreteJudeSearch(int[] arr, int target, int step, int startIndex, int endIndex) 
    {
        endIndex = Math.min(endIndex,arr.length-1);
        step = Math.max(Math.min(step,2+(endIndex-startIndex)),1);

        do {
            startIndex+=step;
        } while (startIndex < endIndex && target > arr[startIndex]);

        if (startIndex > endIndex) {startIndex = endIndex;}

        for (int i = 0; i < step; i++) {
            if (target == arr[startIndex-i]) {return startIndex-i;}
        }
        return -1;
    }

    public static int polynomialJudeSearch(int[] arr, int target, int partitions, int startIndex, int endIndex)
    {
        endIndex = Math.min(endIndex,arr.length-1);
        partitions = Math.max(Math.min(partitions, endIndex-startIndex), 2);
        
        int interval = endIndex-startIndex;
        for (int i = 0; i < partitions+1; i++) {
            if (target == arr[startIndex + interval*i]) {return startIndex+interval*i;}
            else if (target < arr[startIndex + interval*i]) {return polynomialJudeSearch(arr, target, partitions, startIndex, (startIndex+interval*i)-1);}
        }
        return -1;

    }

    private static final class Helpers
    {

        public static void swap(int[] arr, int i1, int i2)
        {
            if (i1>=arr.length || i1<0 || i2>arr.length || i1<0) {
                throw new ArrayIndexOutOfBoundsException("The index's provided are invalid");
            }
            int temp = arr[i1];
            arr[i1] = arr[i2];
            arr[i2] = temp;
        }

    }

}