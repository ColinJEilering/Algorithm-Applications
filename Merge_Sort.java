//Attempt to put the Merge Sort Theory into practice, based off of lecture notes of the Divide-And-Conquer principles

/*Definition: Merge Sort uses a recursively-dividing pattern to separate an array/list up in half, making a tree of
"nodes"(indices in this case) that are children of their respective parent. Recursive pattern doesn't stop until the length of the children
are equal to 1. Then the stack executes and automatically sorts the children using the MERGE function.
T(O) = O(n)
 */
public class Merge_Sort {

    static void MERGE(int[] array, int p, int q, int r){
        int[] temp = new int[r-p+1];
        int i = p;
        int j = q+1;
        int k = 0;

        while(i <= q && j <= r){                        //While loop inserts elements up to the smallest sub-array's size.
            if(array[i] <= array[j]){                   //For ex: first half would be [1,2,4] and second half would be [3,5,6,7]
                temp[k] = array[i];                     //This loop would stop after the 4 in the first half is reached
                k++;
                i++;
            }
            else{
                temp[k] = array[j];
                k++;
                j++;
            }
        }
        while(i <= q){                                  //This while loop enters the remaining(if any) elements into the first half
            temp[k] = array[i];                         //entirely depends on the size of each sub-array(indices of i, j, k)
            k++;
            i++;
        }
        while(j <= r){                                  //Final while loop enters the remaining elements of the second half
            temp[k] = array[j];                         //In this ex: our temp array rn is [1,2,3,4,0,0,0]. The while loop will
            k++;                                        //replace the zeros with the corresponding 5,6, and 7
            j++;
        }
        for(i = p; i<= r; i++){                         //simply copying the temp array into the original array
            array[i] = temp[i-p];
        }
    }

    static void MergeSort(int[] array, int p, int r){   //Recursive func to build the stack up for Merge exe.
        if(p < r){
            int q = (p+r)/2;                            //serves as a floor function due to the int type
            MergeSort(array, p, q);
            MergeSort(array, q+1, r);
            MERGE(array, p, q, r);
        }
    }

    public static void main(String[] args) {
        int [] array = {5,1,2,3,3,2,8,45,7};
        MergeSort(array, 0, array.length-1);

        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
