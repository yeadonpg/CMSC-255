package Labs.Lab_8;

public class Array {
    public static void main(String[] args) {
        String[] tokens = args[0].split(",");
        String[] customerName = new String[7];

        System.arraycopy(tokens, 0, customerName, 0, tokens.length);

        printArr(customerName);

        moveElem(customerName, 3, 5);
        moveElem(customerName, 4, 6);
        copyElemOver(customerName, 2, 3);
        customerName[4] = "Jessica";
        printArr(customerName);

        removeItemAtIndex(customerName, "Rick");
        printArr(customerName);

        customerName = reverse(customerName);
        printArr(customerName);

    }

    private static void printArr(String[] arr) {
        for (String elem : arr) {
            System.out.println(elem);
        }
        System.out.println("");
    }

    private static void moveElem(String[] arr, int staIndex, int destIndex) {
        String temp = arr[staIndex];
        arr[staIndex] = arr[destIndex];
        arr[destIndex] = temp;
    }

    private static void copyElemOver(String[] arr, int staIndex, int destIndex) {
        arr[destIndex] = arr[staIndex];
    }

    private static void removeItemAtIndex(String[] arr, String elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].equals(elem)) {
                arr[i] = null;
                // Moving elements to the start of the array
                for (int j = i + 1; j < arr.length; j++) {
                    moveElem(arr, j, j - 1);
                }
                i--;
            }
        }
    }

    private static String[] reverse(String[] arr) {
        String[] newArr = new String[arr.length];
        int j = arr.length - 1;
        for (String s : arr) {
            newArr[j] = s;
            j--;
        }
        return newArr;
    }
}
