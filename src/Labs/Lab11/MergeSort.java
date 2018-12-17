package Labs.Lab11;

/*
Author: John Jamora
Code completed on November 28th, 2018
 */

public class MergeSort{
    public static void main(String[] args)  {
        int [] list1 = genArray(20);
        printArray("The array before merge sort: ", list1);
        mergeSort(list1);
        printArray("The array After merge sort: ", list1);
    }
    public static void mergeSort(int [] list){
        if (list.length > 1 ) {
            int mid = list.length / 2 ;
            int [] firstHalf = new int[mid];
            copyArray(list, firstHalf, 0, mid);
            mergeSort(firstHalf); //sorts firstHalf in ascending order by recursion
            int [] secondHalf = new int[list.length - mid];
            copyArray(list, secondHalf, mid, list.length);
            mergeSort(secondHalf); //sorts secondHalf in ascending order by recursion
            // merges to lists ie. firstHalf and second half into a sorted list
            merge(firstHalf, secondHalf, list);
        } //base case
    }
    // generates and returns an array of random numbers of the given size
    public static int[] genArray(int size){ int [] list = new int [size];
        for (int i = 0; i< size; ++i)
            list[i] = (int)(Math.random() * 100 );
        return list;
    }
    // prints an array followed by the header
    public static void printArray(String header, int [] arr) { System.out.println(header);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " " );
        System.out.println();
    }
    //copies from index start to index end of sourceLs to destLs. End is exclusive
    public static void copyArray(int [] sourceLs, int[] destLs, int start, int end){
        for (int i = start; i< end ; i++)
            destLs[i-start] = sourceLs[i];
    }
// develop merge method to complete the program

    public static void merge(int[] firstHalf, int[] secondHalf, int [] list){
        int i = 0, j = 0, k = 0;
        while (i < firstHalf.length && j < secondHalf.length) {
            if (firstHalf[i] <= secondHalf[j]) {
                list[k] = firstHalf[i];
                i++;
            } else {
                list[k] = secondHalf[j];
                j++;
            }
            k++;
        }
        while (i < firstHalf.length) {
            list[k] = firstHalf[i];
            i++;
            k++;
        }
        while (j < secondHalf.length) {
            list[k] = secondHalf[j];
            j++;
            k++;
        }
    }

}

