package Testing.Loops;

public class Loops {
    public static void main(String[] args)
    {
        // Looping in 1 dimension

        for (int i = 0; i < 10; i++)
        {
            System.out.printf("%d ", i);
        }

        System.out.println("\n");

        // Looping in 2 dimensions
        // This example is a multiplication table

        for (int j = 0; j < 10; j++)
        {
            for (int k = 0; k < 10; k++)
            {
                // Multiply the j and k coordinates together to get the number for that specific space
                int num = k*j;
                // Parsing numbers so they all take up 2 character spaces
                // This uses a one-line if statement containing an if : else structure
                System.out.print("|" + (num < 10 ? "0" : "") + num);
            }
            // Ending the current line with an endpiece and moving to the next line
            System.out.println("|");
        }

        System.out.println();

        // Looping over an array of objects
        // Declaring an array of a specific data type is simple:
        // EX: Array of int types = int[]
        String[] names = {"Betty", "Adam", "Josh", "Llamar", "Mia", "Olivia"};
        int[] numbers = {2, 3, 7, 7, 11, 11, 15, 15, 19, 29};

        // Printing each name
        for (String s : names)
        {
            System.out.print(s + " ");
        }
        System.out.println();

        // Printing each number
        for (int i : numbers)
        {
            System.out.printf("%d ", i);
        }
    }
}