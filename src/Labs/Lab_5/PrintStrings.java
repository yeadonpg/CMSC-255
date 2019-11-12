package Labs.Lab_5;

import java.util.Scanner;

public class PrintStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two words: ");
        String[] words = input.nextLine().trim().split("\\s");
        String word1 = words[0];
        String word2 = words[1];
        if (word1.compareTo(word2) < 0) {
            System.out.println(word1 + "\n" + word2);
        } else {
            System.out.println(word2 + "\n" + word1);
        }
    }
}
