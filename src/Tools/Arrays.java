package Tools;

public class Arrays {

    /** Prints a 2D Integer Array **/
    public static void printArr2D(int[][] arr) {
        for (int[] integers : arr) {
            printArr1D(integers);
        }
    }

    /** Prints a 2D String Array **/
    public static void printArr2D(String[][] arr) {
        for (String[] strings : arr) {
            printArr1D(strings);
        }
    }

    /** Prints a 1D Integer Array**/
    public static void printArr1D(int[] arr) {
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    /** Prints a 1D String Array **/
    public static void printArr1D(String[] arr) {
        for (String elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
