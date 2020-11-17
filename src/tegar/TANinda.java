package tegar;

public class TANinda {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int r = 2;
        int n = arr.length;
        printCombination(arr, n, r);

//        int[][] board = new int[7][4];
//        for (int row = 0; row < board.length; row++) {
//            for (int col = 0; col < board[row].length; col++) {
//                board[0][col] = col +1;
//            }
//        }
//        System.out.println("array "+board[0][0]);
//        System.out.println("array "+board[0][1]);
//        System.out.println("array "+board[0][2]);
//        System.out.println("array "+board[0][3]);
//
//        for (int i=0;i<6;i++){
//
//        }
    }
    static void combinationUtil(int arr[], int n, int r, int index,
                                int data[], int i)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            for (int j=0; j<r; j++){
                System.out.print(data[j]+" ");
            }
            System.out.println("");
            return;
        }

        // When no more elements are there to put in data[]
        if (i >= n)
            return;

        // current is included, put next at next location
        data[index] = arr[i];
        combinationUtil(arr, n, r, index+1, data, i+1);

        // current is excluded, replace it with next (Note that
        // i+1 is passed, but index is not changed)
        combinationUtil(arr, n, r, index, data, i+1);
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(int arr[], int n, int r)
    {
        // A temporary array to store all combination one by one
        int data[]=new int[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, n, r, 0, data, 0);
    }
}
