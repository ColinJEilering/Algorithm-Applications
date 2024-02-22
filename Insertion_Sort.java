//Coding Demonstration of the Insert Sort Alg Theory using a new array method as well as an in-place method

/*Definition: The Insertion Sort Algorithm is a shifting alg that moves elements around in order to result in
ascending order. It sorts an array/list/arraylist by using 1 of 2 methods:

    In-Place Method: Most common method(doesn't require new memory for a 2nd array) that uses the same array to shift
    around indices, in this case, using a for loop and a nested while loop.

    New Array Method: A second array is created, filled with zero's, that is populated one-by-one and shifted around to
    reach ascending order. Only difference is the memory allocation needed for a new array

    Best-case T(O) = O(n)
    Worst-case T(O) = O(n^2)
 */


public class Insertion_Sort {

    static void inPlace(int[] array){
        for(int i = 0; i < array.length; i++){
            int key = array[i];
            int j = i-1;
            while(j >= 0 && array[j] > key){            //Loops down through the indices in order to sort the array, one by one
                array[j+1] = array[j];                  //if the searching integer is greater than 0 and is greater than key
                j--;                                    //then the element at the index is shifted to the right
            }
            array[j+1] = key;                           //while loop stops when the index below the key is less than the current one
        }                                               //or if the index is outside the array bounds(below zero)
    }

    static void newArray(int[] array){
        int[] temp = new int[array.length];

        for(int i = 0; i < array.length; i++){
            int key = array[i];

            int j = 0;
            while(j < i && temp[j] < key){              //Loops through to find where to insert the new index
                j++;                                    //increments the searching var(j) until the next index is greater
            }                                           //than or equal to the key

            for(int k = i; k > j; k--){                 //back tracks and shifts all indices to the right in order to
                temp[k] = temp[k-1];                    //reach the index that is one greater than j
            }

            temp[j] = key;
        }

        for(int i = 0; i < array.length; i++){
            array[i] = temp[i];
        }

    }

    public static void main(String[] args) {
        int[] arr1 = {6,2,5,1,3,4};
        inPlace(arr1);

        System.out.print("In-Place Sorting: ");
        for(int i = 0; i < arr1.length; i++){
            System.out.print(arr1[i] + " ");
        }

        int[] arr2 = {6,2,5,1,3,4};
        newArray(arr2);

        System.out.print("\nNew Array Sorting: ");
        for(int i = 0; i < arr2.length; i++){
            System.out.print(arr2[i] + " ");
        }

    }


}
