import java.util.Arrays;

public class AllAboutArrays_Methods {
    public static void main(String[] args){
        // Ways to Initialize an Array
        int[] arr1 = new int[5]; //dataType[] arrayName = new dataType[size];
        int[] arr2 = new int[]{1,2,3,4,5}; //dataType[] arrayName = new dataType[]{element1,...elementn};
        int[] arr3 = {6,7,8,9,0};//dataType[] arrayName = {element1,...elementn};
        /**
         *
         * Compile-Time: The compiler only checks that the variable type is correct and the syntax is valid.
         * Run-Time: The actual object (array) is created in memory when the program executes.
         *
         * Java allocates memory for an array reference on the stack.
         * [note: arrays are treated as objects in java]
         * The actual memory for the array object is allocated on the Heap.
         * Java initializes arrays with the default values of the respective datatype
         *
         * arrays of primitive datatypes are stored by java in a contiguous fashion, however,
         * arrays of objects (reference types) store the references to the objects contiguously but may store
         * actual object values in a heap-wise manner.
         *
         * arrays sizes are immutable but contents are mutable
         *
         * multidimensional arrays in java can be jagged, meaning each row can have a different number of columns
         * this is permitted because java treats multidimensional arrays as an array of arrays.
         *
         */
        for(int z: arr2){
            System.out.println(z);
        }
        /**
         * Java in-built arrays do not override the toString() method that is inherited from the Object class
         * therefore, to print an array in java use the toString() method in the Arrays utility class
         */
        System.out.println(Arrays.toString(arr2));
        /**
         * Java does not override toString() for arrays because arrays can store primitives and objects,
         * making it difficult to provide a universal implementation.
         *
         * since java is pass by value only, when dealing with objects it passes the value of references to
         * the objects and not the objects themselves.
         * therefore, doing arr1 = arr2 does not copy all elements of arr2 in arr1 but rather just the
         * references, meaning both variables end up pointing to the sanme locations in memory and reflect
         * changes made on each other.
         * hence, use .copyOf()
         */
        arr1 = Arrays.copyOf(arr2, arr2.length);
        System.out.println(Arrays.toString(arr1));
        /**
         * Arrays Class methods
         *
         * .sort() => sorting in ascending order
         * .sort([], start_index, end_index) => sorting for a specified subrange
         * .fill() => filling values in the array
         * .fill([], start_index, end_index, value) => for a specified subrange
         * .equals(arr1, arr2) = > returns true if two arrays are equal. this method compares the two arrays
         * by their contents, both arrays need to be of the same datatype
         * .deepToString() => for multidimensional arrays
         * .deepEquals()
         * .copyOfRange(originalArray, from, to) => returns a new array containing the elements from index
         * from (inclusive) to index to (exclusive).
         *
         * if arr1 == arr2 is done, references will be compared.
         */
        System.out.println(Arrays.equals(arr1, arr2));
        int[][] mdarr = {{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(mdarr));
        /**
         * Reverse an array without using any additional space
         * [following method works for integer number]
         * for floating-point nums use temp var
         */
        int[] origarr = {1,2,3,4,5,6,7,8};
        for(int i=0;i<origarr.length/2;i++){
            origarr[i] = origarr[i]+origarr[(origarr.length-1)-i];
            origarr[(origarr.length-1)-i] = origarr[i]-origarr[(origarr.length-1)-i];
            origarr[i]=origarr[i]-origarr[(origarr.length-1)-i];
        }
        System.out.println(Arrays.toString(origarr));
        /**
         * Find min and max elements in an array
         */
        max_and_min(origarr);
        /**
         * rotate the elements of an array to the right by a given number of positions.
         */
        int[] givenarray = {1,2,3,4,5};
        int k = 2;
        reverse(givenarray, 0, givenarray.length - 1);
        reverse(givenarray, 0, k - 1);
        reverse(givenarray, k, givenarray.length - 1);
        System.out.println(Arrays.toString(givenarray));
        /**
         * count how many times a specific element appears in an array.
         */
        int[] array = {1, 2, 3, 1, 4, 1};
        int element = 1;
        int result = countOccurrences(array, element);
        System.out.println("Element " + element + " occurs " + result + " times.");
    }

    public static void max_and_min(int[] arr){
        int min=arr[0];
        int max=arr[0];
        for(int j=1;j<arr.length;j++){
            if(arr[j]<min){
                min=arr[j];
            }
            if(arr[j]>max){
                max=arr[j];
            }
        }
        System.out.println("Min in given array is "+min);
        System.out.println("Max in given array is "+max);
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static int countOccurrences(int[] arr, int element){
        int count = 0;
        for(int k=0;k<arr.length;k++){
            if(arr[k]==element){
                count++;
            }
        }
        return count;
    }
    /**
    * Arrays are not full fleged objects but rather special objects designed to be close to the low-level for efficiency, 
    * which is why you need the utility class Arrays for functions like sorting, etc. 
    */
}
