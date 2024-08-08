import java.util.Arrays;

public class InsertionSort { 
    void sort(int[] array){
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i-1;

            while (j>=0 && array[j]> key) {
                array[j + 1] = array[j];
                j = j-1;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {8,57,6,53,22,0,9,1};

        InsertionSort insertionSorting = new InsertionSort();
        insertionSorting.sort(array);
        System.out.println(Arrays.toString(array));
        
    }
}
